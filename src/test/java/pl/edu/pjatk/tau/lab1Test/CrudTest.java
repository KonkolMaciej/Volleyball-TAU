package pl.edu.pjatk.tau.lab1Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.edu.pjatk.tau.lab1.models.Team;
import pl.edu.pjatk.tau.lab1.service.TeamService;
import pl.edu.pjatk.tau.lab1.service.add;

/**
 * Created by maciek on 01.10.17.
 */
public class CrudTest {
    TeamService tm = (TeamService) new Team();
    private static TeamService testTeam;
    private static Team crTeamek;

    @BeforeClass
    public static void setUp(){
        crTeamek = new Team(1,"Gumed","Gdynia","Iliga");
        testTeam = new add();
    }

    @Test
    public void verifyValidCreate(){
        Team a = testTeam.create(crTeamek);
        Assert.assertEquals(1, a.getTeamId());
    }

    @Test
    public void verifyValidUpdate(){

    }
    @Test
    public void verifyValidDelete(int id){
        Team a = testTeam.create(crTeamek);
        Assert.assertNotNull(a);
        testTeam.delete(a);
        Assert.assertNull(a);
    }
    @Test
    public void verifyValidRead(){
        Team a = testTeam.create(crTeamek);
        Assert.assertEquals("Gumed", a.getName());

    }


}
