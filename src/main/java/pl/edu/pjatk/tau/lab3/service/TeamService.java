package pl.edu.pjatk.tau.lab3.service;

import pl.edu.pjatk.tau.lab3.models.Team;

public interface TeamService <T> {
     Team  create(Team a);
     void  delete(Team a);
     Team  read(Team a);
     Team  update(Team a) throws ExceptionRecord;
     boolean isEmpty();
     Team updaterec(Team team);

}
