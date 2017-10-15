package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.models.Team;


/**
 * Created by maciek on 01.10.17.
 */
public interface TeamService <T> {
     Team  create(Team a);
     void  delete(Team a);
     Team  read(Team a);
     Team  update(Team a);
     boolean isEmpty();



}
