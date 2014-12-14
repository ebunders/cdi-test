package org.cdi.advocacy.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ernst on 14-12-14.
 */
@Qualifier
@Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface Transportation {
    TransportType type() default TransportType.STANDARD;
}
