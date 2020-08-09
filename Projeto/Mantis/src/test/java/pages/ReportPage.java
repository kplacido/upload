package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportPage extends BasePage {

	public ReportPage(WebDriver driver) {
		super(driver);
	
	}
	


	public String RetornaTituloPagina() {
		return driver.getTitle();
	}
	
	//Category
	public ReportPage PreencherCategory(String category) {
		WebElement element = loadWaitElement(By.name("category_id"));
		Select combo = new Select(element);
		combo.selectByVisibleText(category);
		
		return this;	
	}
	
	public String CarregarCategorySelecionada() {
		WebElement element = loadWaitElement(By.name("category_id"));
		Select combo = new Select(element);
		
		String projeto = combo.getFirstSelectedOption().getText();
		return projeto;
	}
	
	//Reproducibility
	public ReportPage PreencherReproducibility(String reproducibility) {
		WebElement element = loadWaitElement(By.name("reproducibility"));
		Select combo = new Select(element);
		combo.selectByVisibleText(reproducibility);
		
		return this;	
	}
	
	public String CarregarReproducibilitySelecionada() {
		WebElement element = loadWaitElement(By.name("reproducibility"));
		Select combo = new Select(element);
		
		String projeto = combo.getFirstSelectedOption().getText();
		return projeto;
	}
	
	//Severity
	public ReportPage PreencherSeverity(String severity) {
		WebElement element = loadWaitElement(By.name("severity"));
		Select combo = new Select(element);
		combo.selectByVisibleText(severity);
		
		return this;	
	}
	public String CarregarSeveritySelecionada() {
		WebElement element = loadWaitElement(By.name("severity"));
		Select combo = new Select(element);
		
		String projeto = combo.getFirstSelectedOption().getText();
		return projeto;
	}
	
	//Priority
	public ReportPage PreencherPriority(String priority) {
		WebElement element = loadWaitElement(By.name("priority"));
		Select combo = new Select(element);
		combo.selectByVisibleText(priority);
		
		return this;	
	}
	public String CarregarPrioritySelecionada() {
		WebElement element = loadWaitElement(By.name("priority"));
		Select combo = new Select(element);
		
		String projeto = combo.getFirstSelectedOption().getText();
		return projeto;
	}
	//Profile
	public ReportPage PreencherProfile(String profile) {
		WebElement element = loadWaitElement(By.name("profile_id"));
		Select combo = new Select(element);
		combo.selectByVisibleText(profile);
		
		return this;	
	}
	public String CarregarProfileSelecionada() {
		WebElement element = loadWaitElement(By.name("profile_id"));
		Select combo = new Select(element);
		
		String projeto = combo.getFirstSelectedOption().getText();
		return projeto;
	}
	
	//plataform
	public ReportPage PreencherPlatform(String platform) {
		WebElement element = loadWaitElement(By.id("platform"));
		element.clear();
		element.sendKeys(platform);
		
		return this;	
	}
	public String CarregarPlatform() {
		String element = loadWaitElement(By.id("platform")).getAttribute("value");

		return element;	
	}
	//OS
	public ReportPage PreencherOS(String os) {
		WebElement element = loadWaitElement(By.id("os"));
		element.clear();
		element.sendKeys(os);
		
		return this;	
	}
	public String CarregarOS() {
		String element = loadWaitElement(By.id("os")).getAttribute("value");

		return element;	
	}
	
	//OS Version
	public ReportPage PreencherOSVersion(String osversion) {
		WebElement element = loadWaitElement(By.id("os_build"));
		element.clear();
		element.sendKeys(osversion);
		
		return this;	
	}
	public String CarregarOSVersion() {
		String element = loadWaitElement(By.id("os_build")).getAttribute("value");

		return element;	
	}
	
	//Summary
	public ReportPage PreencherSummary(String sumary) {
		WebElement element = loadWaitElement(By.name("summary"));
		element.clear();
		element.sendKeys(sumary);
		
		return this;	
	}
	public String CarregarSummary() {
		String element = loadWaitElement(By.name("summary")).getAttribute("value");

		return element;	
	}
	
	//Description
	public ReportPage PreencherDescription(String description) {
		WebElement element = loadWaitElement(By.name("description"));
		element.clear();
		element.sendKeys(description);
			
		return this;	
	}
	public String CarregarDescription() {
		String element = loadWaitElement(By.name("description")).getAttribute("value");

		return element;	
	}
	
	//Description
		public ReportPage PreencherStepsReproduce(String steps) {
			WebElement element = loadWaitElement(By.name("steps_to_reproduce"));
			element.clear();
			element.sendKeys(steps);
				
			return this;	
		}
		public String CarregarStepsReproduce() {
			String element = loadWaitElement(By.name("steps_to_reproduce")).getAttribute("value");

			return element;	
		}
		//Additional Information
		public ReportPage PreencherAdditional(String additional) {
			WebElement element = loadWaitElement(By.name("additional_info"));
			element.clear();
			element.sendKeys(additional);
				
			return this;	
		}
		public String CarregarAddition() {
			String element = loadWaitElement(By.name("additional_info")).getAttribute("value");

			return element;	
		}
		
		//ViewStatus
		public ReportPage MarcarViewStatusPrivate() {
					WebElement element = loadWaitElement(By.cssSelector("label:nth-child(2) > input"));
					element.click();
					
						
					return this;	
		}
		public boolean VerificarViewStatusPrivateChecked() {
			boolean element = loadWaitElement(By.cssSelector("label:nth-child(2) > input")).isSelected();

			return element;	
		}
		
		//ViewStatus
		public ReportPage MarcarReportMoreIssues() {
				WebElement element = loadWaitElement(By.id("report_stay"));
				element.click();
				
				return this;	
		}
		public boolean VerificarReportMoreissuesChecked() {
			boolean element = loadWaitElement(By.id("report_stay")).isSelected();

			return element;	
		}
		
		public ReportSuccessfulPage ConfirmarReport ( ) {
			WebElement element = loadWaitElement(By.className("button"));
			element.click();
			
			return new ReportSuccessfulPage(driver);
		}
		
}
