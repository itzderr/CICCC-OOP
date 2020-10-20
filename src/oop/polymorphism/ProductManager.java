package oop.polymorphism;

import java.util.Date;

public class ProductManager extends Employee {
  private String productCode;

  public ProductManager(String employeeId, long salary, Date startDate,
      String productCode) {
    super(employeeId, salary, startDate);
    this.productCode = productCode;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  @Override
  public String toString() {
    return "ProductManager{" +
        "employeeId='" + getEmployeeId() + '\'' +
        ", salary=" + getSalary() +
        ", startDate=" + getStartDate() +
        ", productCode='" + productCode + '\'' +
        '}';
  }
}
