package za.ac.cput.factory;

import za.ac.cput.entity.Gender;
import za.ac.cput.util.genericHelper;

public class GenderFactory {
    public static Gender createGender(String Id, String name){
        String ID = genericHelper.generateId();
        Gender gender = new Gender.Builder().setId(Id)
                .setName(name)
                .build();
        return gender;
    }
}
