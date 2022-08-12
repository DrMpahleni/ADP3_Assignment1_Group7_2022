package za.ac.cput.repository.table;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.factory.restaurant.TableFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class tableRepositoryTest {

    private static TableRepository repository = TableRepository.getRepository();
    private static Table table = TableFactory.createTable(13, 2);

    @Test
    void create() {
        Table created = repository.create(table);
        assertEquals(table.getTblNum(),created.getTblNum());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Table read = repository.read(table.getTblNum());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Table updated = new Table.Builder().copy(table).setTblNum(3).build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(table.getTblNum());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}
