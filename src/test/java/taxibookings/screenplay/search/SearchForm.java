package taxibookings.screenplay.search;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchForm {
    public static final Target PICKUP = Target.the("Pickup location").located(By.id("pickupLocation"));
    public static final Target DESTINATION = Target.the("Dropoff location").located(By.id("dropoffLocation"));
}
