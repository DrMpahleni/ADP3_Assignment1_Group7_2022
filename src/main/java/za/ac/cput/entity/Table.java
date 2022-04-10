/*
Table.java
This is the Table entity class
Author: Felecia Zweni(218330189)
Date: 10 April 2022
 */

package za.ac.cput.entity;

public class Table {
    private int tblNum;
    private int seatAmount;

    public Table(){

    }

    private Table(Builder builder){

        this.tblNum = builder.tblNum;
        this.seatAmount = builder.seatAmount;

    }

    public String getTblNum() {
        return tblNum;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setTblNum(int tblNum) {
        this.tblNum = tblNum;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Table{" +
                "tblNum=" + tblNum +
                ", seatAmount=" + seatAmount +
                '}';
    }

    public static class Builder{

        private int tblNum;
        private int seatAmount;

        public Table.Builder setTblNum(int tblNum){
            this.tblNum = tblNum;
            return this;
        }

        public Table.Builder setSeatAmount(int seatAmount){
            this.seatAmount = seatAmount;
            return this;
        }

        public Table build(){
            return new Table(this);
        }

        public Table.Builder copy(Table table){
            this.tblNum = table.tblNum;
            this.seatAmount = table.seatAmount;
            return this;
        }
    }
}
