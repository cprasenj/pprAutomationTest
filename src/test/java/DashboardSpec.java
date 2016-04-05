import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class DashboardSpec {

    private final WebDriver driver;
    private final DashboardPage dashboardPage;

    public DashboardSpec() {
        this.driver = DriverFactory.getDriver();
        this.dashboardPage = new DashboardPage();
    }

    @Step("On the Dashboard page")
    public void goToDashBoard() {
        driver.get(DashboardPage.dashBoardUrl);
    }

    @Step("The team <team> is listed")
    public void findTheTeam(String teamName) {
        List links = (List) driver.findElements(By.tagName("a"));
        boolean isTeamPresent = false;
        for (Object link : links) {
            if (((WebElement) link).getText().equals(teamName)) {
                isTeamPresent = true;
            }
        }
        assertTrue(isTeamPresent);
    }

    @Step("Click on <team> team link")
    public void goToATeamPage(String teamName) {
        List links = (List) driver.findElements(By.tagName("a"));
        for (Object link : links) {
            if (((WebElement) link).getText().equals(teamName)) {
                ((WebElement) link).click();
                break;
            }
        }
    }

    @Step("click on team for <teamName> to view all members of that team")
    public void listAllTeamMembersForAGivenTeam(String teamName) throws InterruptedException {
        driver.get(DashboardPage.dashBoardUrl);
        List links = (List) driver.findElements(By.tagName("a"));
        boolean isTeamPresent = false;
        for (Object link : links) {
            if (((WebElement) link).getText().equals(teamName)) {
                ((WebElement) link).click();
                isTeamPresent = true;
                break;
            }
        }
        assertTrue(isTeamPresent);
        links = (List) driver.findElements(By.tagName("a"));
        for (Object link : links) {
            if (((WebElement) link).getText().equals("Team")) {
                ((WebElement) link).click();
                break;
            }
        }

        List<WebElement> teamMembers = driver.findElements(By.tagName("main"));
        boolean isTeamMemberPresent = false;
        for (WebElement teamMember : teamMembers) {
            if (teamMember.getText().equals("rajasoun@edaas.com")){
                isTeamMemberPresent = true;
            }
        }
        assertTrue(isTeamMemberPresent);
        Thread.sleep(5000);
    }
}
