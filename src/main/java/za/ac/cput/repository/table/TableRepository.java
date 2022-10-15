/*
TableFactory.java
Author: Felecia Zweni (218330189)
Date: August 2022
 */

package za.ac.cput.repository.table;

import za.ac.cput.domain.restaurant.Table;

import java.util.HashSet;
import java.util.Set;

public class TableRepository {

    private static TableRepository repository = null;
    private Set<Table> tableDB = null;

    private TableRepository() {
        tableDB = new HashSet<Table>();
    }

    public static TableRepository getRepository() {
        if (repository == null) {
            repository = new TableRepository();
        }
        return repository;
    }


    public Table create(Table table) {
        boolean success = tableDB.add(table);
        if (!success)
            return null;
        return table;
    }


    public Table read(String tblNum) {
        Table table = tableDB.stream()
                .filter(e -> e.getTblNum() == tblNum)
                .findAny()
                .orElse(null);
        return table;
    }


    public Table update(Table table){
        Table oldTable = read(table.getTblNum());
        if(oldTable != null) {
            tableDB.remove(oldTable);
            tableDB.add(table);
            return table;
        }
        return null;
    }


    public boolean delete(String tblNum) {
        Table tableToDelete = read(tblNum);
        if(tableToDelete == null)
            return false;
        tableDB.remove(tableToDelete);
        return true;
    }

    public Set<Table> getAll(){
        return tableDB;
    }







}
