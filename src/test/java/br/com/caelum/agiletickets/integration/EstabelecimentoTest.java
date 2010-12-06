//package br.com.caelum.agiletickets.integration;
//
//import junit.framework.Assert;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import br.com.caelum.seleniumdsl.Browser;
//import br.com.caelum.seleniumdsl.Form;
//import br.com.caelum.seleniumdsl.Page;
//import br.com.caelum.seleniumdsl.table.Cell;
//import br.com.caelum.seleniumdsl.table.Table;
//import br.com.caelum.seleniumdsl.webdriver.WebDriverBrowser;
//
//public class EstabelecimentoTest {
//
//	private static String BASE_URL = "http://localhost:8080";
//	private Browser browser;
//	private FirefoxDriver driver;
//
//	@Before
//	public void setUp() throws Exception {
//		driver = new FirefoxDriver();
//		browser = new WebDriverBrowser(driver);
//	}
//	@After
//	public void teardown() {
//		driver.close();
//	}
//
//	@Test
//	public void testname() throws Exception {
//		Page estabelecimentos = browser.open(BASE_URL + "/estabelecimentos");
//
//		Form form = estabelecimentos.form("addForm");
//
//		form.field("nome").type("Caelum");
//		form.field("endereco").type("R. Vergueiro, 3185");
//		form.check("estacionamento");
//		form.submit();
//
//		Page lista = browser.currentPage();
//
//		Table table = lista.table("lista");
//
//		int linhaCaelum = table.column("Nome").find("Caelum");
//		Cell estacionamento = table.row(linhaCaelum).cell("Estacionamento");
//
//		Assert.assertEquals("true", estacionamento.value());
//	}
//
//}
