/*
    Chef.java
    entity for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.entity;

public class Chef {

private int chefId;
private int positionId;

private Chef (Builder builder){
    this.chefId = builder.chefId;
    this.positionId = builder.postionId;
}

    public int getPositionId() {
    return this.positionId;
    }
    public int getChefId(){
    return this.chefId;
    }

    public static class Builder{
    private int chefId;
    private int postionId;

    public Builder setChefId(int chefId){
        this.chefId = chefId;
        return this;
    }
    public Builder setPositionId(int positionId){
        this.postionId = positionId;
        return this;
    }
    public Chef build()
    {
        return new Chef(this);
    }

    public Chef.Builder copy (Chef chef) {
        this.chefId = chef.chefId;
        this.postionId =chef.positionId;
        return this;
}

    @Override
    public String toString(){
    String data = "";
    data += "{ChefId: "+chefId+",";
    data += "{PositionId:"+postionId+",";
    return data;
    }
}}
