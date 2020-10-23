package oop.polymorphism;

import java.util.Date;

public class ProductManager extends Employee{
    // data field
    private String productCode;

    // constructor
    public ProductManager(String employeeId, long salary, Date startDate,
          String productCode){
        // constructor from superclass
        super(employeeId, salary, startDate);
        this.productCode = productCode;
    }

    // getter
    public String getProductCode(){
        return productCode;
    }

    // setter
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }

    @Override
    public String toString(){
        return "ProductManager{" +
                "employeeId='" + getEmployeeId() + '\'' +
                ", salary=" + getSalary() +
                ", startDate=" + getStartDate() +
                "productCode='" + productCode + '\'' +
                '}';
    }
}
