package za.ac.cput.entity;

public class ConntactType {
    private String Id;
    private String name;

    public ContactType(){

    }
    private ContactType (Builder builder){
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
        return "ContactType{" +
                "ID=" + Id +
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
        public ContactType build(){
            return new ContactType(this);
        }
        public Builder copy(ContactType contactType){
            this.Id = contactType.Id;
            this.name = contactType.name;
            return this;
        }
    }

}
