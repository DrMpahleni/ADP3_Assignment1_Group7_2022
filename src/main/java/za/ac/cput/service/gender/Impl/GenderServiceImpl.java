package za.ac.cput.service.gender.Impl;

/* EmployeeGenderServiceImpl.java
 This is a Employee Gender Service Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.repository.gender.GenderRepository;
import za.ac.cput.service.gender.IGenderService;

import java.util.Optional;
import java.util.Set;
@Service
public class GenderServiceImpl implements IGenderService {
    private static GenderServiceImpl gender =null;
    private GenderRepository genderRepository;

    public GenderServiceImpl() {
        this.genderRepository = GenderRepository.getRepository();
    }
    public static GenderServiceImpl getGender(){

        if (gender == null) {
            gender = new GenderServiceImpl();
        }
        return gender;
    }

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.create(gender);
    }

    @Override
    public Optional<Gender> read(String employeeId) {
        return Optional.ofNullable(this.genderRepository.read(employeeId));
    }

    @Override
    public Gender update(Gender gender) {
        return this.genderRepository.update(gender);
    }

    @Override
    public void delete(Gender gender) {
    return;
    }

    @Override
    public Set<Gender> getAll() {
        return this.genderRepository.getAll();
    }

    @Override
    public void deleteById(String employeeId) {
        Optional<Gender> gender = read(employeeId);
        if (gender.isPresent()) delete(gender.get());
    }
}
