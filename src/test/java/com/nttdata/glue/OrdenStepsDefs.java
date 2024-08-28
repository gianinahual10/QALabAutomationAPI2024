package com.nttdata.glue;

import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrdenStepsDefs {

    @Steps
    OrdenStep ordenStep;

    @When("creo la orden con id {int}")
    public void crearOrden(int id){
        ordenStep.crearOrden(id);
    }


    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
       ordenStep.validarCodigoRespuesta(statusCode);
    }

    //=============== Scenario 2 ==================
    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        ordenStep.definirurl(url); //metodo que existe en la clase ArticuloStep
    }

    @When("hago la consulta de la orden con id {int}")
    public void consultarOrden(int id) {
        ordenStep.consultarOrden(id);
    }

    @Then("imprimo la orden")
    public void imprimirOrden() {
        ordenStep.imprimirOrden();
    }

}
