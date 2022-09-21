package co.gov.integrador.carpetaCiudadana.datos.acceso.interfaz;

import co.gov.integrador.carpetaCiudadana.datos.modelo.TokenAutenticacion;
import co.gov.integrador.carpetaCiudadana.excepcion.DAOException;

public interface TokenAutenticacionService {

    TokenAutenticacion obtenerToken() throws DAOException;

}
