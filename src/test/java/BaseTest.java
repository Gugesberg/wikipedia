import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void preTestingSettings(){
        Configuration.baseUrl = "https://ru.wikipedia.org/";
        Configuration.pageLoadStrategy = "eager";
    }
}
