package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo1 {
	@FindBy(xpath="//input [@type='password']") private WebElement pin;

	@FindBy(xpath="//button [@type='submit']") private WebElement conti;
	
	
	public KiteLogIn2(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void PIN(String Pin) {
		pin.click();
		pin.sendKeys(Pin);
		
	}
	
	public void CONTINUE() {
		
		conti.click();
		
	}
	
}
