/*
IReservationRepository.java
Author: Felecia Zweni (218330189)
Date: August 2022
 */

package za.ac.cput.repository.reservation.impl;

import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IReservationRepository extends IRepository<Reservation, String> {

    public Set<Reservation> getAll();

    }
