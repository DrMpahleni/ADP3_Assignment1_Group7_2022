package za.ac.cput.entity;

public class Gender {
    private String Id;
    private String name;

    private Gender(){

    }
 private Gender (Builder builder){
        this.Id = builder.Id;
        this.name = builder.name;
 }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
    public static class Builder{
        private String Id;
        private String name;

        public Builder setId(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Gender build(){
            return new Gender(this);
        }
        public Builder copy(Gender gender){
            this.Id = gender.Id;
            this.name = gender.name;
            return this;
        }
    }
}
