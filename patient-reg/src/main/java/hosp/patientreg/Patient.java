package hosp.patientreg;

import java.time.LocalDate;


import hosp.patientreg.dateConstraints.ValidDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_sequence", initialValue = 1000,allocationSize = 1)
    private long id;

    @Pattern(regexp = "^[A-Za-z][\\w ]+$", message = "Enter a valid name")
    private String patientName;


    @Pattern(regexp = "^0\\d{9}$", message = "Enter a valid Telephone number starting with 0 and has 10 digits")
    private String patientTel;


    //@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", 
    //message = "Valid date of birth format is dd/mm/yyyy")
    @ValidDate(message = "Valid date of birth format is dd/mm/yyyy")
    private LocalDate patientDob;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender patientGender;


    @Pattern(regexp = "^\\d{8}$", message = "Enter a valid number with 8 numbers")
    private String patientIdNumber;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Marital status is required")
    private MaritalStatus patientMaritalStatus;


    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email")
    private String patientEmail;

    @NotBlank(message = "Address is required")
    private String patientAddress;


    @Pattern(regexp = "^[A-Za-z][\\w ]+$", message = "Enter a valid county name")
    private String patientCounty;


    @Pattern(regexp = "^[A-Za-z][\\w ]+$", message = "Enter a valid subcounty name")
    private String patientSubcounty;


    @Pattern(regexp = "^[A-Za-z][\\w ]+$", message = "Enter a valid name")
    private String kinName;


    @Pattern(regexp = "^0\\d{9}$", message = "Enter a valid Telephone number starting with 0 and has 10 digits")
    private String kinTel;


    //@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", 
    //message = "Enter a valid date of birth format is dd/mm/yyyy")
    @ValidDate(message = "Valid date of birth format is dd/mm/yyyy")
    private LocalDate kinDob;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender kinGender;


    @Pattern(regexp = "^\\d{8}$", message = "Enter a valid number with 8 numbers")
    private String kinIdNumber;


    @Pattern(regexp = "^[A-Za-z][\\w ]+$", message = "Enter a valid relationship name")
    private String kinRelationship;

    private enum Gender{
        MALE,FEMALE
    }

    private enum MaritalStatus{
        SINGLE,MARRIED
    }


    @PostPersist
    private void afterSavingPatient(){
        log.info("The patient has been successfully saved in the database: " +this.toString());

        //String senderEmail = "";
        //String senderPassword = "";
        //send email to patient 
        //SendMail.sendGmailEmail(patientName,id,patientEmail,senderEmail,senderPassword);
    }

}
