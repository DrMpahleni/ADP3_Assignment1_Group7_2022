package za.ac.cput.repository.reservation;


import za.ac.cput.entity.Reservation;
import za.ac.cput.repository.reservation.impl.IReservationRepository;

import java.util.HashSet;
import java.util.Set;

public class reservationRepository implements IReservationRepository {

    private static reservationRepository repository = null;
    private Set<Reservation> reservationDB = null;

    private reservationRepository() {
        reservationDB = new HashSet<Reservation>();
    }

    public static reservationRepository getRepository() {
        if (repository == null) {
            repository = new reservationRepository();
        }
        return repository;
    }


    public Reservation create(Reservation reservation) {
        boolean success = reservationDB.add(reservation);
        if (!success)
            return null;
        return reservation;
    }


    public Reservation read(String name) {
        Reservation reservation = reservationDB.stream()
                .filter(e -> e.getName().equals(name))
                .findAny()
                .orElse(null);
        return reservation;
    }


    public Reservation update(Reservation reservation){
        Reservation oldReservation = read(reservation.getName());
        if(oldReservation != null) {
            reservationDB.remove(oldReservation);
            reservationDB.add(reservation);
            return reservation;
        }
        return null;
    }


    public boolean delete(String name) {
        Reservation reservationToDelete = read(name);
        if(reservationToDelete == null)
            return false;
        reservationDB.remove(reservationToDelete);
        return true;
    }

    public Set<Reservation> getAll(){
        return reservationDB;
    }







}
