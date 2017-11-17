package pl.edu.pjatk.tau.lab3.models;

/**
 * Created by maciek on 01.10.17.
 */
public class Team {
    private String name;
    private String city;
    private String liga;
    private int id;

    public Team(int id, String name, String city, String liga) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.liga = liga;
    }

    public Team() {

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


}