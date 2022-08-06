/*
    Restaurant.java
    entity for Restaurant
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.domain.restaurant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Restaurant")
public class Restaurant implements Serializable {

    @Id
    private String name;
    private String address;
    private int phone;

    public Restaurant() {
    }

    private Restaurant (Builder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    public static class Builder {
        private String name, address;
        private int phone;

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;

            return this;
        }

        public Builder setPhone(int phone) {
            this.phone = phone;

            return this;
        }

        public Restaurant build () {
            return new Restaurant(this);
        }

        public Builder copy (Restaurant restaurant) {
            this.name = restaurant.name;
            this.address = restaurant.address;
            this.phone = restaurant.phone;

            return this;
        }
    }
}
