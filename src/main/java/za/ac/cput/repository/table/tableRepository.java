package za.ac.cput.repository.table;

import za.ac.cput.entity.Table;

import java.util.HashSet;
import java.util.Set;

public class tableRepository {

    private static tableRepository repository = null;
    private Set<Table> tableDB = null;

    private tableRepository() {
        tableDB = new HashSet<Table>();
    }

    public static tableRepository getRepository() {
        if (repository == null) {
            repository = new tableRepository();
        }
        return repository;
    }


    public Table create(Table table) {
        boolean success = tableDB.add(table);
        if (!success)
            return null;
        return table;
    }


    public Table read(Integer tblNum) {
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


    public boolean delete(Integer tblNum) {
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
