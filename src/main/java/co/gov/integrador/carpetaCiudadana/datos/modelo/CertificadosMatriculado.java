package co.gov.integrador.carpetaCiudadana.datos.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CertificadosMatriculado {

    @JsonProperty("CertificateNumber")
    String CertificateNumber ;

    @JsonProperty("CertificateDate")
    String CertificateDate ;

    @JsonProperty("CertificateType")
    String CertificateType ;

    @JsonProperty("CertificateStatus")
    String CertificateStatus ;

    @JsonProperty("ProfessionName")
    String ProfessionName ;

    @JsonProperty("IESName")
    String IESName ;

    @JsonProperty("CampusName")
    String CampusName ;

    @JsonProperty("Sectional")
    String Sectional ;

    @JsonProperty("ResolutionIndividualNumber")
    String ResolutionIndividualNumber ;

    @JsonProperty("ResolutionDate")
    String ResolutionDate ;

    @JsonProperty("DegreeCertificateDate")
    String DegreeCertificateDate ;

    @JsonProperty("DegreeCertificateNumber")
    String DegreeCertificateNumber ;

    @JsonProperty("CampusCertificateNumber")
    String CampusCertificateNumber; 

    @JsonProperty("CampusCertificateDate")
    String CampusCertificateDate ; 

    @JsonProperty("HasSanctions")
    boolean HasSanctions ;
    
    @JsonProperty("Sanctions")
    List<SancionesMatriculado> Sanctions;

public CertificadosMatriculado() {
}

public CertificadosMatriculado(String certificateNumber, String certificateDate, String certificateType,
        String certificateStatus, String professionName, String iESName, String campusName, String sectional,
        String resolutionIndividualNumber, String resolutionDate, String degreeCertificateDate,
        String degreeCertificateNumber, String campusCertificateNumber, boolean hasSanctions,
        List<SancionesMatriculado> sanctions) {
    CertificateNumber = certificateNumber;
    CertificateDate = certificateDate;
    CertificateType = certificateType;
    CertificateStatus = certificateStatus;
    ProfessionName = professionName;
    IESName = iESName;
    CampusName = campusName;
    Sectional = sectional;
    ResolutionIndividualNumber = resolutionIndividualNumber;
    ResolutionDate = resolutionDate;
    DegreeCertificateDate = degreeCertificateDate;
    DegreeCertificateNumber = degreeCertificateNumber;
    CampusCertificateNumber = campusCertificateNumber;
    HasSanctions = hasSanctions;
    Sanctions = sanctions;
}

public String getCertificateNumber() {
    return CertificateNumber;
}

public void setCertificateNumber(String certificateNumber) {
    CertificateNumber = certificateNumber;
}

public String getCertificateDate() {
    return CertificateDate;
}

public void setCertificateDate(String certificateDate) {
    CertificateDate = certificateDate;
}

public String getCertificateType() {
    return CertificateType;
}

public void setCertificateType(String certificateType) {
    CertificateType = certificateType;
}

public String getCertificateStatus() {
    return CertificateStatus;
}

public void setCertificateStatus(String certificateStatus) {
    CertificateStatus = certificateStatus;
}

public String getProfessionName() {
    return ProfessionName;
}

public void setProfessionName(String professionName) {
    ProfessionName = professionName;
}

public String getIESName() {
    return IESName;
}

public void setIESName(String iESName) {
    IESName = iESName;
}

public String getCampusName() {
    return CampusName;
}

public void setCampusName(String campusName) {
    CampusName = campusName;
}

public String getSectional() {
    return Sectional;
}

public void setSectional(String sectional) {
    Sectional = sectional;
}

public String getResolutionIndividualNumber() {
    return ResolutionIndividualNumber;
}

public void setResolutionIndividualNumber(String resolutionIndividualNumber) {
    ResolutionIndividualNumber = resolutionIndividualNumber;
}

public String getResolutionDate() {
    return ResolutionDate;
}

public void setResolutionDate(String resolutionDate) {
    ResolutionDate = resolutionDate;
}

public String getDegreeCertificateDate() {
    return DegreeCertificateDate;
}

public void setDegreeCertificateDate(String degreeCertificateDate) {
    DegreeCertificateDate = degreeCertificateDate;
}

public String getDegreeCertificateNumber() {
    return DegreeCertificateNumber;
}

public void setDegreeCertificateNumber(String degreeCertificateNumber) {
    DegreeCertificateNumber = degreeCertificateNumber;
}

public String getCampusCertificateNumber() {
    return CampusCertificateNumber;
}

public void setCampusCertificateNumber(String campusCertificateNumber) {
    CampusCertificateNumber = campusCertificateNumber;
}

public boolean isHasSanctions() {
    return HasSanctions;
}

public void setHasSanctions(boolean hasSanctions) {
    HasSanctions = hasSanctions;
}

public List<SancionesMatriculado> getSanctions() {
    return Sanctions;
}

public void setSanctions(List<SancionesMatriculado> sanctions) {
    Sanctions = sanctions;
}


 
}
