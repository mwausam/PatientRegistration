package hosp.patientreg.dateConstraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateValidator implements ConstraintValidator<ValidDate, LocalDate> {
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        // Nothing to initialize
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        try {
            DATE_FORMATTER.format(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
