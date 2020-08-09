package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.Web;
import pages.LoginPage;
import pages.ReportPage;

public class ReportTests {
WebDriver driver = Web.criaChrome();
	
	@After
	public void FecharBrowser() {
		driver.quit();
	}
	
	
	@Test
	public void verificarTituloPagina() {
		
		
		String paginaAtual = new LoginPage(driver).InformaLogin("cleyton.placido").InformaSenha("base2").FazerLogin().SelecionarProjeto("Cleyton Placido´s project")
				.clicarReportBug().RetornaTituloPagina();
			
		Assert.assertEquals("Report Issue - MantisBT", paginaAtual);
		
	}
	
	@Test
	public void VerificarPreenchimentoReportDetails () {
		
		String category = new LoginPage(driver).InformaLogin("cleyton.placido").InformaSenha("base2").FazerLogin().SelecionarProjeto("Cleyton Placido´s project")
				.clicarReportBug().PreencherCategory("[All Projects] Teste").CarregarCategorySelecionada();	
		Assert.assertEquals("[All Projects] Teste", category);
		
		
		String reproducibility = new ReportPage(driver).PreencherReproducibility("sometimes").CarregarReproducibilitySelecionada();
		Assert.assertEquals("sometimes", reproducibility);
		
		String severity = new ReportPage(driver).PreencherSeverity("trivial").CarregarSeveritySelecionada();
		Assert.assertEquals("trivial", severity);
		
		String priority = new ReportPage(driver).PreencherPriority("high").CarregarPrioritySelecionada();
		Assert.assertEquals("high", priority);
		
		String profile = new ReportPage(driver).PreencherProfile("PC Windows 8").CarregarProfileSelecionada();
		Assert.assertEquals("PC Windows 8", profile);
		
		String platform = new ReportPage(driver).PreencherPlatform("PLATAFORMA123").CarregarPlatform();
		Assert.assertEquals("PLATAFORMA123", platform);
		
		String os = new ReportPage(driver).PreencherOS("OS123").CarregarOS();
		Assert.assertEquals("OS123", os);
		
		String osversion = new ReportPage(driver).PreencherOSVersion("OSVersion1.1").CarregarOSVersion();
		Assert.assertEquals("OSVersion1.1", osversion);
		
		String summary = new ReportPage(driver).PreencherSummary("SUMMARY123").CarregarSummary();
		Assert.assertEquals("SUMMARY123", summary);
		
		String description = new ReportPage(driver).PreencherDescription("DESCRIPTION 1234").CarregarDescription();
		Assert.assertEquals("DESCRIPTION 1234", description);
		
		String stepsToReproduce = new ReportPage(driver).PreencherStepsReproduce("STEPS TO REPRODUCE 1234").CarregarStepsReproduce();
		Assert.assertEquals("STEPS TO REPRODUCE 1234", stepsToReproduce);
		
		String stepsAdditional = new ReportPage(driver).PreencherAdditional("ADDITIONAL INFORMATION 1234").CarregarAddition();
		Assert.assertEquals("ADDITIONAL INFORMATION 1234", stepsAdditional);
		
		boolean viewStatus =   new ReportPage(driver).MarcarViewStatusPrivate().VerificarViewStatusPrivateChecked();
		Assert.assertTrue(viewStatus);
		
		boolean reportIssues =   new ReportPage(driver).MarcarReportMoreIssues().VerificarReportMoreissuesChecked();
		Assert.assertTrue(reportIssues);
		
		String confirma = new ReportPage(driver).ConfirmarReport().GravadoComSucesso();
		Assert.assertEquals("Operation successfu", confirma);
		
	}
	
	@Test
	public void VerificarPreenchimentoReportDetailsCampoObrigatorioVazio() {
		//sem preencher o campo summary para verificar a Obrigatoriedade
		
		String category = new LoginPage(driver).InformaLogin("cleyton.placido").InformaSenha("base2").FazerLogin().SelecionarProjeto("Cleyton Placido´s project")
				.clicarReportBug().PreencherCategory("[All Projects] Teste").CarregarCategorySelecionada();	
		Assert.assertEquals("[All Projects] Teste", category);
		
		
		String reproducibility = new ReportPage(driver).PreencherReproducibility("sometimes").CarregarReproducibilitySelecionada();
		Assert.assertEquals("sometimes", reproducibility);
		
		String severity = new ReportPage(driver).PreencherSeverity("trivial").CarregarSeveritySelecionada();
		Assert.assertEquals("trivial", severity);
		
		String priority = new ReportPage(driver).PreencherPriority("high").CarregarPrioritySelecionada();
		Assert.assertEquals("high", priority);
		
		String profile = new ReportPage(driver).PreencherProfile("PC Windows 8").CarregarProfileSelecionada();
		Assert.assertEquals("PC Windows 8", profile);
		
		String platform = new ReportPage(driver).PreencherPlatform("PLATAFORMA123").CarregarPlatform();
		Assert.assertEquals("PLATAFORMA123", platform);
		
		String os = new ReportPage(driver).PreencherOS("OS123").CarregarOS();
		Assert.assertEquals("OS123", os);
		
		String osversion = new ReportPage(driver).PreencherOSVersion("OSVersion1.1").CarregarOSVersion();
		Assert.assertEquals("OSVersion1.1", osversion);
		
		
		String description = new ReportPage(driver).PreencherDescription("DESCRIPTION 1234").CarregarDescription();
		Assert.assertEquals("DESCRIPTION 1234", description);
		
		String stepsToReproduce = new ReportPage(driver).PreencherStepsReproduce("STEPS TO REPRODUCE 1234").CarregarStepsReproduce();
		Assert.assertEquals("STEPS TO REPRODUCE 1234", stepsToReproduce);
		
		String stepsAdditional = new ReportPage(driver).PreencherAdditional("ADDITIONAL INFORMATION 1234").CarregarAddition();
		Assert.assertEquals("ADDITIONAL INFORMATION 1234", stepsAdditional);
		
		boolean viewStatus =   new ReportPage(driver).MarcarViewStatusPrivate().VerificarViewStatusPrivateChecked();
		Assert.assertTrue(viewStatus);
		
		boolean reportIssues =   new ReportPage(driver).MarcarReportMoreIssues().VerificarReportMoreissuesChecked();
		Assert.assertTrue(reportIssues);
		
		String confirma = new ReportPage(driver).ConfirmarReport().ErroReportNaoGravado();
		Assert.assertEquals("APPLICATION ERROR ", confirma);
		
	}
	
	
}
