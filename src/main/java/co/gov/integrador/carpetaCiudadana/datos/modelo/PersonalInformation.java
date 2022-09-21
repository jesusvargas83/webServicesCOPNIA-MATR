package co.gov.integrador.carpetaCiudadana.datos.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonalInformation {

    @JsonProperty("DocumentType")
    String DocumentType;

    @JsonProperty("DocumentNumber")
    String DocumentNumber ;

    @JsonProperty("FirstName")
    String FirstName;

    @JsonProperty("SecondName")
    String SecondName;

    @JsonProperty("LastName")
    String LastName;

    @JsonProperty("SecondLastName")
    String SecondLastName;

    @JsonProperty("Certificates")
    List<CertificadosMatriculado> Certificates;

    public PersonalInformation() {
    }

    public PersonalInformation(String documentType, String documentNumber, String firstName, String secondName,
            String lastName, String secondLastName, List<CertificadosMatriculado> certificates) {
        DocumentType = documentType;
        DocumentNumber = documentNumber;
        FirstName = firstName;
        SecondName = (secondName != null) ? secondName : "";
        LastName = lastName;
        SecondLastName = (secondLastName != null) ? secondLastName : "";
        Certificates = certificates;
    }

    public String getDocumentType() {
        return DocumentType;
    }
    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }
    public String getDocumentNumber() {
        return DocumentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getSecondName() {
        return SecondName;
    }
    public void setSecondName(String secondName) {
        SecondName = (secondName != null) ? secondName : "";
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getSecondLastName() {
        return SecondLastName;
    }
    public void setSecondLastName(String secondLastName) {
        SecondLastName = (secondLastName != null) ? secondLastName : "";
    }
    public List<CertificadosMatriculado> getCertificates() {
        return Certificates;
    }
    public void setCertificates(List<CertificadosMatriculado> certificates) {
        Certificates = certificates;
    }    
}
