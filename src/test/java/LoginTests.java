import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HeadPage;
import pages.LoginPage;

public class LoginTests extends BaseTest
{
    HeadPage headPage = new HeadPage();
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Успешная авторизация")
    void succsessAuthorizationTest(){
        headPage.pushLoginLink();


    }

}
