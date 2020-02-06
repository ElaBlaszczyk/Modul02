package Zadanie2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Zadanie2 {

    private WebDriver driver;
    int pausa = 1000;

    @Given("^Uzytkownik loguje sie na swoje konto$")
    public void uzytkownikLogujeSieNaSwojeKonto() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php");
        Thread.sleep(pausa);

        WebElement SingIn = driver.findElement(By.xpath("//span[contains(@class,'hidden-sm-down')]"));
        Thread.sleep(pausa);
        SingIn.click();
        Thread.sleep(pausa);

        WebElement email = driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("d1727619@urhen.com");
        Thread.sleep(pausa);

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("ydj9h8");
        Thread.sleep(pausa);

        WebElement ok = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
        ok.click();
        Thread.sleep(pausa);


    }

    @When("Uzytkownik w polu wyszukaj wpisuje Hummingbird Printed Sweater")
    public void uzytkownikWPoluWyszukajWpisuje() throws Throwable {

        WebElement element = driver.findElement(By.xpath("//*[@name='s']"));
        element.clear();
        Thread.sleep(pausa);
        element.sendKeys("Hummingbird printed sweater");
        element.submit();
        Thread.sleep(pausa);


    }

    @And("Uzytkownik wybiera Hummingbird Printed Sweater")
    public void uzytkownikWybieraSweater() throws Throwable {


        WebElement sweater = driver.findElement(By.xpath("//*[@class='thumbnail-container']"));
        Thread.sleep(pausa);
        sweater.click();
        Thread.sleep(pausa);


    }

    @And("^Uzytkownik wybiera rozmiar M$")
    public void uzytkownikWybieraRozmiarM() throws InterruptedException {

        WebElement size = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/select/option[2]"));
        size.click();
        Thread.sleep(pausa);

    }

    @And("Uzytkownik wybiera ilosc sztuk 5szt")
    public void uzytkownikWybieraIloscSztuk() throws InterruptedException {

        WebElement ilosc= driver.findElement(By.name("qty"));
        ilosc.click();
        Thread.sleep(700);
        ilosc.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(700);
        ilosc.sendKeys("5");
        Thread.sleep(700);

    }

    @And("^Uzytkownik dodaje produkt do koszyka$")
    public void uzytkownikDodajeProduktDoKoszyka() throws InterruptedException {

        WebElement AddtoCart = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary add-to-cart')]"));
        AddtoCart.click();
        Thread.sleep(pausa);

    }

    @And("^Uzytkownik przechodzi do opcji checkout$")
    public void uzytkownikPrzechodziDoOpcjiCheckout() throws InterruptedException {

        WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a/i"));
        Checkout.click();
        Thread.sleep(pausa);

        WebElement ProceedCheckout = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        ProceedCheckout.click();
        Thread.sleep(pausa);

    }

    @And("^Uzytkownik potwierdza adres$")
    public void uzytkownikPotwierdzaAdres() throws InterruptedException {

        WebElement addres= driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        addres.submit();
        Thread.sleep(pausa);


    }

    @And("^Uzytkownik wybiera metode odbioru PrestaShop z opcji shipping method$")
    public void uzytkownikWybieraMetodeOdbioruPrestaShop() throws Throwable {

        WebElement Shippingmethod= driver.findElement(By.xpath("//*[@id=\"checkout-delivery-step\"]/h1"));
        Shippingmethod.click();
        Thread.sleep(pausa);

        WebElement PrestalShop= driver.findElement(By.xpath("//*[@id='delivery_option_1']"));
        PrestalShop.submit();
        Thread.sleep(pausa);


    }

    @And("^Uzytkownik przechodzi do opcji payment$")
    public void uzytkownikPrzechodziDoOpcjiPayment() throws InterruptedException {

        WebElement Payment= driver.findElement(By.xpath("//*[@id='checkout-payment-step']/h1"));
        Payment.click();
        Thread.sleep(pausa);

    }

    @And("^Uzytkownik wybiera metode odbioru Pay by Check$")
    public void uzytkownikWybieraMetodeOdbioruPayByCheck() throws InterruptedException {

        WebElement PayByCheck= driver.findElement(By.xpath("//*[@id='payment-option-1']"));
        PayByCheck.click();
        Thread.sleep(pausa);
    }

    @And("^Uzytkownik akceptuje regulamin$")
    public void uzytkownikAkceptujeRegulamin() throws InterruptedException {
        WebElement TermsofService= driver.findElement(By.xpath("//*[@id='conditions_to_approve[terms-and-conditions]']"));
        TermsofService.click();
        Thread.sleep(pausa);
    }

    @And("^Uzytkownik zatwierdza zamowienie$")
    public void uzytkownikZatwierdzaZamowienie() throws InterruptedException {

        WebElement Order= driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        Order.click();
        Thread.sleep(pausa);

    }

    @And("^Uzytkownik robi screenshot z potwierdzeniem zamowienia i kwota$")
    public void uzytkownikRobiScreenshotZPotwierdzeniemZamowieniaIKwota() throws IOException {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\\\screenshots\\screenshot-5.png"));

    }

    @Then("^Zakup zostal dokonany$")
    public void zakupZostalDokonany() {
    }
}
