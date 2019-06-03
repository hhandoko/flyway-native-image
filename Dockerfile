FROM         oracle/graalvm-ce:19.0.0 as assembler
LABEL        maintainer="Herdy Handoko <herdy.handoko@gmail.com>"
LABEL        description="GraalVM-based all-in-one JAR builder"

COPY         . /home/app/
WORKDIR      /home/app

RUN          ./gradlew --no-daemon assemble

# ~~~~~~

FROM         oracle/graalvm-ce:19.0.0  as packager
LABEL        maintainer="Herdy Handoko <herdy.handoko@gmail.com>"
LABEL        description="GraalVM-based native-image builder"

COPY         --from=assembler /home/app/build/libs/ /home/app/
WORKDIR      /home/app

RUN          gu install native-image
RUN          native-image \
               --no-server \
               -cp /home/app/*.jar \

# ~~~~~~

FROM         frolvlad/alpine-glibc
LABEL        maintainer="Herdy Handoko <herdy.handoko@gmail.com>"
LABEL        description="GraalVM native-image runtime container"

COPY         --from=packager /home/app/flyway ./

EXPOSE       8080
ENTRYPOINT   ["./flyway"]
