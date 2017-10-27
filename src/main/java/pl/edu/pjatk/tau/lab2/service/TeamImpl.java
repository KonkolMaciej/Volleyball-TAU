package pl.edu.pjatk.tau.lab2.service;

import pl.edu.pjatk.tau.lab2.models.Team;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maciek on 25.10.17.
 */
public class TeamImpl {

    private TeamService team;

    public void setDataSource(TeamService team) {
        this.team = team;
    }

   public List<Team> findRecordsByRegex(String regexString) {
        Pattern regex = Pattern.compile("(?sm)LABEL.*?(?=^LABEL|\\Z)");
        Matcher regexMatcher = regex.matcher(regexString);
        while (regexMatcher.find()) {
}
    return null;
    }
    public void deleteRecords(List<Team> ListObject) throws ExceptionRecord {
        for (Team a : ListObject) {
            team.delete(a);
        }
    }

}

