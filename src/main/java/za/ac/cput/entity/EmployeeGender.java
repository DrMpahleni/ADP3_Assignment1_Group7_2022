package za.ac.cput.entity;

public class EmployeeGender {
    this.employeeId = builder.employeeId;
    this.genderId = builder.genderId;
}

    public String getEmployeeId() {
        return employeeId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeId=" + employeeId +
                ", genderId=" + genderId +
                '}';
    }
public static class Builder{
    private String employeeId, genderId;

    public Builder setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Builder setGenderId(String genderId) {
        this.genderId = genderId;
        return this;
    }
    public EmployeeGender build(){
        return new EmployeeGender(this);
    }
    private Builder copy(EmployeeGender employeeGender){
        this.employeeId = employeeGender.employeeId;
        this.genderId = employeeGender.genderId;
        return this;
    }
}
}
