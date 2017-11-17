package pl.edu.pjatk.tau.lab3Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mock;
import pl.edu.pjatk.tau.lab3.models.Team;
import pl.edu.pjatk.tau.lab3.service.TeamImpl;
import pl.edu.pjatk.tau.lab3.service.TeamService;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamRegSteps {


    private TeamImpl service = new TeamImpl();
    private Team testTeam = new Team(1, "Tapla", "Kudawa", "Iliga");
    private Team testTeam2 = new Team(2, "apla", "Gdynia", "Iliga");

    private List<Team> listTeam;
    private List<Team> listTeamReg;
    @Mock
    static TeamService mockedTeam;


    @Given("^there is one Team$")
    public void there_is_one_Team() throws Throwable {
        Team a = service.create(testTeam);
        Team b = service.create(testTeam2);
        Assert.assertEquals(1, a.getTeamId());
        Assert.assertEquals(2, b.getTeamId());
    }

    @When("^start of this team is passed as \"([^\"]*)\"$")
    public void start_of_this_team_is_passed_as(String reg) throws Throwable {
        listTeam = service.countOfRecords();
        service.findRecordsByRegex(reg);
        listTeamReg = service.findRecordsByRegex(reg);
    }

    @Then("^we should find this Team$")
    public void we_should_find_this_Team() throws Throwable {
        assertEquals(1, listTeamReg.size());

    }

    @Then("^we have more team in list$")
    public void we_have_more_team_in_list() throws Throwable {
        assertEquals(2, listTeam.size());
    }

}