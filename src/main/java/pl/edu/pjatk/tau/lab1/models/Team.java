package pl.edu.pjatk.tau.lab1.models;

import pl.edu.pjatk.tau.lab1.service.TeamService;

import java.util.ArrayList;
import java.util.List;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

/**
 * Created by maciek on 01.10.17.
 */
public class Team implements TeamService {
    private String name;
    private String city;
    private String liga;
    private int id;

    public Team(int id, String name, String city, String liga){
        this.id =id ;
        this.name = name;
        this.city = city;
        this.liga = liga;
    }

    public Team() {

    }

    public Team create(Team a) {
        a.getTeamId();
        records().add(a);
        return a;
    }

    public List<Team> records() {
        List<Team> team = new ArrayList<>();
        return team;
    }
    public int getTeamId() {
        return id;
    }

    public void setTeamId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    @Override
    public Team delete(Team a) {
//        a.getTeamId();
        records().remove(a);
        return a;
    }


    @Override
    public Team read(Team a) {
        a.getTeamId();
        return a;


    }

    @Override
    public Team update(Team a) {
       // a.setName(getTeamId());
        return a;
    }

}
