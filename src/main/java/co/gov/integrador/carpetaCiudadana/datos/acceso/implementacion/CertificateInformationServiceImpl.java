package co.gov.integrador.carpetaCiudadana.datos.acceso.implementacion;

import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import co.gov.integrador.carpetaCiudadana.datos.acceso.interfaz.CertificateInformationService;
import co.gov.integrador.carpetaCiudadana.datos.modelo.DatosMatriculadoResponse;
import co.gov.integrador.carpetaCiudadana.excepcion.DAOException;
import co.gov.integrador.carpetaCiudadana.utilidad.PropiedadesUtilidad;
import io.searchbox.client.http.apache.HttpGetWithEntity;

@Service
public class CertificateInformationServiceImpl implements CertificateInformationService {

    private static final Logger LOGGER = LogManager.getLogger(CertificateInformationServiceImpl.class);

    @Autowired
    PropiedadesUtilidad propiedades;

    @Override
    public DatosMatriculadoResponse obtenerDatosMatriculado(String token, String tipoDocumento, String documento) throws DAOException {

        switch(tipoDocumento){

            case "CC":
            tipoDocumento = "1";
            break;
            case "CE":
            tipoDocumento = "2";
            break;
        }

        String url = propiedades.URL_CONSUMO_SERVICIO_DATOS_MATRICULADO;

        JsonObject body = new JsonObject();
        body.addProperty("DocumentTypeCode", tipoDocumento);
        body.addProperty("DocumentNumber", documento);
        DatosMatriculadoResponse consulta = new DatosMatriculadoResponse();

        try {
            StringEntity entityValue = new StringEntity(body.toString());

            CloseableHttpClient client = HttpClients.createDefault();
            HttpGetWithEntity httpGetWithEntity = new HttpGetWithEntity(url);
            httpGetWithEntity.setEntity(entityValue);
            httpGetWithEntity.setHeader("Authorization", "Bearer " + token);
            httpGetWithEntity.setHeader("Content-Type", "application/json");
            CloseableHttpResponse responseClient = client.execute(httpGetWithEntity);

            int statusCode = responseClient.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.OK.value()) {
                HttpEntity entityResponse = responseClient.getEntity();

                String readResponse = "";
                if (entityResponse != null) {
                    Reader reader = new InputStreamReader(entityResponse.getContent());
                    
                    while (true) {
                        int chr = reader.read();
                        if (chr == -1) {
                            break;
                        }
                        readResponse += (char) chr;
                    }
                }
                client.close();

                ObjectMapper objectMapper = new ObjectMapper();
                consulta = objectMapper.readValue(readResponse, DatosMatriculadoResponse.class);
                
            }        
            else{
                throw new DAOException(propiedades.MENSAJE_DAO_EXCEPTION);
            }
        } 
        catch (Exception e) {
            LOGGER.error(propiedades.MENSAJE_DAO_EXCEPTION, e);
            throw new DAOException(propiedades.MENSAJE_DAO_EXCEPTION);
        }
        return consulta;
    }
    
}
