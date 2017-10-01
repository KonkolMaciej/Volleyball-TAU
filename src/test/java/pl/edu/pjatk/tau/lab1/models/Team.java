package pl.edu.pjatk.tau.lab1.models;

/**
 * Created by maciek on 01.10.17.
 */
public class Team {
    private int teamId;
    private String name;
    private String city;
    private String liga;
//    enum categoryGame;

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
