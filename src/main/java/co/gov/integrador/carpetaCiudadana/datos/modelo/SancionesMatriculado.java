package co.gov.integrador.carpetaCiudadana.datos.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SancionesMatriculado {

    @JsonProperty("SanctionTypeCode")
    String SanctionTypeCode;

    @JsonProperty("SanctionType")
    String SanctionType;

    @JsonProperty("SanctionStartDate")
    String SanctionStartDate;

    @JsonProperty("SanctionEndDate")
    String SanctionEndDate;

    public SancionesMatriculado() {
    }
    public SancionesMatriculado(String sanctionTypeCode, String sanctionType, String sanctionStartDate,
            String sanctionEndDate) {
        SanctionTypeCode = sanctionTypeCode;
        SanctionType = sanctionType;
        SanctionStartDate = sanctionStartDate;
        SanctionEndDate = sanctionEndDate;
    }
    public String getSanctionTypeCode() {
        return SanctionTypeCode;
    }
    public void setSanctionTypeCode(String sanctionTypeCode) {
        SanctionTypeCode = sanctionTypeCode;
    }
    public String getSanctionType() {
        return SanctionType;
    }
    public void setSanctionType(String sanctionType) {
        SanctionType = sanctionType;
    }
    public String getSanctionStartDate() {
        return SanctionStartDate;
    }
    public void setSanctionStartDate(String sanctionStartDate) {
        SanctionStartDate = sanctionStartDate;
    }
    public String getSanctionEndDate() {
        return SanctionEndDate;
    }
    public void setSanctionEndDate(String sanctionEndDate) {
        SanctionEndDate = sanctionEndDate;
    }
    
}
