package za.ac.cput.domain.contact;

import za.ac.cput.domain.gender.Gender;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/* EmployeeContact.java
 This is an Employee Contact Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
@Entity
@Table(name = "EmployeeContact")
public class EmployeeContact implements Serializable {
    @Id
    private String employeeId, contactTypeId, contact;
public EmployeeContact(){

}
    private EmployeeContact (Builder builder){
    this.employeeId = builder.employeedId;
    this.contactTypeId = builder.contactTypeId;
    this.contact = builder.contact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "employeeID=" + employeeId +
                ", contactTypeID=" + contactTypeId +
                ", contact='" + contact + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass())return false;
        EmployeeContact employeeContact = (EmployeeContact) o;
        return contactTypeId.equals(employeeContact.contactTypeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, contactTypeId,contact);
    }
    public static class Builder{
        private String employeedId;
        private String contactTypeId;
        private String contact;


        public Builder setEmployeeID(String employeeId){
            this.employeedId = employeeId;
            return this;
        }

        public Builder setContactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(EmployeeContact employeeContact){
            this.employeedId = employeeContact.employeeId;
            this.contactTypeId = employeeContact.getContactTypeId();
            this.contact = employeeContact.contact;
            return this;
        }
        public EmployeeContact build(){
            return new EmployeeContact(this);
        }

    }

}
