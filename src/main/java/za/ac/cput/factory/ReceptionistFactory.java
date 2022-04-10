package za.ac.cput.factory;

import za.ac.cput.entity.Receptionist;
import za.ac.cput.util.genericHelper;

public class ReceptionistFactory {
    public static Receptionist createReceptionist(int receptionId, int positionId) {
        String receptionID = genericHelper.generateId();
        Receptionist receptionist = new Receptionist.Builder().setReceptionId(receptionId).setPositionId(positionId).build();
        return receptionist;
    }
}
