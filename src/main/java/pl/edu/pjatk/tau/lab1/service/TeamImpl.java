package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.models.Team;

import java.util.ArrayList;
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
        records.remove(a);
    }

    @Override
    public Team read(Team a) {
        a.getTeamId();
        return a;
    }

    @Override
    public Team update(Team a) throws ExceptionRecord {
        if(!this.exist()){
            throw new ExceptionRecord(ExceptionRecord.ExceptionRecord());
        }
        else{
        records.set(a.getTeamId(), a);
        return a;
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
}
