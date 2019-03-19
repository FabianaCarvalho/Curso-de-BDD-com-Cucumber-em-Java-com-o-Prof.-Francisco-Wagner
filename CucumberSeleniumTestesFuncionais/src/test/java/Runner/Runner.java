package Runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/main/resources/Features/InserirConta.feature", glue = "Steps", tags = { "~@ignore" }, plugin = {
				"pretty" }, monochrome = true, // serve para deixar o log mais harmoniozo
//esse plugin irá juntar o nome do metodo sem usar underline
		snippets = SnippetType.CAMELCASE,
		dryRun = false, // definido true para pegar somento o passo que falta
		strict = false

)

public class Runner {

	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\739949\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("fabiana@yahoo.com.br");
		driver.findElement(By.id("senha")).sendKeys("cabeca");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

}
