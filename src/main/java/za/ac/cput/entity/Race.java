package za.ac.cput.entity;
/*Race.java
Entity for Race
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/
public class Race {

        private int id;
        private String name;

        private Race(Builder builder) {
            this.id = builder.id;
            this.name = builder.name;

        }

    public Race(Race race) {
    }

    @Override
        public String toString() {
            return "Race{" +
                    "id" + id +
                    "name" + name +
                    '}';
        }
            public int getId(){
                return id;

        }
        public String getName(){
            return name;
        }

        public static class Builder{
            private int id;
            private String name;
        }
        public Race setId(int id) {
            this.id = id;

            return this;
        }
        public Race setName(String name) {
            this.name = name;

            return this;
        }
        public Race build(){
            return new Race(this);
        }
        public Race copy(Race race) {
            this.id = race.id;
            this.name = race.name;

            return this;

        }
    }

