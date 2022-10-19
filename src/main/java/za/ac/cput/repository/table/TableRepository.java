/*ITableRepository.java
This is table repository class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.restaurant.Table;


import java.util.Set;

@Repository
public interface TableRepository extends JpaRepository<Table, String> {

    public Set<Table> getAll();
}
