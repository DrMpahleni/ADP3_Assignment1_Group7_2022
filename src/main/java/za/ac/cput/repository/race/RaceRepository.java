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
        return null;
    }

    @Override
    public Race read(String s) {
        return null;
    }

    @Override
    public Race update(Race race) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Set<Race> getAll() {
        return null;
    }
}
