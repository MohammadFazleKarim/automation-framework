package pages;

import base.Base;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AmazonBasePage extends Base {

    public abstract boolean validatePageHasLoaded();

    public boolean validateElementsAreVisible(List<WebElement> elements){
        while (elements.size() > 0){
            if (elementDisplayed(elements.get(0))){
                elements.remove(0);
                validateElementsAreVisible(elements);
            }
        }
        return true;
    }

}
