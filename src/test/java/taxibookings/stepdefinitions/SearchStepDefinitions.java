package taxibookings.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import taxibookings.screenplay.cookies.ManageCookiePreferences;
import taxibookings.screenplay.search.FlightList;
import taxibookings.screenplay.search.PickAirport;
import taxibookings.screenplay.search.PickTravelDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    @Given("{actor} wants to book a flight")
    public void wants_to_book_a_flight(Actor actor) {
        actor.attemptsTo(
                Open.url("https://www.ryanair.com/ie/en/"),
                ManageCookiePreferences.andAccept()
        );
    }

    @When("{actor} searches for flights for the following trip:")
    public void searches_for_taxis_for_the_following_trip(Actor actor,
                                                          List<Map<String, String>> searchCriteriaTable) {
        Map<String, String> searchCriteria = searchCriteriaTable.get(0);
        String departure = searchCriteria.get("From");
        String destination = searchCriteria.get("To");
        LocalDate departingDate = dateFrom(searchCriteria.get("Depart"));
        LocalDate returningDate = dateFrom(departingDate, searchCriteria.get("Return"));

        actor.attemptsTo(
                PickAirport.flyingFrom(departure),
                PickAirport.flyingTo(destination),
                PickTravelDate.departingOn(departingDate).returningOn(returningDate),
                WaitUntil.the(Button.called("Search"), isClickable()),
                Click.on(Button.called("Search"))
        );
    }

    private LocalDate dateFrom(LocalDate startingDate, String dateDifference) {
        return relativeDate(startingDate, dateDifference);
    }

    private LocalDate dateFrom(String departureDate) {
        switch (departureDate) {
            case "Today":
                return LocalDate.now();
            case "Tomorrow":
                return LocalDate.now().plusDays(1);
            default:
                return relativeDate(LocalDate.now(), departureDate);
        }
    }

    private LocalDate relativeDate(LocalDate startingDate, String dateExpression) {
        // +5 days
        String[] dateElements = dateExpression.split(" ");
        int numberOfUnits = Integer.parseInt(dateElements[0]);
        ChronoUnit timeUnit = ChronoUnit.valueOf(dateElements[1].toUpperCase());
        return startingDate.plus(numberOfUnits, timeUnit);
    }

    @Then("the available flights should be displayed for the following itineraries:")
    public void the_available_flights_should_be_displayed(List<String> itineraries) {
        Actor actor = OnStage.theActorInTheSpotlight();

        actor.attemptsTo(
                WaitUntil.the(FlightList.FLIGHT_ITINERARIES, isVisible())
        );
        Collection<String> itineraryTitles = actor.asksFor(Text.ofEach(FlightList.FLIGHT_ITINERARIES));
        assertThat(itineraryTitles).hasSameElementsAs(itineraries);
    }

}
