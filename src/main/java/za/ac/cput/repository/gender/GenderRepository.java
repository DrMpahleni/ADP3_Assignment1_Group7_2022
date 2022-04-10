package za.ac.cput.repository.gender;

import za.ac.cput.entity.Gender;

import java.util.HashSet;
import java.util.Set;

public class GenderRepository implements IGenderRepository {
    private static GenderRepository repository = null;
    private Set<Gender> genderDB = null;

    private GenderRepository(){
        genderDB = new HashSet<Gender>();
    }
    public static GenderRepository getRepository(){
        if(repository == null){
            repository = new GenderRepository();
        }
        return repository;
    }


    @Override
    public Gender create(Gender gender) {
        boolean success = genderDB.add(gender);
        if(!success)
            return null;
        return gender;
    }

    @Override
    public Gender read(String Id) {
        for(Gender g : genderDB)
            if (g.getId().equals(Id)){
                return g;
            }
        return null;
    }

    @Override
    public Gender update(Gender gender) {
        Gender oldGender = read(gender.getId());
        if (oldGender != null){
            genderDB.remove(oldGender);
            genderDB.add(gender);
            return gender;

        }
        return null;
    }

    @Override
    public boolean delete(String Id) {
        Gender genderDeleted = read(Id);
        if(genderDeleted == null)
            return false;
        genderDB.remove(genderDeleted);
        return true;
    }

    @Override
    public Set<Gender> getAll() {
        return genderDB;
    }
}
