package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;
import org.hamcrest.DiagnosingMatcher;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;
    private String email;
    private String nombre;
    private String apellido;
    private String password;
    private String dia;
    private String mes;
    private String año;
    private String direccion;
    private String direccion2;
    private String ciudad;
    private String estado;
    private String codigoPostal;




    public void inicializaVariables() {
        Random rand = new Random();
        int indice = rand.nextInt(100); 
        email = "devops_mail_test" + String.valueOf(indice) +  "@gmail.com";
        nombre = "Giselle";
        apellido = "Lazcano";
        password = "456789";
        dia = "10";
        mes = "8";
        año = "1975";
        direccion = "Direcccion 1234 casa 10";
        direccion2 = "Condominio Nidal";
        ciudad = "Santiago";
        estado = "Kentucky";
        codigoPostal = "00000";
    }


    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");        
        driver = new ChromeDriver();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        inicializaVariables();
    }

    @Test
    public void testAutomatizado() {
        testCompraConCreacionUsuario();
        driver.findElement(By.linkText("Sign out")).click();
        testCompraUsuarioExistente();
    }

    public void testCompraConCreacionUsuario() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Printed Dress")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Agrega al carro
        driver.findElement(By.cssSelector(".exclusive > span")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".button-medium > span")).click();
        //Confirma compra
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        //Selecciona crear usuario
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
        //Completa formulario
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(nombre);
        driver.findElement(By.id("customer_lastname")).sendKeys(apellido);
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.cssSelector(".form-group > .row")).click();
        new Select(driver.findElement(By.id("days"))).selectByValue(dia);
        new Select(driver.findElement(By.id("months"))).selectByValue(mes);
        new Select(driver.findElement(By.id("years"))).selectByValue(año);
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).sendKeys("Compañia1");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).sendKeys(direccion);
        driver.findElement(By.id("address2")).click();
        driver.findElement(By.id("address2")).sendKeys(direccion2);
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys(ciudad);
        driver.findElement(By.id("id_state")).click();
        {
        WebElement dropdown = driver.findElement(By.id("id_state"));
        dropdown.findElement(By.xpath("//option[. = '" + estado + "']")).click();
        }
        driver.findElement(By.cssSelector("#id_state > option:nth-child(19)")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).sendKeys(codigoPostal);
        driver.findElement(By.id("id_country")).click();
        driver.findElement(By.cssSelector("#id_country > option:nth-child(2)")).click();
        driver.findElement(By.id("other")).click();
        driver.findElement(By.id("other")).sendKeys("No aplica");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("22225548");
        driver.findElement(By.cssSelector(".required:nth-child(14)")).click();
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).sendKeys("99854521");
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("alias")).sendKeys("My address1");
        driver.findElement(By.cssSelector("#submitAccount > span")).click();
        String direccionCompleta = direccion + " " + direccion2;
        String nombreCompleto = nombre + " " + apellido;
        String ciudadEstado = ciudad + ", " + estado + " " + codigoPostal;
        assertEquals(direccionCompleta, driver.findElement(By.xpath("//li[@class='address_address1 address_address2']")).getText());
        assertEquals(nombreCompleto, driver.findElement(By.xpath("//li[@class='address_firstname address_lastname']")).getText());
        assertEquals(ciudadEstado, driver.findElement(By.xpath("//li[@class='address_city address_state_name address_postcode']")).getText());

        //Selecciona condiciones
        driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
        driver.findElement(By.id("cgv")).click();
        //Confirma 
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
      }
      

    public void testCompraUsuarioExistente() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".exclusive > span")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".button-medium > span")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.cssSelector(".bankwire > span")).click();
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
    }
    
}
