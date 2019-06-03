package com.hhandoko.svm.flyway;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import org.flywaydb.core.api.logging.Log;
import org.flywaydb.core.internal.logging.slf4j.Slf4jLog;
import org.slf4j.LoggerFactory;

@TargetClass(className = "org.flywaydb.core.api.logging.LogFactory")
@Substitute
public final class FlywayLogFactorySubstitution {

    @Substitute
    public static Log getLog(Class<?> clazz) {
        return new Slf4jLog(LoggerFactory.getLogger(clazz.getName()));
    }

}
