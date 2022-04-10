/*
    Waiter.java
    entity for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */
package za.ac.cput.entity;

public class Waiter {
     private int waiterId;
     private int positionId;

     private Waiter(Builder builder){
         this.waiterId = builder.waiterId;
         this.positionId = builder.positionId;
     }

     public static class Builder{
         private int waiterId;
         private int positionId;

         public Builder setWaiterId(int waiterId){
             this.waiterId = waiterId;
             return this;
         }

         public Builder setPositionId (int positionId){
             this.positionId = positionId;
             return this;
         }
         public Waiter build(){
             return new Waiter(this);
         }
     }

     public int getWaiterId(){
         return this.waiterId;
     }
     public int getPositionId(){
         return this.positionId;
     }
     @Override
    public String toString(){
         String data = "";
         data += "{WaiterId:"+waiterId+",";
         data += "{PositionId:"+positionId+",";
         return data;
     }



}
