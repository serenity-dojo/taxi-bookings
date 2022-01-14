package taxibookings.screenplay.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.PageElement;

public class PickAirport {

    private static final String DEPARTURE_AIRPORT = "#input-button__departure";
    private static final String DESTINATION_AIRPORT = "#input-button__destination";

    public static Performable flyingFrom(String departure) {
        return Task.where("{0} selects departure airport of " + departure,
                enterAirportName(departure, DEPARTURE_AIRPORT),
                pickFromProposedAirports(departure)
        );
    }

    public static Performable flyingTo(String destination) {
        return Task.where("{0} selects destination airport of " + destination,
                enterAirportName(destination, DESTINATION_AIRPORT),
                pickFromProposedAirports(destination)
        );
    }

    private static Performable enterAirportName(String airportName, String airportInputField) {
        return Enter.theValue(airportName).into(airportInputField);
    }

    private static Performable pickFromProposedAirports(String airportName) {
        return Click.on(PageElement.locatedBy(".airport-item").containingText(airportName));
    }
}
