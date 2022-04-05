package za.ac.cput.util;

import java.util.UUID;

public class genericHelper {

    public static String generateId() {

        return UUID.randomUUID().toString();
    }
}
