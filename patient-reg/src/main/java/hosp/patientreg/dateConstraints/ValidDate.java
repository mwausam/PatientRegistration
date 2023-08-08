package hosp.patientreg.dateConstraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = LocalDateValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@DateTimeFormat(pattern = "dd/MM/yyyy")
public @interface ValidDate {
    String message() default "Invalid date format. Please use dd/mm/yyyy";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



