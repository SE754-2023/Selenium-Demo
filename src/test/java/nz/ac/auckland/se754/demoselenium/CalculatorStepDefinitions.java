package nz.ac.auckland.se754.demoselenium;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorStepDefinitions {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = DriverSingleton.getInstance().getDriver();

    }

   @AfterStep
    public void afterEachStep(){
        // to make the test at human speed
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Given("I open the calculator page")
    public void i_open_the_calculator_page() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Given("I enter {int} into the calculator")
    public void i_enter_into_the_calculator(Integer int1) {
        driver.findElement(By.id("number1Field")).sendKeys(String.valueOf(int1));
    }

    @Given("I also enter {int} into the calculator")
    public void i_also_enter_into_the_calculator(Integer int1) {
        driver.findElement(By.xpath("/html/body/section/div/div/div/form[2]/div[2]/div[2]/input")).sendKeys(String.valueOf(int1));

    }

    @When("I press add")
    public void i_press_add() {
        driver.findElement(By.cssSelector("#calculateButton")).click();
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer int1) {
        String result = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
        //String result =  driver.findElement(By.id("numberAnswerField")).getText();
        assertEquals(String.valueOf(int1), result);
    }


}
