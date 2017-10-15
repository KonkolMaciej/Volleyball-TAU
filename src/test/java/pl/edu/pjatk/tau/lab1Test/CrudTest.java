package pl.edu.pjatk.tau.lab1Test;

import org.junit.*;
import pl.edu.pjatk.tau.lab1.models.Team;
import pl.edu.pjatk.tau.lab1.service.TeamImpl;
import pl.edu.pjatk.tau.lab1.service.TeamService;

/**
 * Created by maciek on 01.10.17.
 */
public class CrudTest {
    private static TeamService testTeam;
    private static Team crTeamek;

    @BeforeClass
    public static void setUp(){
        crTeamek = new Team(1,"Gumed","Gdynia","Iliga");
        testTeam = new TeamImpl();
    }


    @Test
    public void verifyValidCreate(){
        Team a = testTeam.create(crTeamek);
        Assert.assertEquals(1, a.getTeamId());
        Assert.assertEquals("Gdynia", a.getCity());
        Assert.assertEquals("Iliga", a.getLiga());
    }

    @Test
    public void verifyValidUpdate(){
        Team a = testTeam.create(crTeamek);
        a.setName("Tapla");
        testTeam.update(a);
        Assert.assertEquals("Tapla", a.getName());

    }

    @Test
    public void verifValidaDelete(){
        Team a = testTeam.create(crTeamek);
        testTeam.delete(a);
        Assert.assertTrue(testTeam.isEmpty());
    }
    @Test
    public void verifyValidRead(){
        Team a = testTeam.create(crTeamek);
        Assert.assertEquals("Gumed", a.getName());
        Assert.assertEquals("Iliga", a.getLiga());
    }
}
