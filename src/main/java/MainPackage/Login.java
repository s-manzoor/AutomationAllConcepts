package MainPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    // public static WebDriver driver;

    public Login(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginBtn;

    @FindBy(linkText = "Logout")
    public WebElement Logout;

    //  @FindBy(css = ".auth_error")
    // public WebElement loginError;
    @FindBy(className = "auth_error")
    public WebElement loginError;

    @FindBy(id = "username_show")
    public WebElement loginVerification;

    @FindBy(className = "reg_success")
    public WebElement logoutMessage;

    @FindBy (linkText = "Forgot Password?")
    public WebElement forgotPassword;

    @FindBy (id = "emailadd_recovery")
    public WebElement recoveryEmail;

    @FindBy (id = "Submit")
    public WebElement emailPassword;

    @FindBy(xpath= "//td[@class='reg_success']")
    public WebElement passwordRecoveryMessage;


    public void setUsername(String user) { // Setter
        userName.clear();
        userName.sendKeys(user);

    }

    public void setPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }

    public void loginClick() {
        loginBtn.click();
    }

    public void Logout() {
        Logout.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

    public void setRecoveryEmail(){
        recoveryEmail.clear();
        recoveryEmail.sendKeys("msajidmanzoor8@gmail.com");
    }
    public void emailPassword (){
        emailPassword.click();
    }
    public void InputCredentials(String userName, String password) { // Getter
        setUsername(userName);
        setPassword(password);
        // loginClick();

    }

    /*  public void loginMethod (WebDriver driver, String userName, String password) {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
   }
*/


}
