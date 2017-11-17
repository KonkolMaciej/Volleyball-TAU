package pl.edu.pjatk.tau.lab3.service;

import pl.edu.pjatk.tau.lab3.models.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamImpl extends Team implements TeamService {

    public TeamImpl() {

    }

    static List<Team> records = new ArrayList<>();


    public Team updaterec(Team a) {
        records.set(a.getTeamId(), a);
        return a;
    }
    @Override
    public void delete(Team a) {
        Team team = records.remove(a.getTeamId());
    }

    @Override
    public Team read(Team a) {
        a.getTeamId();
        return a;
    }

    @Override
    public Team update(Team b) throws ExceptionRecord {
        if(!this.exist()){
            throw new ExceptionRecord(ExceptionRecord.ExceptionRecord());
        }
        else{
             records.set(b.getTeamId(), b);
        return b;
        }
    }

    @Override
    public Team create(Team a) {
        a.getTeamId();
        records.add(a);
        return a;
    }

    public boolean isEmpty()
    {
        if(records.isEmpty())
            return true;
        else
            return false;
    }

    public  boolean exist(){
        for (Team t :records)
        {
            if(t.getTeamId()==this.getTeamId())
            return true;
        }
        return false;

    }

    public List<Team> findRecordsByRegex(String regexString) {
        List<Team> listMatches = new ArrayList<>();

        for (Iterator<Team> teamIterator = records.iterator(); teamIterator.hasNext(); ) {
            Team a = teamIterator.next();
            if (a.getName().matches(regexString)) {
                listMatches.add(a);
            }
        }
        return listMatches;
    }
    public List<Team> countOfRecords(){
        List<Team> list = new ArrayList<>();

        for (Iterator<Team> teamIterator = records.iterator(); teamIterator.hasNext(); ) {
            Team a = teamIterator.next();
                list.add(a);
            }

        return list;

    }
}
