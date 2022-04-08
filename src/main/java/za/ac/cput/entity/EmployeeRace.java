package za.ac.cput.entity;

/*EmployeeRace.java
Entity for EmployeeRace
@author Lihle Njobe 218193882
Due date: 10 April 2022
 */

public class EmployeeRace {
    private int raceId;
    private String raceName;

    private EmployeeRace(Builder builder) {
        this.raceId = builder.raceId;
        this.raceName = builder.raceName;

    }

    public EmployeeRace(EmployeeRace employeeRace) {
    }

    @Override
    public String toString() {
    return "EmployeeRace{" +
            "raceId" + raceId +
            "raceName" + raceName +
            '}';
 }
    public int getRaceId(){
        return raceId;

    }
    public String getRaceName(){
        return raceName;
    }
  public static class Builder{
      private int raceId;
      private String raceName;
  }
  public EmployeeRace setRaceId(int raceId) {
        this.raceId = raceId;

        return this;
  }
  public EmployeeRace setRaceName(String raceName) {
        this.raceName = raceName;

                return this;
  }
  public EmployeeRace build() {
        return new EmployeeRace(this);
  }
  public EmployeeRace copy(EmployeeRace employeeRace) {
      this.raceId = employeeRace.raceId;
      this.raceName = employeeRace.raceName;

      return this;

  }
}
