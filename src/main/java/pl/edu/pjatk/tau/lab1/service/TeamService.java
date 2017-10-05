package pl.edu.pjatk.tau.lab1.service;

/**
 * Created by maciek on 01.10.17.
 */
public interface TeamService {
     void create(int teamId, String name, String liga, String city);
     void delete(int id);
     void read();
     void read(int id);
     void update(int id);
}
