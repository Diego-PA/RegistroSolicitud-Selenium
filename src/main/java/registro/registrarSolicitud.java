package registro;

import static java.lang.System.setProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class registrarSolicitud {

    public static void main(String[] args) {

        //Para ms edge
        //Elegimos el driver
        setProperty("webdriver.edge.driver", "C:\\Users\\diego\\IdeaProjects\\SeleniumTestProject\\src\\Drivers\\msedgedriver.exe");

        //Inicializa el navegador
        WebDriver driver = new EdgeDriver();

        //Le damos la propiedad de ejecutar scripts de JS
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        //Abrimos la página web
        //8000
        driver.get("http://127.0.0.1:80/");

        driver.findElement(By.id("cuenta")).sendKeys("314034957");

        driver.findElement(By.id("nip")).sendKeys("1234");

        driver.findElement(By.xpath("//*[@id=\"form-alumno\"]/div/button")).click();

        //esperamos a que cargue la nueva página
        //select
        Select selNivel = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[1]/select")));
        selNivel.selectByValue("L");

        //ESTE SELECT YA NO SIRVE POR QUE NO HA CARGADO AÚN
        Select selCarrera = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[2]/select")));
        selCarrera.selectByValue("110");

        //select
        //Select selNivel = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[1]/select")));
        //selNivel.selectByValue("L");
    }

}
