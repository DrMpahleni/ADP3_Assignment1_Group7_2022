/*ITableRepository.java
This is table repository class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.table.impl;

import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ITableRepository extends IRepository<Table, String> {
    public Set<Table> getAll();
}
