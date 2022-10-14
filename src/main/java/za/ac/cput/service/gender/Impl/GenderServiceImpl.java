package za.ac.cput.service.gender.Impl;

/* EmployeeGenderServiceImpl.java
 This is a Employee Gender Service Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.repository.gender.IGenderRepository;
import za.ac.cput.service.gender.IGenderService;
import java.util.Optional;
import java.util.Set;

@Service
public class GenderServiceImpl implements IGenderService {
    private IGenderRepository genderRepository;

    public GenderServiceImpl(IGenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public GenderServiceImpl(){
    }
    @Override
    public Gender create(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public Optional<Gender> read(String employeeId) {
        return genderRepository.findById(employeeId);
    }

    @Override
    public Gender update(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public void delete(Gender gender) {
    genderRepository.delete(gender);
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
