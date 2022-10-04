package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.baseclass.Base;



public class CompraPage extends Base {

    public CompraPage(WebDriver driver) {
        super(driver);
    }
    By categoriaHombre = By.xpath("//span[text()='Hombre']");
    By categoriaMujer = By.xpath("//span[text()='Mujer']");
    By categoriaJunior = By.xpath("//span[text()='Junior']");
    By categoriaNinos = By.xpath("//span[text()='Niños']");
    By categoriaAccesorios = By.xpath("//span[text()='Accesorios']");
    By categoriaOfertas = By.xpath("//span[text()='Ofertas']");
    By productoCatHombre = By.xpath("//section/app-product-card[1]/div[1]/div[2]/button");
    By prodCatMujer = By.xpath("//section/app-product-card[1]/div[1]/div[2]/button");
    By prodJunior = By.xpath("//section/app-product-card[6]/div[1]/div[2]/button");
    By prodNinos = By.xpath("//section/app-product-card[2]/div[1]/div[2]/button");
    By proAccesorios = By.xpath("//section/app-product-card[10]/div[1]/div[2]/button");
    By proOfertas = By.xpath("//section/app-product-card[2]/div[1]/div[2]/button");
    By cartButton = By.id("cart");
    By modalConfirmation = By.xpath("//div[contains(text(),'Clothesstore LATAM')]");
    By removerItemsCheckout = By.xpath("//button[text()=' REMOVER ITEMS ']");
    By botonVaciar = By.xpath("//button[text()='Sí, vaciar!']");
    By okBoton = By.xpath("//button[text()='OK']");
    By barraBusqueda= By.xpath("//input[@title='Ingrese el producto que quiere buscar']");

    public void CompraPorCategoria(String cat) {

        if (cat == "Hombre") {
            forceClick(categoriaHombre);
            theWait(productoCatHombre);
            scroll(productoCatHombre);
            theWait(productoCatHombre);
            forceClick(productoCatHombre);
            terminarCompra();
        }
        if (cat == "Mujer") {
            forceClick(categoriaMujer);
            theWait(prodCatMujer);
            scroll(prodCatMujer);
            theWait(prodCatMujer);
            forceClick(prodCatMujer);
            terminarCompra();
        }
        if (cat == "Junior"){
            forceClick(categoriaJunior);
        theWait(prodJunior);
        scroll(prodJunior);
        theWait(prodJunior);
        forceClick(prodJunior);
        terminarCompra();
        }
        if(cat== "Ninos") {
            forceClick(categoriaNinos);
            theWait(prodNinos);
            scroll(prodNinos);
            theWait(prodNinos);
            forceClick(prodNinos);
            terminarCompra();
        }
        if(cat=="Accesorios") {
            forceClick(categoriaAccesorios);
            theWait(proAccesorios);
            scroll(proAccesorios);
            theWait(proAccesorios);
            forceClick(proAccesorios);
            terminarCompra();
        }
        if(cat=="Ofertas"){
                click(categoriaOfertas);
                theWait(proOfertas);
                scroll(proOfertas);
                theWait(proOfertas);
                forceClick(proOfertas);
                terminarCompra();
        }

    }

    public void compraPorBusqueda(String element){
        setText(element, barraBusqueda);
        theWait(productoCatHombre);
        scroll(productoCatHombre);
        theWait(productoCatHombre);
        forceClick(productoCatHombre);
        terminarCompra();

    }

    public void terminarCompra(){
        theWait(modalConfirmation);
        forceClick(modalConfirmation);
        theWait(cartButton);
        click(cartButton);
        theWait(removerItemsCheckout);
        click(removerItemsCheckout);
        theWait(botonVaciar);
        click(botonVaciar);
        theWait(okBoton);
        click(okBoton);

    }

}
