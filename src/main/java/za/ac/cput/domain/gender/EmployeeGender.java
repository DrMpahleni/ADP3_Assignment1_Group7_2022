package za.ac.cput.domain.gender;

import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.domain.contact.EmployeeContact;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/* EmployeeGender.java
 This is a Employee Gender Entity
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
@Entity
@Table(name = "Employee")
public class EmployeeGender implements Serializable {
    @Id
private String employeeId, genderId;
    public EmployeeGender() {

    }
    private EmployeeGender (Builder builder){
        this.employeeId = builder.employeeId;
        this.genderId = builder.genderId;
    }
    public String getEmployeeId() {
        return employeeId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeId=" + employeeId +
                ", genderId=" + genderId +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass())return false;
        EmployeeGender employeeGender = (EmployeeGender) o;
        return genderId.equals(employeeGender.genderId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, genderId);
    }
    public static class Builder{
        private String employeeId, genderId;

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setGenderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder copy(EmployeeGender employeeGender){
            this.employeeId = employeeGender.employeeId;
            this.genderId = employeeGender.genderId;
            return this;
        }
        public EmployeeGender build(){
            return new EmployeeGender(this);
        }
    }
}
