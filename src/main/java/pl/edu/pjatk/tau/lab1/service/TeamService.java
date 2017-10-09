package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.models.Team;

import java.util.List;

/**
 * Created by maciek on 01.10.17.
 */
public interface TeamService <T> {
     Team  create(Team a);
     Team  delete(Team a);
     Team  read(Team a);
     Team  update(Team a);
     public List<Team> records();
}
