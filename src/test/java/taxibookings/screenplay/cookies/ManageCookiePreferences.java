package taxibookings.screenplay.cookies;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ManageCookiePreferences {

    public static Performable andAccept() {
        return Task.where("{0} accepts the cookies",
                actor -> {
                    actor.attemptsTo(
                            Wait.until(the(CookiesPopup.ACCEPT_BUTTON), isVisible()),
                            Click.on(CookiesPopup.ACCEPT_BUTTON)
                    );
                    actor.attemptsTo(
                            Wait.until(the(CookiesPopup.ACCEPT_BUTTON), isNotCurrentlyVisible())
                    );
                }
        );
    }
}
