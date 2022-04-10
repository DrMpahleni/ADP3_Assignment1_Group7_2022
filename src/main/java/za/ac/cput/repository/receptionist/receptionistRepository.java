package za.ac.cput.repository.receptionist;


import za.ac.cput.entity.Receptionist;

import java.util.HashSet;
import java.util.Set;

public class receptionistRepository {

    private static receptionistRepository repository = null;
    private Set<Receptionist> receptionistDB = null;

    private receptionistRepository() {
        receptionistDB = new HashSet<Receptionist>();
    }

    public static receptionistRepository getRepository() {
        if (repository == null) {
            repository = new receptionistRepository();
        }
        return repository;
    }


    public Receptionist create(Receptionist receptionist) {
        boolean success = receptionistDB.add(receptionist);
        if (!success)
            return null;
        return receptionist;
    }


    public Receptionist read(String receptionId) {
        Receptionist receptionist = receptionistDB.stream()
                .filter(e -> e.getReceptionId().equals(receptionId))
                .findAny()
                .orElse(null);
        return receptionist;
    }


    public Receptionist update(Receptionist receptionist){
        Receptionist oldReception = read(receptionist.getReceptionId());
        if(oldReception != null) {
            receptionistDB.remove(oldReception);
            receptionistDB.add(receptionist);
            return receptionist;
        }
        return null;
    }


    public boolean delete(String receptionId) {
        Receptionist receptionistToDelete = read(receptionId);
        if(receptionistToDelete == null)
            return false;
        receptionistDB.remove(receptionistToDelete);
        return true;
    }

    public Set<Receptionist> getAll(){
        return receptionistDB;
    }






}
