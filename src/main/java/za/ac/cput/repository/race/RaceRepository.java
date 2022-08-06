package za.ac.cput.repository.race;

/* RaceRepository.java
   This is an Ingredients Repository class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.race.Race;
import za.ac.cput.repository.race.impl.IRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepository implements IRaceRepository {

    private static RaceRepository repository = null;
    private Set<Race> raceDB = null;

    private RaceRepository() {

        raceDB = new HashSet<Race>();
    }

    public static RaceRepository getRepository() {
        if (repository == null) {
            repository = new RaceRepository();
        }
        return repository;
    }
    @Override
    public Race create(Race race) {
        boolean success = raceDB.add(race);
        if(!success){
            return null;
        }
        return race;
    }

    @Override
    public Race read(Integer id) {
        for (Race r : raceDB) {
        }
        return null;
    }

    @Override
    public Race update(Race race) {
        Race oldRace = read(race.getId());
        if(oldRace != null){
            raceDB.remove(oldRace);
            raceDB.add(race);
            return race;
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Race raceToDelete = read(id);
        if(raceToDelete == null){
            return false;
        }
        return true;
    }

    @Override
    public Set<Race> getAll() {
        return null;
    }
}
