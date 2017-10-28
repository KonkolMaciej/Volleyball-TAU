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
import pl.edu.pjatk.tau.lab2.service.TeamImpl;
import pl.edu.pjatk.tau.lab2.service.TeamService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CrudMockTest {

    private TeamImpl service = new TeamImpl();
    private Team testTeam = new Team(1, "Tapla", "Kudawa", "Iliga");
    private Team testTeam2 = new Team(2, "apla", "Gdynia", "Iliga");
    private Team testTeam3 = new Team(3, "jablka", "Gdynia", "Iliga");

    @Mock
    static TeamService mockedTeam;

    @Before
    public void setUp() {
        Assert.assertNotNull(mockedTeam);
        service.setDataSource(mockedTeam);
    }


    @Test
    public void verifyValidDeleteWithInOrder() throws ExceptionRecord {

        assertNotNull(mockedTeam);
        InOrder inOrder = inOrder(mockedTeam);
        List<Team> listTeam = new ArrayList<Team>();
        listTeam.add(testTeam);
        listTeam.add(testTeam2);
        service.deleteRecords(listTeam);
        inOrder.verify(mockedTeam, times(1)).delete(testTeam);
        inOrder.verify(mockedTeam, times(1)).delete(testTeam2);

    }

    @Test
    public void verifyValidDelete() throws ExceptionRecord {

        List<Team> listTeam3 = new ArrayList<Team>();
        listTeam3.add(testTeam3);
        service.deleteRecords(listTeam3);
        verify(mockedTeam, times(1)).delete(testTeam3);

    }

    @Test(expected = ExceptionRecord.class)
    public void verifyValidDeleteExceptions() throws ExceptionRecord {
        List<Team> listTeam3 = new ArrayList<Team>();
        listTeam3.add(testTeam3);
        service.deleteRecords(listTeam3);

        doThrow(new ExceptionRecord(ExceptionRecord.ExceptionRecord()))
                .when(mockedTeam).delete(any(Team.class));
        service.deleteRecords(listTeam3);
    }

    @Test
    public void testFindRecordsByRegex() {

        List<Team> list = new ArrayList<>();
        list.add(testTeam);
        list.add(testTeam2);
        list.add(testTeam3);

        when(mockedTeam.list()).thenReturn(list);
        List<Team> teams = service.findRecordsByRegex("Tapla");
        assertNotNull(teams);
        assertEquals(1, teams.size());

        teams = service.findRecordsByRegex("Fs*s");
        assertNotNull(teams);
        assertEquals(0, teams.size());
        verify(mockedTeam, times(2)).list();
    }
}
