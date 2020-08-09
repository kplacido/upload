package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.Web;
import pages.InicialPage;
import pages.LoginPage;



public class InicialTests {
	WebDriver driver = Web.criaChrome();
	
	@After
	public void FecharBrowser() {
		driver.quit();
	}
	
	@Test
	public void SelecionarProjeto() {
		
		
		String projetoSelecionado = new LoginPage(driver).InformaLogin("cleyton.placido").
				InformaSenha("base2").FazerLogin().SelecionarProjeto("Cleyton Placido´s project").CarregarProjetoSelecionado();
		
		
		Assert.assertEquals("Cleyton Placido´s project", projetoSelecionado);
		
	}
	
	@Test
	public void FazerLogout() {
		
		String element = new LoginPage(driver).InformaLogin("cleyton.placido").
				InformaSenha("base2").FazerLogin().Logout().TelaAtualLogin(); 

		Assert.assertEquals("Login", element);
	}
	

}
