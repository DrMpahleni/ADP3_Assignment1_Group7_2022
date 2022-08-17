/*
Reservation.java
This is the reservation entity class
Author: Felecia Zweni(218330189)
Date: 10 April 2022
 */

package za.ac.cput.domain.restaurant;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Reservation")

public class Reservation implements Serializable {

    @Id
    private String name;
    private int amount;
    private String date;

    public Reservation(){

    }

    private Reservation(Reservation.Builder builder){

        this.name = builder.name;
        this.amount = builder.amount;
        this.date = builder.date;


    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Reservation{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public static class Builder{

        private String name;
        private int amount;
        private String date;

        public Reservation.Builder setName(String name){
            this.name = name;
            return this;
        }

        public Reservation.Builder setAmount(int amount){
            this.amount = amount;
            return this;
        }

        public Reservation.Builder setDate(String date){
            this.date = date;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }

        public Reservation.Builder copy(Reservation reservation) {
            this.name= reservation.name;
            this.amount = reservation.amount;
            this.date = reservation.date;

            return this;
        }
    }
}
