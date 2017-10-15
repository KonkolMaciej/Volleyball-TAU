package pl.edu.pjatk.tau.lab1Test;

import org.junit.*;
import pl.edu.pjatk.tau.lab1.models.Team;
import pl.edu.pjatk.tau.lab1.service.ExceptionRecord;
import pl.edu.pjatk.tau.lab1.service.TeamImpl;
import pl.edu.pjatk.tau.lab1.service.TeamService;

/**
 * Created by maciek on 01.10.17.
 */
public class CrudTest {
    private static TeamService testTeam;
    private static TeamService testTeamEx;
    private static Team crTeamek;
    private static Team crTeamek2;

    @BeforeClass
    public static void setUp(){
        crTeamek = new Team(1,"Gumed","Gdynia","Iliga");
        crTeamek2 = new Team(4,"Gumed","Gdynia","Iliga");
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
    public void verifyValidUpdate() throws ExceptionRecord{
        Team a = testTeam.create(crTeamek);
        a.setName("Tapla");
        a = testTeam.updaterec(new Team(3, "gdynia", "tttt","bbbb"));
        Assert.assertEquals("gdynia", a.getName());

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

    @Test(expected = ExceptionRecord.class)
    public void verifyValidUpdateException() throws ExceptionRecord{
            testTeamEx = new TeamImpl();
            Team c = testTeamEx.create(crTeamek2);
            testTeamEx.update(new Team(2, "aaaa", "tttt","bbbb"));





    }


}
