package za.ac.cput.repository.race;

/* IRaceRepository.java
   This is a IRace Repository class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.race.Race;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends JpaRepository<Race, Integer> {
    public Set<Race> getAll();

}

