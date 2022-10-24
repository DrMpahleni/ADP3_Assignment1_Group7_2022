package za.ac.cput.domain.contact;

import za.ac.cput.domain.gender.Gender;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/* ContactType.java
 This is a Contact Type Entity
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
@Entity
@Table(name = "Employee")
public class ContactType implements Serializable {
    @Id
private String id, name;

    public ContactType(){

    }
    private ContactType (Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass())return false;
        ContactType contactType = (ContactType)o;
        return id.equals(contactType.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }
    public static class Builder{
        private String id;
        private String name;


        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder copy(ContactType contactType){
            this.id = contactType.id;
            this.name = contactType.name;
            return this;
        }
        public ContactType build(){
            return new ContactType(this);
        }

    }

}
