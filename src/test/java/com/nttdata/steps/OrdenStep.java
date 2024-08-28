package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class OrdenStep {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden {0} en PetStore")
    public void crearOrden(int id){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2024-08-28T13:12:00.899Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
        ;

    }

    @Step("Validar el código de respuesta {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    private static String URL = null;

    @Step("Definir URL base")
    public void definirurl(String url){
        URL = url;
    };

    @Step("Consultar orden con id {0} en PetStore")
    public void consultarOrden(int id){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(URL + "/" + id)
                .then()
                .log().all();
    };

    @Step("Imprimir detalles de la orden")
    public void imprimirOrden() {
        SerenityRest.then()
                .log().all();
    }

}
