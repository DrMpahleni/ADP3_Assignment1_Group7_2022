package za.ac.cput.entity;

public class EmployeeContact {
    private String  employeeId;
    private int contactTypeId;
    private String contact;

    public EmployeeContact(){

    }
    private EmployeeContact (Builder builder){
        this.employeeId = builder.employeedId;
        this.contactTypeId = builder.contactTypeId;
        this.contact = builder.contact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getContactTypeId() {
        return contactTypeId;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "employeeID=" + employeeId +
                ", contactTypeID=" + contactTypeId +
                ", contact='" + contact + '\'' +
                '}';
    }
    public static class Builder{
        private String employeedId;
        private int contactTypeId;
        private String contact;


        public Builder setEmployeeID(String employeeId){
            this.employeedId = employeeId;
            return this;
        }

        public Builder setContactTypeId(int contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public EmployeeContact build(){
            return new EmployeeContact(this);
        }

        public Builder copy(EmployeeContact employeeContact){
            this.employeedId = employeeContact.employeeId;
            this.contactTypeId = employeeContact.contactTypeId;
            this.contact = employeeContact.contact;
            return this;
        }

    }

}
