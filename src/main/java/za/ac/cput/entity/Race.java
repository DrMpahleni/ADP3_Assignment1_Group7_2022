package za.ac.cput.entity;
/*Race.java
Entity for Race
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/
public class Race {
    private String id;
    private String name;

    private Race(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;

    }

    public String getId() {
        return id;

    }

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return "Race{" +
                ", id" + id +
                ", name =" + name +
                '}';
    }


    public static class Builder {
        private String id;
        private String name;

        public Builder setId(String id) {
            this.id = id;

            return this;

        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Race build() {

            return new Race(this);
        }

        public Builder copy(Race race) {
            this.id = race.id;
            this.name = race.name;

            return this;

        }
    }
}
