package taxibookings.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class StopAndDebug {
    public static Performable here() {
        return new Performable() {
            @Override
            public <T extends Actor> void performAs(T t) {
                System.out.println("DEBUGGING");
            }
        };
    }
}
