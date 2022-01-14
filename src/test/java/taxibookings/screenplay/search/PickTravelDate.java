package taxibookings.screenplay.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PickTravelDate {

    private static Target CALENDER_DAY = Target.the("Calendar day cell").locatedBy("[data-id='{0}']");

    public static Performable departingOn(LocalDate date) {
        return Task.where("{0} picks a departure date of " + date,
                Click.on("[data-ref='input-button__dates-from']"),
                Click.on(CALENDER_DAY.of(date.format(DateTimeFormatter.ISO_DATE)))
        );
    }

    public static Performable returningOn(LocalDate returningDate) {
        return Task.where("{0} picks a return date of " + returningDate,
                Click.on("[data-ref='input-button__dates-to']"),
                Click.on(CALENDER_DAY.of(returningDate.format(DateTimeFormatter.ISO_DATE)))
        );
    }
}
