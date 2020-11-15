package TestDefinition;

import java.sql.DriverManager;
import java.sql.Connection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import TestRunner.abrir_navegador;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;



public class TestSteps {
	
	Connection connection;
	WebDriver driver;

	@Given("abrir navegador")
	public void abrir_navegador() {

		System.out.println("\nAbre el navegador URL: 'http://localhost:8081/PetSmile/faces/login.jsp'");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Marcelo\\Desktop\\IPLACEX\\IntegracionContinua\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("http://localhost:8081/PetSmile/faces/login.jsp");
	}

	@When("ingresa Username {string} y Password {string}") 
	public void ingresa_Username_y_Password(String string, String string2) { 
	
		System.out.println("En este paso ingresa las credenciales de usuario"); 
		driver.findElement(By.id("j_id_jsp_996193452_1:userName")).sendKeys(string);
		driver.findElement(By.id("j_id_jsp_996193452_1:password")).sendKeys(string2);

	}

	@Then("inicia sesion")
	public void inicia_sesion() {
	    
		System.out.println("Intenta iniciar sesion mediante el boton Login");
		driver.findElement(By.id("j_id_jsp_996193452_1:btnLogin")).click();
		
	}
	
	@When("Agenda Hora RUT={string} NOMBRE={string} APELLIDO={string} DIRECCION={string} CORREO={string} FONO={string} NOMBRE_MASCOTA={string} TIPO={string} EDAD={string} HR={string} MN={string} DIA={string} MES={string}")
	public void Agenda_hora(String string1, String string2,String string3, String string4,
			                String string5, String string6,String string7, String string8,
			                String string9, String string10,String string11, String string12,
			                String string13) {
		
		driver.findElement(By.id("j_id_jsp_1672113324_1:PK_RutDueno")).sendKeys(string1);
		driver.findElement(By.id("j_id_jsp_1672113324_1:nombreDueno")).sendKeys(string2);
		
		driver.findElement(By.id("j_id_jsp_1672113324_1:apellidoDueno")).sendKeys(string3);
		driver.findElement(By.id("j_id_jsp_1672113324_1:direccionDueno")).sendKeys(string4);

		driver.findElement(By.id("j_id_jsp_1672113324_1:correoDueno")).sendKeys(string5);
		driver.findElement(By.id("j_id_jsp_1672113324_1:telefonoDueno")).sendKeys(string6);

		driver.findElement(By.id("j_id_jsp_1672113324_1:nombreMascota")).sendKeys(string7);
		driver.findElement(By.id("j_id_jsp_1672113324_1:tipoMascota")).sendKeys(string8);	
		
		driver.findElement(By.id("j_id_jsp_1672113324_1:edad")).sendKeys(string9);
		driver.findElement(By.id("j_id_jsp_1672113324_1:hr")).sendKeys(string10);

		driver.findElement(By.id("j_id_jsp_1672113324_1:mn")).sendKeys(string11);
		driver.findElement(By.id("j_id_jsp_1672113324_1:dia")).sendKeys(string12);
		
		driver.findElement(By.id("j_id_jsp_1672113324_1:mes")).sendKeys(string13);
		
		
		
	}
	
	@Then("Reservar Hora")
	public void reservar_hora() {
	    
		driver.findElement(By.id("j_id_jsp_1672113324_1:btnAgenda")).click();
		
	}
	
	
	@And("Cerrar navegador")
	public void cerrar_navegador() {
		System.out.println("Cerrar el navegador");
		driver.quit();

	}
	/*
    @When("Conectar como Username: {string} y Password: {string} a la base de datos MySql: {string}") 
    public void conectarBD(String username,String password,String url) {

    	try {
    		System.out.println("\nConectar a la BD: '" + url + "' USER: '"+username+"' PASS: '"+password+"'");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
    		System.out.println("Conexion a BD exitosa DriverManager.getConnection = "+ connection);
    	}catch(Exception ex) {
    		System.out.println("Ocurrio una excepcion en el proceso, la Causa = " + ex.getCause() + "\nDriverManager.getConnection = "+ connection);
    	}
    	
    }*/
	@When("Probar conexion BD {string}")
	public void conexionBD(String url) {
		
		try {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection(url,"root","root");		
        System.out.println("OK");
		}catch(Exception ex) {
			System.out.println("FALLO");
		}
		
	}

}
