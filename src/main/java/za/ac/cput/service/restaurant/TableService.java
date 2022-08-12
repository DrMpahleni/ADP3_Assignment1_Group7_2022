package za.ac.cput.service.restaurant;

/*
TableService.java
This is table service class.
Author: Felecia Zweni (218330189)
Date: 07 August 2022

 */

import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.service.IService;

import java.util.List;

public interface TableService extends IService<Table, String> {

    List<Table> getAll(int tblNum);
    void deleteById(int tblNum);

    Table save(Table table);
}
