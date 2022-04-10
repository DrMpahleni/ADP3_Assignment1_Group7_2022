package za.ac.cput.util;

import java.util.UUID;

public class genericHelper {

    public static String generateId() {

        return UUID.randomUUID().toString();
    }

    //For the following entities: supplier, menu, menuItem & manager
    public static int generatId()
    {
        return UUID.randomUUID().toString().hashCode() & 0xffffff;
    }
}
