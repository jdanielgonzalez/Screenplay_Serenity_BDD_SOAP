package co.com.sofka.stepdefnitions.soap.information.capital_name;

import co.com.sofka.stepdefnitions.soap.information.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.sofka.questions.ReturnStringValue.systemValue;
import static co.com.sofka.tasks.information.DoPost.doPost;
import static co.com.sofka.util.FileUtilities.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.containsString;

public class CapitalNameWithCucumberStepDefinition extends SetUp {

    private static final String CAPITAL_NAME_XML = System.getProperty("user.dir") + "\\src\\test\\resources\\information\\capital_name.xml";
    private static final String ETIQUETA_INICIAL = "<m:CapitalCityResult>";
    private static final String ETIQUETA_FINAL = "</m:CapitalCityResult>";
    private static final String STRING_NAME = "[stringCountry]";

    @Given("el usuario necesita saber el nombre de la capital de un pais")
    public void el_usuario_necesita_saber_el_nombre_de_la_capital_de_un_pais() {
        setUp();
    }

    @When("el usuario ingresa de manera correcta el nombre: {string}")
    public void el_usuario_ingresa_de_manera_correcta_el_nombre(String name) {
        bodyRequest = defineBodyRequest(name);
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }

    @Then("el ususario debería obtener el mensaje correcto {string}")
    public void el_ususario_debería_obtener_el_mensaje_correcto(String name_final) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El nombre de la capital: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString(ETIQUETA_INICIAL + name_final + ETIQUETA_FINAL)
                )
        );
    }

    @When("el usuario ingresa de manera incorrecta el nombre: {string}")
    public void el_usuario_ingresa_de_manera_incorrecta_el_nombre(String name) {
        bodyRequest = defineBodyRequest(name);
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }

    @Then("el ususario debería obtener el mensaje incorrecto {string}")
    public void el_ususario_debería_obtener_el_mensaje_incorrecto(String name_final) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El nombre de la capital: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString(ETIQUETA_INICIAL + name_final + ETIQUETA_FINAL)
                )
        );
    }

    private String defineBodyRequest(String n){
        return readFile(CAPITAL_NAME_XML).replace(STRING_NAME, n);
    }

}

/*






 */