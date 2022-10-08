package za.ac.cput.repository.Position;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.employee.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}

