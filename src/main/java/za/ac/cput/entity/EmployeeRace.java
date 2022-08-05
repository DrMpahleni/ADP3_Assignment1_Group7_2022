package za.ac.cput.entity;

/*EmployeeRace.java
Entity for EmployeeRace
@author Lihle Njobe 218193882
Due date: 10 April 2022
 */

public class EmployeeRace {
    private String raceId;
    private String raceName;

    private EmployeeRace(Builder builder) {
        this.raceId = builder.raceId;
        this.raceName = builder.raceName;

    }

    public String getRaceId() {
        return raceId;

    }

    public String getRaceName() {

        return raceName;
    }

    @Override
    public String toString() {
        return "EmployeeRace{" +
                " Race Id " + raceId + '\'' +
                "Race Name " + raceName + '\'' +
                '}';
    }

    public static class Builder {
        private String raceId;
        private String raceName;

        public Builder setRaceId(String raceID) {
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
            this.raceId = employeeRace.raceId;
            this.raceName = employeeRace.raceName;

            return this;

        }
    }
}
