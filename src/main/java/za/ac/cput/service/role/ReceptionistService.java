/*
ReceptionistService.java
This is receptionist service class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.service.role;

import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.service.IService;

import java.util.List;

public interface ReceptionistService extends IService<Receptionist, String> {

    List<Receptionist> getAll(String receptionId);
    void deleteById(String receptionId);

    Receptionist save(Receptionist receptionist);
}
