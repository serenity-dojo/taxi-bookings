package taxibookings.screenplay.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PickTravelDate {

    public static final String DEPARTURE_DATE = "[data-ref='input-button__dates-from']";
    private static Target CALENDER_DAY = Target.the("Calendar day cell").locatedBy("[data-id='{0}']");

    private LocalDate departingDate;

    public PickTravelDate(LocalDate departingDate) {
        this.departingDate = departingDate;
    }

    public static PickTravelDate departingOn(LocalDate date) {
        return new PickTravelDate(date);
    }

    public Performable returningOn(LocalDate returningDate) {
        return Task.where("{0} picks a return date of " + returningDate,
                Click.on(DEPARTURE_DATE),
                Click.on(CALENDER_DAY.of(departingDate.format(DateTimeFormatter.ISO_DATE))),
                Click.on(CALENDER_DAY.of(returningDate.format(DateTimeFormatter.ISO_DATE)))
        );
    }
}
