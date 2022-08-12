/*
ReservationRepository.java
Author: Felecia Zweni(218330189)
 */

package za.ac.cput.repository.reservation;



import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.repository.reservation.impl.IReservationRepository;

import java.util.HashSet;
import java.util.Set;

public class ReservationRepository implements IReservationRepository {

    private static ReservationRepository repository = null;
    private Set<Reservation> reservationDB = null;

    private ReservationRepository() {
        reservationDB = new HashSet<Reservation>();
    }

    public static ReservationRepository getRepository() {
        if (repository == null) {
            repository = new ReservationRepository();
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
