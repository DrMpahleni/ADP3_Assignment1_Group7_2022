package za.ac.cput.repository.reservation.impl;

import za.ac.cput.entity.Reservation;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IReservationRepository extends IRepository<Reservation, String> {

    public Set<Reservation> getAll();

    }
