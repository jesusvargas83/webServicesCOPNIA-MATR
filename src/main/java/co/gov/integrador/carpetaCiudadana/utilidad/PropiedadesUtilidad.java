/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.integrador.carpetaCiudadana.utilidad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 *
 * @author AND
 */
@Service
@PropertySource(ignoreResourceNotFound = true, value = "classpath:propiedades.properties")
public class PropiedadesUtilidad {

    @Value("${MENSAJE_DAO_EXCEPTION}")
    public String MENSAJE_DAO_EXCEPTION;

    @Value("${MENSAJE_LOGICA_EXCEPTION}")
    public String MENSAJE_LOGICA_EXCEPTION;

    @Value("${MENSAJE_EXPOSICION_EXCEPTION}")
    public String MENSAJE_EXPOSICION_EXCEPTION;

    @Value("${MENSAJE_CONSULTA_NO_VALORES}")
    public String MENSAJE_CONSULTA_NO_VALORES;

    @Value("${FORMATO_FECHA}")
    public String FORMATO_FECHA;

    @Value("${DATO_1_SERVICIO_CONSULTA}")
    public String DATO_1_SERVICIO_CONSULTA;

    @Value("${DATO_2_SERVICIO_CONSULTA}")
    public String DATO_2_SERVICIO_CONSULTA;

    @Value("${DATO_3_SERVICIO_CONSULTA}")
    public String DATO_3_SERVICIO_CONSULTA;

    @Value("${DATO_4_SERVICIO_CONSULTA}")
    public String DATO_4_SERVICIO_CONSULTA;

    @Value("${DATO_5_SERVICIO_CONSULTA}")
    public String DATO_5_SERVICIO_CONSULTA;

    @Value("${DATO_6_SERVICIO_CONSULTA}")
    public String DATO_6_SERVICIO_CONSULTA;

    @Value("${DATO_7_SERVICIO_CONSULTA}")
    public String DATO_7_SERVICIO_CONSULTA;

    @Value("${DATO_8_SERVICIO_CONSULTA}")
    public String DATO_8_SERVICIO_CONSULTA;

    @Value("${DATO_9_SERVICIO_CONSULTA}")
    public String DATO_9_SERVICIO_CONSULTA;

    @Value("${ID_TOKEN}")
    public String ID_TOKEN;

    @Value("${URL_BASE_CERTIFICADO}")
    public String URL_BASE_CERTIFICADO;

    @Value("${URL_CONSUMO_TOKEN}")
    public String URL_CONSUMO_TOKEN;

    @Value("${URL_CONSUMO_SERVICIO_DATOS_MATRICULADO}")
    public String URL_CONSUMO_SERVICIO_DATOS_MATRICULADO;
    
}
