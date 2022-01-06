package taxibookings.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.Wait;
import taxibookings.screenplay.cookies.ManageCookiePreferences;
import taxibookings.screenplay.search.SearchForm;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SearchStepDefinitions {

    @Given("{actor} wants to book a taxi")
    public void wants_to_book_a_taxi(Actor actor) {
        actor.attemptsTo(
                Open.url("https://taxi.booking.com"),
                ManageCookiePreferences.andAccept()
        );
    }

    @When("{actor} searches for taxis for the following trip:")
    public void searches_for_taxis_for_the_following_trip(Actor actor,
                                                          List<Map<String,String>> searchCriteriaTable) {
        Map<String, String> searchCriteria = searchCriteriaTable.get(0);
        String pickupLocation = searchCriteria.get("From");
        String destination = searchCriteria.get("To");

        actor.attemptsTo(
                Enter.theValue(pickupLocation).into(SearchForm.PICKUP),
                Enter.theValue(destination).into(SearchForm.DESTINATION)
        );

    }

    @Then("the available taxis should be displayed")
    public void the_available_taxis_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
