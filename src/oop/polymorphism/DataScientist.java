package oop.polymorphism;


import java.util.Date;

public class DataScientist extends Employee {
    // data field
    private String databaseCode;

    public DataScientist(String employeeId, long salary, Date startDate,
         String databaseCode) {
        // constructor from superclass
        super(employeeId,salary, startDate);
        this.databaseCode = databaseCode;
    }

    // getter
    public String getDatabaseCode(){
        return databaseCode;
    }
    // setter
    public void setDatabaseCode(String databaseCode){
        this.databaseCode = databaseCode;
    }

    public String toString(){
        return "DataScientist{" +
                "employeeId=" + getEmployeeId() + '\'' +
                ", salary=" + getSalary() +
                ", startDate=" + getStartDate() +
                ", databaseCode='" + databaseCode + '\'' +
                '}';

    }
}


