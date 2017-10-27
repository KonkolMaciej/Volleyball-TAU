package pl.edu.pjatk.tau.lab2.service;

import pl.edu.pjatk.tau.lab2.models.Team;

import java.util.List;

public interface TeamService<T> {
    Team create(Team a);

    void delete(Team a) throws ExceptionRecord;

    List<Team> list();

    Team update(Team a) throws ExceptionRecord;

    boolean isEmpty();

}
