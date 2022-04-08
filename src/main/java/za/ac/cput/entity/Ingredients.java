package za.ac.cput.entity;
/*Ingredients.java
Entity for Ingredients
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/
public class Ingredients {

    private String ingredientName;
    private String ingredientType;
    private int amount;


    private Ingredients(Builder builder) {
        this.ingredientName = builder.ingredientName;
        this.ingredientType = builder.ingredientType;
        this.amount = builder. amount;
}

    public Ingredients(Ingredients ingredients) {
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientName" + ingredientName +
                "ingredientType" + ingredientType +
                "amount" + amount +
                '}';
    }
    public String getIngredientName(){
        return ingredientName;

    }
    public String getIngredientType(){
        return ingredientType;
    }
 public int getAmount() {
        return amount;
    }
    public static class Builder{
        private String ingredientName;
        private String ingredientType;
        private int amount;
}

    public Ingredients setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;

        return this;
    }
    public Ingredients setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;

        return this;
    }
    public Ingredients setAmount(int amount) {
        this.amount = amount;

        return this;
    }
    public Ingredients build() {
        return new Ingredients(this);
    }
    public Ingredients copy(Ingredients ingredients) {
        this.ingredientName = ingredients.ingredientName;
        this.ingredientType = ingredients.ingredientType;
        this.amount = ingredients.amount;

        return this;

    }
}