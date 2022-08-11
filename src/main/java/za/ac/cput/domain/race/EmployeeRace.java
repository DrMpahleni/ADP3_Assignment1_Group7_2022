package za.ac.cput.domain.race;

/* EmployeeRace.java
   This is Employee Race domain class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EmployeeRace")
public class EmployeeRace implements Serializable {

    @Id
    private int raceId;
    private String raceName;

    public EmployeeRace() {}

    private EmployeeRace(Builder builder) {
        this.raceId = builder.raceId;
        this.raceName = builder.raceName;
    }

    public int getRaceId() {
        return raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    @Override
    public String toString() {
        return "EmployeeRace{" +
                "raceId=" + raceId +
                ", raceName='" + raceName + '\'' +
                '}';
    }
    public static class Builder {
        private int raceId;
        private String raceName;

        public Builder setRaceId(int raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder setRaceName(String raceName) {
            this.raceName = raceName;
            return this;
        }
        public EmployeeRace build() {
            return new EmployeeRace(this);
        }
        public Builder copy(EmployeeRace employeeRace) {
            this.raceId = raceId;
            this.raceName = raceName;

            return this;
        }
    }

}
