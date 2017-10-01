package pl.edu.pjatk.tau.lab1.service;

/**
 * Created by maciek on 01.10.17.
 */
public interface TeamService {
    abstract void create();
    abstract void delete();
    abstract void read();
    abstract void read(int id);
    abstract void update(int id);
}
