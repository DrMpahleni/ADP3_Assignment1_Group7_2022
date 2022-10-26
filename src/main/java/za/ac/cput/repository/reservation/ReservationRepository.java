/*
IReservationRepository.java
Author: Felecia Zweni (218330189)
Date: August 2022
 */

package za.ac.cput.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    public Set<Reservation> getAll();

    }
