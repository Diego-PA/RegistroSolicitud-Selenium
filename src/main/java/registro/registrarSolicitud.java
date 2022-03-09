package registro;

import static java.lang.System.setProperty;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class registrarSolicitud {

    public static void main(String[] args) throws InterruptedException {

        //Para ms edge
        //Elegimos el driver
        setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\IdeaProjects\\SeleniumTestProject\\src\\Drivers\\chromedriver.exe");

        //Inicializa el navegador
        WebDriver driver = new ChromeDriver();

        //Le damos la propiedad de ejecutar scripts de JS
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        //Abrimos la página web
        //8000
        driver.get("http://127.0.0.1:8001/");

        System.out.println("No. de Cuenta: ");
        Scanner scanCuenta = new Scanner(System.in);
        String noCuenta = scanCuenta.nextLine();

        System.out.println("NIP: ");
        Scanner scanNip = new Scanner(System.in);
        String nip = scanNip.nextLine();

        driver.findElement(By.id("cuenta")).sendKeys(noCuenta);

        driver.findElement(By.id("nip")).sendKeys(nip);

        driver.findElement(By.xpath("//*[@id=\"form-alumno\"]/div/button")).click();

        //esperamos a que cargue la nueva página
        //select
        Select selNivel = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[1]/select")));
        selNivel.selectByValue("L");

        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Explicit wait
        WebDriverWait ewait = new WebDriverWait(driver, 300);
        ewait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@id=\"myform\"]/div[2]/div[2]/select/option[29]"), "110"));

        //ESTE SELECT YA NO SIRVE POR QUE NO HA CARGADO AÚN
        Select selCarrera = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[2]/select")));
        selCarrera.selectByValue("110");

        //Explicit wait
        WebDriverWait ewait1 = new WebDriverWait(driver, 300);
        ewait1.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@id=\"myform\"]/div[2]/div[3]/select/option[2]"), "411"));

        //select
        Select selPlantel = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[3]/select")));
        selPlantel.selectByValue("411");

        //Explicit wait
        WebDriverWait ewait2 = new WebDriverWait(driver, 300);
        ewait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"myform\"]/div[2]/div[5]/select/option[12]")));

        //select
        Select selOpc = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[5]/select")));
        selOpc.selectByValue("81");

        //Explicit wait
        WebDriverWait ewait3 = new WebDriverWait(driver, 300);
        ewait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"myform\"]/div[2]/div[8]/label")));

        //correo
        driver.findElement(By.xpath("//*[@id=\"myform\"]/div[2]/div[6]/div/input")).sendKeys("diego.loge@hotmail.com");

        //Explicit wait
        WebDriverWait ewait31 = new WebDriverWait(driver, 300);
        ewait31.until(ExpectedConditions.elementToBeClickable(By.id("btn_solicitar_codigo")));

        //enviar correo
        driver.findElement(By.id("btn_solicitar_codigo")).click();

        System.out.println("Código: ");
        Scanner scan1 = new Scanner(System.in);
        String input1 = scan1.nextLine();

        js.executeScript("window.scrollBy(0,1750)", "");
        //Explicit wait
        WebDriverWait ewait4 = new WebDriverWait(driver, 300);
        ewait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"myform\"]/div[2]/div[10]/div[1]/div[1]")));
        js.executeScript("window.scrollBy(0,500)", "");

        //*[@id="myform"]/div[2]/div[10]/div[1]/div[1]

        WebElement upload1 = driver.findElement(By.xpath("//*[@id=\"documento.1\"]"));
        upload1.sendKeys("C:\\Users\\diego\\IdeaProjects\\RegistroSolicitudArchivos\\src\\Files\\DocumentoPrueba.pdf");

        WebElement upload2 = driver.findElement(By.xpath("//*[@id=\"documento.2\"]"));
        upload2.sendKeys("C:\\Users\\diego\\IdeaProjects\\RegistroSolicitudArchivos\\src\\Files\\DocumentoPrueba.pdf");

        WebElement upload3 = driver.findElement(By.xpath("//*[@id=\"documento.3\"]"));
        upload3.sendKeys("C:\\Users\\diego\\IdeaProjects\\RegistroSolicitudArchivos\\src\\Files\\DocumentoPrueba.pdf");

        WebElement upload4 = driver.findElement(By.xpath("//*[@id=\"documento.5\"]"));
        upload4.sendKeys("C:\\Users\\diego\\IdeaProjects\\RegistroSolicitudArchivos\\src\\Files\\DocumentoPrueba.pdf");

    }

}
