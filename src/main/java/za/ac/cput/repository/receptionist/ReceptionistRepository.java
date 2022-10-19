/*
IReceptionistRepository.java
This is ireceptionist repository class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.receptionist;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ReceptionistRepository extends JpaRepository<Receptionist, String> {
    public Set<Receptionist> getAll();
}
