package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import core.Web;
import pages.LoginPage;

public class LoginTests {
WebDriver driver = Web.criaChrome();
	
	@After
	public void FecharBrowser() {
		driver.quit();
	}
	
	
	
	@Test
	public void FazerLoginValido(){
		
		String usuarioLogado = new LoginPage(driver).LoginValido("cleyton.placido", "base2").retornaUsuarioLogado();
		Assert.assertEquals("cleyton.placido", usuarioLogado);
					
	}
	
	@Test
	public void FazerLoginInvalido() {
		String mensagem = new LoginPage(driver).LoginInvalido("login", "invalido").MensagemErro();
		Assert.assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
	}
	
	@Test
	public void LoginSemSenha() {
		String menssagem = new LoginPage(driver).SenhaNaoInformada("cleyton.placido").MensagemErro();
		Assert.assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", menssagem);
	}
	
	@Test
	public void LoginSemLogin() {
		String mensagem = new LoginPage(driver).LoginNaoInformado("base2").MensagemErro();
		Assert.assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", mensagem);
	}
	
}
