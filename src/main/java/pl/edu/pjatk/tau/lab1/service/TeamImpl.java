package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.models.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciek on 09.10.17.
 */
public class TeamImpl extends Team implements TeamService {

    public TeamImpl() {

    }

    static List<Team> records = new ArrayList<>();

//     public  List<Team> records() {
//         List<Team> team = new ArrayList<>();
//        return team;}

    @Override
    public void delete(Team a) {
        records.remove(a);
    }

    @Override
    public Team read(Team a) {
        a.getTeamId();
        return a;
    }

    @Override
    public Team update(Team a) {
        records.set(a.getTeamId(), a);
         return a;
    }
    @Override
    public Team create(Team a) {
        a.getTeamId();
        records.add(a);
        return a;
    }

        public  boolean giveListSize()
    {
        if(records.isEmpty())
            return true;
        else
            return false;
    }

}
