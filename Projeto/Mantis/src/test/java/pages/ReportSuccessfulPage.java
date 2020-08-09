package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportSuccessfulPage extends BasePage {

	public ReportSuccessfulPage(WebDriver driver) {
		super(driver);
	
	}
	
	public String GravadoComSucesso () {
		String element  = loadWaitElement(By.cssSelector("div:nth-child(5)")).getText();
	
		
		String[] mensagem = element.split("l"); //<<<------
		String mensagem1 = mensagem[0];
		
		return mensagem1;
		
		
	}
	public String ErroReportNaoGravado() {
		String element = loadWaitElement(By.cssSelector(".form-title")).getText();
		
		String[] mensagem = element.split("#");
		String mensagem1 = mensagem[0];
		
		return mensagem1;
	}

}
