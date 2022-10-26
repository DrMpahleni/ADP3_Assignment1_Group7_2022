package za.ac.cput.domain.gender;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/* Gender.java
 This is a Gender Entity
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
@Entity
@Table(name = "Gender")
public class Gender implements Serializable {
    @Id
    private String Id, name;
public Gender() {

}
    private Gender (Builder builder){
        this.Id = builder.Id;
        this.name = builder.name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass())return false;
        Gender gender = (Gender)o;
        return Id.equals(gender.Id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(Id, name);
    }

    public static class Builder{
        private String Id;
        private String name;

        public Builder setId(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder copy(Gender gender){
            this.Id = gender.Id;
            this.name = gender.name;
            return this;
        }
        public Gender build(){
            return new Gender(this);
        }
    }
}
