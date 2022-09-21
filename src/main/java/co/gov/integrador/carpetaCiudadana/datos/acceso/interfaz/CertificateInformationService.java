package co.gov.integrador.carpetaCiudadana.datos.acceso.interfaz;

import co.gov.integrador.carpetaCiudadana.datos.modelo.DatosMatriculadoResponse;
import co.gov.integrador.carpetaCiudadana.excepcion.DAOException;

public interface CertificateInformationService {
    
    DatosMatriculadoResponse obtenerDatosMatriculado(String token, String tipoDocumento, String documento) throws DAOException;

}
