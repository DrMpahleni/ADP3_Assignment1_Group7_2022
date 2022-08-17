/*
ReservationFactory.java
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.util.genericHelper;

import java.util.Date;

public class ReservationFactory {
    public static Reservation createReservation(String name, int amount, String date){

        String reservationID = genericHelper.generateId();

        Reservation reservation = new Reservation.Builder().setName(name).setAmount(amount).setDate(date).build();

        return reservation;
    }
}
