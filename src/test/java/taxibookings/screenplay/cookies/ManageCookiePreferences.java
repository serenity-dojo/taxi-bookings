package taxibookings.screenplay.cookies;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.Wait;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ManageCookiePreferences {

    public static Performable andAccept() {
        return Task.where("{0} accepts the cookies",
                Wait.until(the(CookiesPopup.ACCEPT_BUTTON), isVisible()),
                Click.on(CookiesPopup.ACCEPT_BUTTON)
        );
    }

    public static Performable andDecline() {
        return Task.where("{0} declines the cookies",
                Wait.until(the(CookiesPopup.DECLINE_BUTTON), isVisible()),
                Click.on(CookiesPopup.DECLINE_BUTTON)
        );
    }
}
