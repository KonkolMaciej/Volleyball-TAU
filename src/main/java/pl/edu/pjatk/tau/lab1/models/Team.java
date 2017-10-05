package pl.edu.pjatk.tau.lab1.models;

import pl.edu.pjatk.tau.lab1.service.TeamService;

/**
 * Created by maciek on 01.10.17.
 */
public class Team  implements TeamService{
    private int teamId;
    private String name;
    private String city;
    private String liga;

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


    public void create(int teamId, String name, String liga, String city) {

    }

    public void delete(int id) {

    }

    public void read() {

    }

    public void read(int id) {

    }

    public void update(int id) {

    }
}
