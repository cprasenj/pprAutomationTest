import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
    public static String dashBoardUrl = "localhost:3000";

    public WebElement q_username;

    public WebElement commit;

    @FindBy(how= How.CSS, css = "#bg-grey padding10")
    public WebElement ateam;

    public void searchTeam(String teamName) {
        ateam.click();
    }
}
