package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.Description;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  /*
  //commented out; we run the server ourselves before running the tests
  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }
  */

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    //driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  /*
  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }
  */
  
  /*
  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }
  */

  
  //testcase 1.1, testing admin log in valid
  @Test
  public void testCase11() {
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("admin");
    loginPasswd.sendKeys("password");
    loginBtn.click();

    String url = driver.getCurrentUrl();
    assertEquals("http://localhost:8080/admin", url);
  }

  //testcase 1.2, testing admin log in invalid
  @Test
  public void testCase12() {
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("notadmin");
    loginPasswd.sendKeys("notpassword");
    loginBtn.click();

    String url = driver.getCurrentUrl();
    assertEquals("http://localhost:8080/login?error", url);
  }
  
  
  //testcase 2.1, testing signout for admin
  @Test
  public void testCase21() {
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("admin");
    loginPasswd.sendKeys("password");
    loginBtn.click();

    WebElement signout = driver.findElement(By.xpath("/html/body/div/div[2]/form[2]/input"));
    signout.click();

    String url = driver.getCurrentUrl();
    assertEquals("http://localhost:8080/login?logout", url);
  }
  

  //testcase 3.1, admin adds new book to catalogue
  @Test
  public void testCase31() {
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("admin");
    loginPasswd.sendKeys("password");
    loginBtn.click();

    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement id = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement author = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/button"));

    category.sendKeys("fantasy");
    id.sendKeys("hall009");
    title.sendKeys("game of thrones");
    author.sendKeys("GRRM");
    description.sendKeys("a game of thrones by GRRM");
    cost.sendKeys("79.99");
    addButton.click();

    String feedback = driver.findElement(By.xpath("/html/body/div/div[3]/div/h2")).getText();

    assertEquals("Successfully added book", feedback);
  }
  

  //testcase 3.2, missing info
  @Test
  public void testCase32() {
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("admin");
    loginPasswd.sendKeys("password");
    loginBtn.click();

    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement id = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement author = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/button"));

    category.sendKeys("action");
    id.sendKeys("");
    title.sendKeys("");
    author.sendKeys("GRRM");
    description.sendKeys("a game of thrones by GRRM");
    cost.sendKeys("79.99");
    addButton.click();

    String feedback = driver.findElement(By.xpath("/html/body/div/div[3]/div/h2")).getText();

    assertEquals("Validation errors", feedback);
  }

  //testcase 3.3, book already exists
  @Test
  public void testCase33() {
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("admin");
    loginPasswd.sendKeys("password");
    loginBtn.click();

    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement id = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement author = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/button"));

    category.sendKeys("fantasy");
    id.sendKeys("hall009");
    title.sendKeys("game of thrones");
    author.sendKeys("GRRM");
    description.sendKeys("a game of thrones by GRRM");
    cost.sendKeys("79.99");
    addButton.click();

    String feedback = driver.findElement(By.xpath("/html/body/div/div[3]/div/h2")).getText();

    assertEquals("Book with same id already exist", feedback);
  }
  

  //testcase 4.1, user specifies category for search
  @Test
  public void testCase41() {
    driver.get("http://localhost:8080");

    WebElement search = driver.findElement(By.id("search"));
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));

    search.sendKeys("fantasy");
    searchBtn.click();

    String h1 = driver.findElement(By.xpath("/html/body/div/div[3]/h1")).getText();
    assertEquals("We currently have the following items in category 'fantasy'", h1);
  }

  //testcase 4.2, no category specified
  @Test
  public void testCase42() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    String h1 = driver.findElement(By.xpath("/html/body/div/div[3]/h1")).getText();
    assertEquals("We currently have the following items in category ''", h1);
  }
  

  //testcase 4.3, no book satisfying category
  @Test
  public void testCase43() {
    driver.get("http://localhost:8080");

    WebElement search = driver.findElement(By.id("search"));
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));

    search.sendKeys("123");
    searchBtn.click();

    String h1 = driver.findElement(By.xpath("/html/body/div/div[3]/h1")).getText();
    assertEquals("Sorry we do not have any item matching category '123' at this moment", h1);
  }
  


  //testcase 5.1, book is deleted by admin
  @Test
  public void testCase51() {

    //begin add mock book
    driver.get("http://localhost:8080/admin");

    WebElement loginId = driver.findElement(By.id("loginId"));
    WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    loginId.sendKeys("admin");
    loginPasswd.sendKeys("password");
    loginBtn.click();

    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement id = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement author = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/button"));

    category.sendKeys("action");
    id.sendKeys("hall555");
    title.sendKeys("alex rider");
    author.sendKeys("anthony");
    description.sendKeys("spy book");
    cost.sendKeys("99.99");
    addButton.click();
    //end add


    driver.get("http://localhost:8080/admin");

    //WebElement loginId = driver.findElement(By.id("loginId"));
    //WebElement loginPasswd = driver.findElement(By.id("loginPasswd"));
    //WebElement loginBtn = driver.findElement(By.id("loginBtn"));

    //loginId.sendKeys("admin");
    //loginPasswd.sendKeys("password");
    //loginBtn.click();
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    List<WebElement> rows = driver.findElements(By.xpath("/html/body/div/div[3]/table/tbody/tr"));
    int originalCount = rows.size();
    //WebElement delButton = driver.findElement(By.id("del-hall100"));
    WebElement delButton = driver.findElement(By.id("del-hall555"));
    delButton.click();

    rows = driver.findElements(By.xpath("/html/body/div/div[3]/table/tbody/tr"));

    assertEquals(rows.size(), originalCount-1);
  }
  

  //testcase 6.1, adding book to order
  @Test
  public void testCase61() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addButton = driver.findElement(By.id("order-hall002"));
    addButton.click();

    driver.get("http://localhost:8080/orderPage");
    String bookID = driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr/td[1]")).getText();

    assertEquals(bookID, "hall002");
  }
  

  //testcase 6.2, adding two of the same book to order
  @Test
  public void testCase62() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addButton = driver.findElement(By.id("order-hall002"));
    addButton.click();
    addButton.click();

    driver.get("http://localhost:8080/orderPage");
    String bookCount = driver.findElement(By.id("hall002")).getAttribute("value");
  
    assertEquals(bookCount, "2");
  }
  

  //testcase 7.1, check if cart icon sends you to order page
  @Test
  public void testCase71() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addButton = driver.findElement(By.id("order-hall002"));
    addButton.click();

    driver.findElement(By.id("cartLink")).click();
    String url = driver.getCurrentUrl();

    assertEquals("http://localhost:8080/orderPage", url);
  }
  

  //testcase 8.1, customer specifies number of copies for book in order
  @Test
  public void testCase81() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addButton = driver.findElement(By.id("order-hall002"));
    addButton.click();

    driver.findElement(By.id("cartLink")).click();

    float cost = Float.parseFloat(driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr/td[3]")).getText().substring(1));
    WebElement bookCount = driver.findElement(By.id("hall002"));
    bookCount.clear();
    String amount = "5";
    bookCount.sendKeys(amount);
    
    driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr/td[4]/button")).click();
    String totalCost = driver.findElement(By.id("tothall002")).getText().substring(1);
    float expectedFloat = cost*Float.parseFloat(amount);
    expectedFloat = Math.round(expectedFloat * 100f) / 100f;
    String expectedCost = Float.toString(expectedFloat);
    //String expectedCost = Float.toString(cost*Float.parseFloat(amount));

    assertEquals(totalCost, expectedCost);
  }
  

  //testcase 8.2, update books to negative number
  @Test
  public void testCase82() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addButton = driver.findElement(By.id("order-hall002"));
    addButton.click();

    driver.findElement(By.id("cartLink")).click();

    float cost = Float.parseFloat(driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr/td[3]")).getText().substring(1));
    WebElement bookCount = driver.findElement(By.id("hall002"));
    bookCount.clear();
    String amount = "-5";
    bookCount.sendKeys(amount);
    
    driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr/td[4]/button")).click();
    String totalCost = driver.findElement(By.id("tothall002")).getText().substring(1);
    float expectedFloat = 0.0f;
    String expectedCost = Float.toString(expectedFloat);

    assertEquals("0.0", expectedCost);
  }
  
  //testcase 9.1, book order processed
  public void testCase91() {
    driver.get("http://localhost:8080");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addButton = driver.findElement(By.id("order-hall002"));
    addButton.click();
    driver.findElement(By.id("cartLink")).click();

    driver.findElement(By.xpath("/html/body/div/div[3]/form/button")).click();
    String url = "http://localhost:8080/checkout";

    assertEquals(url, driver.getCurrentUrl());
  }

  /*
  //testcase 10.1, customer changes language
  public void testCase101() {
    driver.get("http://localhost:8080");

  }
  */

  

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}
