package za.ac.cput.domain.lookup;

/* Ingredients.java
   This is Ingredients domain class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

public class Ingredients {
    private String ingredientName;
    private String ingredientType;
    private int amount;

    public Ingredients() {

    }

    public String getIngredientName() {
        return ingredientName;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public int getAmount() {
        return amount;
    }

    private Ingredients(Builder builder) {
        this.ingredientName = builder.ingredientName;
        this.ingredientType = builder.ingredientType;
        this.amount = builder.amount;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientName='" + ingredientName + '\'' +
                ", ingredientType='" + ingredientType + '\'' +
                ", amount=" + amount +
                '}';
    }
    public static class Builder {
        private String ingredientName;
        private String ingredientType;
        private int amount;


    public Builder setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;

        return this;
    }

    public Builder setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;

        return this;
    }

    public Builder setAmount(int amount) {
        this.amount = amount;

        return this;
    }
    public Ingredients build() {
        return new Ingredients(this);
    }

    public Builder copy(Ingredients ingredients) {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.amount = amount;

        return this;

    }

    }
}
