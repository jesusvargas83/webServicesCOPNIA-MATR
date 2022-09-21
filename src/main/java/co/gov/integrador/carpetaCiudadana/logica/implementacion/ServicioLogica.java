package co.gov.integrador.carpetaCiudadana.logica.implementacion;

import java.net.IDN;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import co.gov.integrador.carpetaCiudadana.datos.acceso.interfaz.CertificateInformationService;
import co.gov.integrador.carpetaCiudadana.datos.acceso.interfaz.TokenAutenticacionService;
import co.gov.integrador.carpetaCiudadana.datos.modelo.CertificadosMatriculado;
import co.gov.integrador.carpetaCiudadana.datos.modelo.DatosMatriculadoResponse;
import co.gov.integrador.carpetaCiudadana.datos.modelo.TokenAutenticacion;
import co.gov.integrador.carpetaCiudadana.excepcion.LogicaException;
import co.gov.integrador.carpetaCiudadana.exposicion.api.ApiUtil;
import co.gov.integrador.carpetaCiudadana.exposicion.api.ServicioApiDelegate;
import co.gov.integrador.carpetaCiudadana.modelo.dto.InformacionDTO;
import co.gov.integrador.carpetaCiudadana.modelo.dto.InformacionDatoConsultadoDTO;
import co.gov.integrador.carpetaCiudadana.utilidad.PropiedadesUtilidad;
import co.gov.integrador.carpetaCiudadana.utilidad.Servicio;

@Service
public class ServicioLogica implements ServicioApiDelegate, ServicioCiudadanoValidable {

	private static final Logger LOGGER = LogManager.getLogger(ServicioLogica.class);;

	@Autowired
	private PropiedadesUtilidad propiedades;

	@Autowired
	TokenAutenticacionService tokenAutenticacionService;

	@Autowired
	CertificateInformationService certificateInformationService;

	@Override
	public ResponseEntity<InformacionDTO> consultaInformacion(String tipoId, String idUsuario) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"urlDescarga\" : \"urlDescarga\",  \"datoConsultado\" : [ {    \"nombreArchivo\" : \"nombreArchivo\",    \"valorDato\" : \"valorDato\",    \"descripcionArchivo\" : \"descripcionArchivo\",    \"tipoArchivo\" : \"tipoArchivo\",    \"campoDato\" : \"campoDato\"  }, {    \"nombreArchivo\" : \"nombreArchivo\",    \"valorDato\" : \"valorDato\",    \"descripcionArchivo\" : \"descripcionArchivo\",    \"tipoArchivo\" : \"tipoArchivo\",    \"campoDato\" : \"campoDato\"  } ]}");
					break;
				}
			}
		});
		try {
			validacionTipica(tipoId, idUsuario);
			InformacionDTO dto = consultarInformacionUsuario(tipoId, idUsuario);

			ResponseEntity<InformacionDTO> re = new ResponseEntity<InformacionDTO>(dto, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			LOGGER.error(propiedades.MENSAJE_EXPOSICION_EXCEPTION, e);
			return manejarExcepcionNegocio(e, Servicio.SERVICIO);
		}
	}

	private InformacionDTO consultarInformacionUsuario(String tipoId, String idUsuario) throws LogicaException {
		InformacionDTO informacionDTO = new InformacionDTO();

		try {
			List<InformacionDatoConsultadoDTO> informacionDatoConsultadoDTOList = new ArrayList<InformacionDatoConsultadoDTO>();
			informacionDTO.setUrlDescarga("");

			TokenAutenticacion token = tokenAutenticacionService.obtenerToken();
			DatosMatriculadoResponse respuesta = certificateInformationService.obtenerDatosMatriculado(token.getAccess_token(), tipoId, idUsuario);
	
			if (respuesta.getPersonInformation() != null) {
				InformacionDatoConsultadoDTO informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();

				informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_1_SERVICIO_CONSULTA);
				informacionDatoConsultadoDTO.setValorDato(respuesta.getPersonInformation().getDocumentType());
			    informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

				informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
				informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_2_SERVICIO_CONSULTA);
				informacionDatoConsultadoDTO.setValorDato(respuesta.getPersonInformation().getDocumentNumber());
			    informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

				informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
				informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_3_SERVICIO_CONSULTA);
				informacionDatoConsultadoDTO.setValorDato(respuesta.getPersonInformation().getFirstName());
			    informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

				informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
				informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_4_SERVICIO_CONSULTA);
				informacionDatoConsultadoDTO.setValorDato(respuesta.getPersonInformation().getSecondName());
			    informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

				informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
				informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_5_SERVICIO_CONSULTA);
				informacionDatoConsultadoDTO.setValorDato(respuesta.getPersonInformation().getLastName());
			    informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

				informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
				informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_6_SERVICIO_CONSULTA);
				informacionDatoConsultadoDTO.setValorDato(respuesta.getPersonInformation().getSecondLastName());
			    informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

				for (CertificadosMatriculado certificado : respuesta.getPersonInformation().getCertificates()) {

					informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
					informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_7_SERVICIO_CONSULTA);
					informacionDatoConsultadoDTO.setValorDato(certificado.getCertificateNumber());
					informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

					informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
					informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_8_SERVICIO_CONSULTA);
					informacionDatoConsultadoDTO.setValorDato(certificado.getProfessionName());
					informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);

					URL url= new URL(propiedades.URL_BASE_CERTIFICADO + certificado.getCertificateNumber());
					URI uri = new URI(url.getProtocol(), url.getUserInfo(), IDN.toASCII(url.getHost()), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        			String correctEncodedURL = uri.toASCIIString();

					informacionDatoConsultadoDTO = new InformacionDatoConsultadoDTO();
					informacionDatoConsultadoDTO.setCampoDato(propiedades.DATO_9_SERVICIO_CONSULTA);
					informacionDatoConsultadoDTO.setValorDato(correctEncodedURL);
					informacionDatoConsultadoDTOList.add(informacionDatoConsultadoDTO);
				}
			}			

			informacionDTO.setDatoConsultado(informacionDatoConsultadoDTOList);

		} catch (Exception e) {
			LOGGER.error(propiedades.MENSAJE_LOGICA_EXCEPTION, e);
			throw new LogicaException(LogicaException.CodigoMensaje.ESTADO_DESCONOCIDO, e.getMessage());
		}

		return informacionDTO;
	}
}