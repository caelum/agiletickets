package br.com.caelum.agiletickets.integration.driver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EstabelecimentosDriver {

	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;

	public EstabelecimentosDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void abreListagem() {
		driver.get(BASE_URL + "/estabelecimentos");
	}

	public void adicioneEstabelecimento(String nome, String endereco) {
		WebElement form = form();
		form.findElement(By.name("estabelecimento.nome")).sendKeys(nome);
		form.findElement(By.name("estabelecimento.endereco")).sendKeys(endereco);
		form.submit();
	}

	public void ultimaLinhaDeveConter(String nome, String endereco) {
		WebElement ultimaLinha = ultimaLinha();
		assertThat(ultimaLinha.findElements(By.tagName("td")).get(1).getText(), is(nome));
		assertThat(ultimaLinha.findElements(By.tagName("td")).get(2).getText(), is(endereco));
	}

	public void deveMostrarErro(String erro) {
		WebElement erros = driver.findElement(By.id("errors"));

		assertThat(erros.getText(), containsString(erro));
	}

	public void adicioneEstabelecimentoComEstacionamento(boolean temEstacionamento) {
		form().findElement(By.name("estabelecimento.temEstacionamento"))
			.sendKeys(temEstacionamento ? "Sim" : "Não");
		adicioneEstabelecimento("qualquer", "qualquer");
	}

	public void ultimaLinhaDeveTerEstacionamento(boolean estacionamento) {
		WebElement temEstacionamento = ultimaLinha().findElements(By.tagName("td")).get(3);
		assertThat(temEstacionamento.getText(), is(estacionamento ? "Sim" : "Não"));
	}

	private WebElement form() {
		return driver.findElement(By.id("addForm"));
	}

	private WebElement ultimaLinha() {
		List<WebElement> linhas = driver.findElements(By.tagName("tr"));
		WebElement ultimaLinha = linhas.get(linhas.size() - 1);
		return ultimaLinha;
	}

}
