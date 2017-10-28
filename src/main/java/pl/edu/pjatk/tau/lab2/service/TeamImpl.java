package pl.edu.pjatk.tau.lab2.service;

import pl.edu.pjatk.tau.lab2.models.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by maciek on 25.10.17.
 */
public class TeamImpl {

    private TeamService team;

    public void setDataSource(TeamService team) {
        this.team = team;
    }

    Pattern pattern = Pattern.compile("(\\[)(.*?)(\\])");
    private CharSequence string;
   // Matcher matcher = pattern.matcher(string);

    public List<Team> findRecordsByRegex(String regexString) {
        List<Team> list = team.list();
        List<Team> listMatches = new ArrayList<>();

        for (Iterator<Team> teamIterator = list.iterator(); teamIterator.hasNext(); ) {
            Team a = teamIterator.next();
            if (a.getName().matches(regexString)) {
                listMatches.add(a);
            }
        }
        return listMatches;
    }

    public void deleteRecords(List<Team> ListObject) throws ExceptionRecord {
        for (Team a : ListObject) {
            team.delete(a);
        }
    }

}

