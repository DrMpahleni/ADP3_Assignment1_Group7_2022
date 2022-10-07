/*
    Waiter.java
    entity for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 07 August 2022
 */
package za.ac.cput.domain.role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Waiter implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int waiterId;
    private int positionId;

    public Waiter(){}
    public Waiter(Builder builder){
        this.positionId = builder.positionId;
        if(builder.waiterId != 0){
            this.waiterId = builder.waiterId;
        }
    }

    public int getWaiterId() {
        return waiterId;
    }

    public int getPositionId() {
        return positionId;
    }

    public static class Builder {
        private int waiterId, positionId;

        public Builder setPositionId(int positionId){
            this.positionId = positionId;
            return this;
        }

        public Builder copy(Waiter waiter){
            this.waiterId = waiter.waiterId;
            this.positionId = waiter.positionId;
            return this;
        }

        public Waiter build(){
            return new Waiter(this);
        }
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "waiterId=" + waiterId +
                ", positionId=" + positionId +
                '}';
    }
}
