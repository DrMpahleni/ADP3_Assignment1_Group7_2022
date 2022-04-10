/*
    Position.java
    entity for Position
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.entity;

public class Position {

    private int positionId;
    private int jobId;
    private String positionName;
    private String positionDescription;

    private Position (Builder builder){
        this.positionId = builder.positionId;
        this.jobId = builder.jobId;
        this.positionName = builder.positionName;
        this.positionDescription = builder.positionDescription;
    }

    public int getPositionId() {
        return this.positionId;
    }
    public int getJobId(){
        return this.jobId;
    }
    public String getPositionName(){
        return this.positionName;
    }
    public String getPositionDescription(){
        return this.positionDescription;
    }

    public int positionId() {
        return positionId;
    }

    public static class Builder{
        private int positionId;
        private int jobId;
        private String positionName;
        private String positionDescription;

        public Builder setPositionId(int positionId){
            this.positionId=positionId;
            return this;
        }
        public Builder setJobId (int jobId){
            this.jobId = jobId;
            return this;
        }
        public Builder setPositionName (String positionName){
            this.positionName = positionName;
            return this;
        }
        public Builder setPositionDescription(String positionDescription){
            this.positionDescription = positionDescription;
            return this;
        }
        public Position build(){
            return new Position(this);
        }
        public Builder copy (Position position) {
            this.positionId = position.positionId;
            this.jobId =position.jobId;
            this.positionName = position.positionName;
            this.positionDescription = position.positionDescription;
            return this;
    }
    @Override
    public String toString(){
        String data = "";
        data +="{PositionId:" +positionId+",";
            data += "{jobId:" +jobId+",";
        data += "{positionName:" +positionName+",";
        data += "{positionDescription:" +positionDescription+",";
        return data;

    }
}}

