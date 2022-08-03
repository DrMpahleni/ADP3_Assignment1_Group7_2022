package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.util.genericHelper;

import java.util.Date;

public class ReservationFactory {
    public static Reservation createReservation(String name, int amount, Date date){

        String reservationID = genericHelper.generateId();

        Reservation reservation = new Reservation.Builder().setName(name).setAmount(amount).setDate(date).build();

        return reservation;
    }
}
