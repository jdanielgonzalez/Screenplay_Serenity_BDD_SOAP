package co.com.sofka.runner.soap.information;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/capital_name/capital_name.feature"},
        glue = {"co/com/sofka/stepdefnitions/soap/information/capital_name"}
)
public class CapitalNameWithCucumberTest {
}
