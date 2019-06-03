[![License](https://img.shields.io/badge/license-Apache--2.0-brightgreen.svg)](LICENSE)

# flyway-native-image

`flyway-native-image` is an exploration of Flyway database migrations in Graal (SubstrateVM) native image.

## Prerequisites

Ensure the following dependencies are installed and configured:

  - [Java SDK] 8+
  - [GraalVM] 19.x (optional)
  - [Docker and Docker Compose] (optional)

## Setup Steps

  1. Run `docker-compose up -d db` to start the database via `docker-compose` (optional)
  1. Run `./gradlew run` to start the database migration

### Production Packaging (uber-jar)

To package and run it as an uber-jar:

  1. Run `./gradlew shadowJar` to package the application into an uber-jar (`flyway-native-image-1.0.0-SNAPSHOT-all.jar`)
  1. Run `java -jar build/libs/flyway-native-image-1.0.0-SNAPSHOT-all.jar` to run the database migrator
  
## Contributing

We follow the "[feature-branch]" Git workflow.

  1. Commit changes to a branch in your fork (use `snake_case` convention):
     - For technical chores, use `chore/` prefix followed by the short description, e.g. `chore/do_this_chore`
     - For new features, use `feature/` prefix followed by the feature name, e.g. `feature/feature_name`
     - For bug fixes, use `bug/` prefix followed by the short description, e.g. `bug/fix_this_bug`
  1. Rebase or merge from "upstream"
  1. Submit a PR "upstream" to `develop` branch with your changes

Please read [CONTRIBUTING] for more details.

## License

```
    Copyright (c) 2019 flyway-native-image Contributors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```

`flyway-native-image` is released under the Apache Version 2.0 License. See the [LICENSE] file for further details.

[CONTRIBUTING]: https://github.com/hhandoko/lyway-native-image/blob/master/CONTRIBUTING.md
[DOcker and Docker Compose]: https://docs.docker.com/compose/
[feature-branch]: http://nvie.com/posts/a-successful-git-branching-model/
[GraalVM]: https://www.graalvm.org/
[Java SDK]: https://adoptopenjdk.net/
[LICENSE]: https://github.com/hhandoko/flyway-native-image/blob/master/LICENSE
