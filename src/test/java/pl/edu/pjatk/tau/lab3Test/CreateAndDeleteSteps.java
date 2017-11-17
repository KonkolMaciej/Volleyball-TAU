package pl.edu.pjatk.tau.lab3Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mock;
import pl.edu.pjatk.tau.lab3.models.Team;
import pl.edu.pjatk.tau.lab3.service.TeamImpl;
import pl.edu.pjatk.tau.lab3.service.TeamService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by maciek on 15.11.17.
 */
public class CreateAndDeleteSteps {
    private static Team crTeamek;
    //private static TeamService testTeam;

    private TeamImpl service = new TeamImpl();
    private Team testTeam = new Team(1, "Tapla", "Kudawa", "Iliga");
    private Team testTeam2 = new Team(2, "apla", "Gdynia", "Iliga");
    private Team testTeam3 = new Team(3, "jablka", "Gdynia", "Iliga");
    static List<Team> listTeam = new ArrayList<>();
    @Mock
    static TeamService mockedTeam;


    @Given("^I have a scenario with record$")
    public void i_have_a_scenario_with_record() throws Throwable {
        Assert.assertNotNull(listTeam);
    }

    @When("^I create is (\\d+) name \"([^\"]*)\" city \"([^\"]*)\" and liga \"([^\"]*)\"$")
    public void i_create_is_name_city_and_liga(int id, String name, String city, String liga) throws Throwable {
        listTeam.add(new Team(id, name, city, liga));
    }

    @When("^I delete record using (\\d+) because i make mistake$")
    public void i_delete_record_using_because_i_make_mistake(int id) throws Throwable {
        listTeam.remove(listTeam);
    }

    @Then("^result should be (\\d+)$")
    public void result_should_be(int arg1) throws Throwable {
        assertEquals(arg1, listTeam.size());
    }


}
