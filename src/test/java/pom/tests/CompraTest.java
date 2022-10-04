package pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.pages.CompraPage;

import java.util.List;

public class CompraTest{
    private WebDriver driver;
    CompraPage CompraPage;

    @BeforeTest
    public void setUp() throws  Exception{
        CompraPage = new CompraPage(driver);
        driver = CompraPage.chromeDriveConecction();
        CompraPage.visit("https://jagoqui-clothesstore-latam.netlify.app/#/home");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }


    @Test
    public void TestCatHombre() throws InterruptedException{
        CompraPage.CompraPorCategoria("Hombre");
    }
    @Test
    public void TestCatMujer() throws InterruptedException{
        CompraPage.CompraPorCategoria("Mujer");
    }
    @Test
    public void TestCatJunior() throws InterruptedException{
        CompraPage.CompraPorCategoria("Junior");
    }
    @Test
    public void TestCatNinos() throws InterruptedException{
        CompraPage.CompraPorCategoria("Ninos");
    }
    @Test
    public void TestCatAccesorios() throws InterruptedException{
        CompraPage.CompraPorCategoria("Accesorios");
    }
    @Test
    public void TestCatOfertas() throws InterruptedException{
        CompraPage.CompraPorCategoria("Ofertas");
    }

    @Test
    public void TestCompraPorBusqueda(){
        CompraPage.compraPorBusqueda("Camisa");
    }
}
