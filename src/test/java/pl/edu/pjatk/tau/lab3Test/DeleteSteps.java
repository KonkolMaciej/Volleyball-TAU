package pl.edu.pjatk.tau.lab3Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.mockito.Mock;
import pl.edu.pjatk.tau.lab3.models.Team;
import pl.edu.pjatk.tau.lab3.serviceo.TeamImpl;
import pl.edu.pjatk.tau.lab3.serviceo.TeamService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class DeleteSteps {
    private static Team crTeamek;

    private TeamImpl service = new TeamImpl();
    private Team testTeam = new Team(1, "Tapla", "Kudawa", "Iliga");
    private Team testTeam2 = new Team(2, "apla", "Gdynia", "Iliga");

    static List<Team> listTeams = new ArrayList<Team>();
    @Mock
    static TeamService mockedTeam;

    @Before
    public void setUp() {
        service.setDataSource(mockedTeam);
        listTeams.add(testTeam);
        listTeams.add(testTeam2);
    }

    @Given("^I have a list with record$")
    public void i_have_a_list_with_record() throws Throwable {
        assertNotNull(listTeams);
    }

    @When("^I delete it$")
    public void i_delete_it() throws Throwable {
        service.deleteRecords(listTeams);
    }

    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int arg1) throws Throwable {
        assertEquals(0, listTeams.size());

    }
}
