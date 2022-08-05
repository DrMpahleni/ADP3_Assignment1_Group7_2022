package za.ac.cput.repository.race;

import za.ac.cput.entity.Race;

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
    public Race read(String s) {
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
    public boolean delete(String id) {
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
