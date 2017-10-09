package pl.edu.pjatk.tau.lab1Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
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

    }
    @Test
    public void verifyValidDelete(){
        Team a = crTeamek.create(crTeamek);
        Assert.assertNotNull(a);
        crTeamek.delete(a);
        Assert.assertNotNull(a);
    }
    @Test
    public void verifyValidRead(){
        Team a = testTeam.create(crTeamek);
        Assert.assertEquals("Gumed", a.getName());
        Assert.assertEquals("Iliga", a.getLiga());


    }


}
