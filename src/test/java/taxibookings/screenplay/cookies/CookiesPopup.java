package taxibookings.screenplay.cookies;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;

class CookiesPopup {
    static Target ACCEPT_BUTTON = Button.called("Accept");
    static Target DECLINE_BUTTON = Button.called("Decline");
}
