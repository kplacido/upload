package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InicialPage extends BasePage{

	public InicialPage(WebDriver driver) {
		super(driver);

	}

	public String retornaUsuarioLogado(){
		return loadWaitElement(By.cssSelector(".login-info-left > .italic")).getText();
		
	}
	
	public ReportPage clicarReportBug () {
		loadWaitElement(By.linkText("Report Issue")).click();
		return new ReportPage(driver);
		
	}
	
	
	//Lembrar de rever este método
	public InicialPage SelecionarProjeto(String projeto) {
		WebElement element = loadWaitElement(By.name("project_id"));
		Select combo = new Select(element);
		combo.selectByVisibleText(projeto);
		
		return this;
	}
	
	public String CarregarProjetoSelecionado() {
		WebElement element = loadWaitElement(By.name("project_id"));
		Select combo = new Select(element);
		
		String projeto = combo.getFirstSelectedOption().getText();
		return projeto;
	}
	
	public LoginPage Logout () {
		loadWaitElement(By.linkText("Logout")).click();
		
		return new LoginPage(driver);
		
	}
	
	


}
