package magneticmedia.magneticmedia.security;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateIpAddressAnnotation.class)
@Documented
public @interface ValidateIpAddress {

    String message() default "Server IP should be a valid ipV4 address";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
