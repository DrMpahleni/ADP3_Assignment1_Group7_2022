/*
TableFactory.java
This is table factory class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.util.genericHelper;

public class TableFactory {
    public static Table createTable(String tblNum, int seatAmount){

        String tableID = genericHelper.generateId();
        Table table = new Table.Builder().setTblNum(tblNum).setSeatAmount(seatAmount).build();
        return table;
    }
}
