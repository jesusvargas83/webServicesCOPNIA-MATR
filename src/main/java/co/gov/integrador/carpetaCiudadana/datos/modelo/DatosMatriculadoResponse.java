package co.gov.integrador.carpetaCiudadana.datos.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatosMatriculadoResponse {

    @JsonProperty("PersonInformation")
    PersonalInformation PersonInformation;

    @JsonProperty("MessageResult")
    String MessageResult;

    @JsonProperty("Successful")
    String Successful;

    public DatosMatriculadoResponse() {
    }

    public DatosMatriculadoResponse(PersonalInformation personInformation, String messageResult, String successful) {
        PersonInformation = personInformation;
        MessageResult = messageResult;
        Successful = successful;
    }

    public PersonalInformation getPersonInformation() {
        return PersonInformation;
    }

    public void setPersonInformation(PersonalInformation personInformation) {
        PersonInformation = personInformation;
    }

    public String getMessageResult() {
        return MessageResult;
    }

    public void setMessageResult(String messageResult) {
        MessageResult = messageResult;
    }

    public String getSuccessful() {
        return Successful;
    }

    public void setSuccessful(String successful) {
        Successful = successful;
    }

    
    
}
