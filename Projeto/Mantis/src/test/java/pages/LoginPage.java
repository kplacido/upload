package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
	
		super(driver);
	}
	
	public LoginPage InformaLogin(String nome ) {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(nome);
		
		
		return this;
	}
	
	public LoginPage InformaSenha(String senha) {
		driver.findElement(By.name("password")).clear();
		
		driver.findElement(By.name("password")).sendKeys(senha);
		return this;
	}
	
	public InicialPage FazerLogin() {	
		driver.findElement(By.className("button")).click();
		
		return new InicialPage(driver);
	}
	
	public LoginPage NaoLogin() {	
		driver.findElement(By.className("button")).click();

		
		
		return new LoginPage(driver);
	}
	

	public InicialPage LoginValido (String nome, String senha) {
		InformaLogin(nome);
		InformaSenha(senha);
		FazerLogin();
			
		return new InicialPage(driver);
	}
	
	
	
	public LoginPage LoginInvalido(String nome, String senha) {
		InformaLogin(nome);
		InformaSenha(senha);
		NaoLogin();
		
		return this;
	}
	
	public void Logar(String nome, String senha) {
		InformaLogin(nome);
		InformaSenha(senha);
		NaoLogin();
		
	}
	
	public LoginPage SenhaNaoInformada(String nome) {
		InformaLogin(nome);
		NaoLogin();
		
		return this;
	}
	
	public LoginPage LoginNaoInformado(String senha) {
		InformaSenha(senha);
		NaoLogin();
		
		return this;
	}
	
	public String MensagemErro() {
		String mensagem = loadWaitElement(By.cssSelector("font")).getText();
		
		return mensagem;
	}
	
	public String TelaAtualLogin() {
		String element = loadWaitElement(By.cssSelector(".form-title")).getText();
		return element;
	}

}
