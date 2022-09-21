package co.gov.integrador.carpetaCiudadana.datos.acceso.implementacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.gov.integrador.carpetaCiudadana.datos.acceso.interfaz.TokenAutenticacionService;
import co.gov.integrador.carpetaCiudadana.datos.modelo.TokenAutenticacion;
import co.gov.integrador.carpetaCiudadana.excepcion.DAOException;
import co.gov.integrador.carpetaCiudadana.utilidad.PropiedadesUtilidad;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@Service
public class TokenAutenticacionServiceImpl implements TokenAutenticacionService{

    private static final Logger LOGGER = LogManager.getLogger(TokenAutenticacionServiceImpl.class);

    @Autowired
    PropiedadesUtilidad propiedades;
    
    @Override
    public TokenAutenticacion obtenerToken() throws DAOException {
       
        OkHttpClient client = new OkHttpClient().newBuilder()
        .build();

      MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
      RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials");
      
      Request request = new Request.Builder()
        .url(propiedades.URL_CONSUMO_TOKEN)
        .method("POST", body)
        .addHeader("Authorization", propiedades.ID_TOKEN)
        .addHeader("Content-Type", "application/x-www-form-urlencoded")
        .build();
        try{
            ResponseBody response = client.newCall(request).execute().body();
            String respuesta = response.string();
            ObjectMapper objectMapper = new ObjectMapper();
            TokenAutenticacion token = objectMapper.readValue(respuesta, TokenAutenticacion.class);
            return token;            
        }
          catch (Exception e) {
              LOGGER.error(propiedades.MENSAJE_DAO_EXCEPTION, e);
             throw new DAOException(propiedades.MENSAJE_DAO_EXCEPTION);
         }
    }
    
}
