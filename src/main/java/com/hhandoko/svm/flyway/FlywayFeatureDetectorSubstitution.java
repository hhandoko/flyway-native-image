package com.hhandoko.svm.flyway;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

/**
 * Substitutes `FeatureDetector` which loads the relevant logging framework dynamically via classpath scanning.
 *
 * In this class we enable Slf4j (API). If no options are enabled, Flyway will default to Java Util Logging.
 *
 * See:
 *   - https://github.com/quarkusio/quarkus/issues/1575#issuecomment-474349823
 *   - https://github.com/quarkusio/quarkus/pull/1649
 */
@TargetClass(className = "org.flywaydb.core.internal.util.FeatureDetector")
@Substitute
public final class FlywayFeatureDetectorSubstitution {

    @Substitute
    public FlywayFeatureDetectorSubstitution(ClassLoader classLoader) {
    }

    @Substitute
    public boolean isApacheCommonsLoggingAvailable() {
        return false;
    }

    @Substitute
    public boolean isSlf4jAvailable() {
        return true;
    }

    @Substitute
    public boolean isJBossVFSv2Available() {
        return false;
    }

    @Substitute
    public boolean isJBossVFSv3Available() {
        return false;
    }

    @Substitute
    public boolean isOsgiFrameworkAvailable() {
        return false;
    }

    @Substitute
    public boolean isAndroidAvailable() {
        return false;
    }

}
