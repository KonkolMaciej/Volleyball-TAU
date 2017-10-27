package pl.edu.pjatk.tau.lab2Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.edu.pjatk.tau.lab2.models.Team;
import pl.edu.pjatk.tau.lab2.service.ExceptionRecord;
import pl.edu.pjatk.tau.lab2.service.TeamService;
import pl.edu.pjatk.tau.lab2.service.TeamImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CrudMockTest {

    private TeamImpl service = new TeamImpl();
    private Team testTeam = new Team(1,"Tapla","Kudawa","Iliga");
    private Team testTeam2 = new Team(2,"apla","Gdynia","Iliga");
    private Team testTeam3 = new Team(3,"apla","Gdynia","Iliga");

    @Mock
    static TeamService mockedTeam;

    @Before
    public void setUp() {
        Assert.assertNotNull(mockedTeam);
        service.setDataSource(mockedTeam);
    }
//
//    @Test(expected = ExceptionRecord.class)
//    public void testExceptionInDeleteRecords() throws ExceptionRecord {
//        doThrow(new ExceptionRecord(ExceptionRecord.ExceptionRecord()))
//                .when(mockedTeam).delete(testTeam3);
//    }
    @Test
    public void verifyValidDelete() throws ExceptionRecord {

        assertNotNull(mockedTeam);
        InOrder inOrder = inOrder(mockedTeam);
        List<Team> listTeam = new ArrayList<Team>();
        listTeam.add(testTeam);
        listTeam.add(testTeam2);
        service.deleteRecords(listTeam);
        inOrder.verify(mockedTeam, times(1)).delete(testTeam);
        inOrder.verify(mockedTeam, times(1)).delete(testTeam2);

    }
}
