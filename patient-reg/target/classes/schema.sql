CREATE TABLE patient (
    id BIGINT NOT NULL,
    patient_address VARCHAR(255),
    patient_county VARCHAR(255),
    patient_dob DATE,
    patient_email VARCHAR(255),
    patient_gender VARCHAR(255),
    patient_id_number VARCHAR(255),
    patient_marital_status VARCHAR(255),
    patient_name VARCHAR(255),
    patient_subcounty VARCHAR(255),
    patient_tel VARCHAR(255),
    kin_dob DATE,
    kin_gender VARCHAR(255),
    kin_id_number VARCHAR(255),
    kin_name VARCHAR(255),
    kin_relationship VARCHAR(255),
    kin_tel VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE SEQUENCE patient_sequence
    START WITH 1000
    INCREMENT BY 1;
