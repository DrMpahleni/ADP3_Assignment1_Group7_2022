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
    private String streetAddress;
    private String suburb;
    private String city;
    private String province;
    private int zipCode;
    private int phone;

    public Restaurant() {
    }

    private Restaurant (Builder builder){
        this.name = builder.name;
        this.streetAddress = builder.streetAddress;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;
        this.phone = builder.phone;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode=" + zipCode +
                ", phone=" + phone +
                '}';
    }

    public static class Builder {
        private String name, streetAddress, suburb, city, province;
        private int zipCode, phone;

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;

            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;

            return this;
        }

        public Builder setCity(String city) {
            this.city = city;

            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;

            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;

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
            this.streetAddress = restaurant.streetAddress;
            this.suburb = restaurant.suburb;
            this.city = restaurant.city;
            this.province = restaurant.province;
            this.zipCode = restaurant.zipCode;
            this.phone = restaurant.phone;

            return this;
        }
    }
}
