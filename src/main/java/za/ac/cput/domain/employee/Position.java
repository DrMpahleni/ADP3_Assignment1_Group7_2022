/*
    Position.java
    entity for Position
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 20 August 2022
 */
package za.ac.cput.domain.employee;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Position implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int positionId;
    private String positionName;
    private String positionDescription;
    private int jobId;

    public Position() {}
    private Position(Builder builder){
        this.positionName = builder.positionName;
        this.positionDescription = builder.positionDescription;
        this.jobId = builder.jobId;
        if(builder.positionId != 0){
            this.positionId = builder.positionId;
        }
    }

    public int getPositionId() {
        return positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public int getJobId() {
        return jobId;
    }

    public static class Builder {
        private int positionId, jobId;
        private String positionName, positionDescription;

        public Builder setPositionName(String positionName){
            this.positionName = positionName;
            return this;
        }

        public Builder setPositionDescription(String positionDescription){
            this.positionDescription = positionDescription;
            return this;
        }

        public Builder setJobId(int jobId){
            this.jobId = jobId;
            return this;
        }

        public Builder copy(Position position){
            this.positionId = position.positionId;
            this.positionName = position.positionName;
            this.positionDescription = position.positionDescription;
            this.jobId = position.jobId;
            return this;
        }

        public Position build(){
            return new Position(this);
        }

    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", positionDescription='" + positionDescription + '\'' +
                ", jobId=" + jobId +
                '}';
    }
}
