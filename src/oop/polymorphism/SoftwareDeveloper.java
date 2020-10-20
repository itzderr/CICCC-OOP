package oop.polymorphism;

import java.util.Date;

public class SoftwareDeveloper extends Employee {
  private String specialty;
  private static final double BONUS_RATE = 0.5;

  public SoftwareDeveloper(String employeeId, long salary, Date startDate,
      String specialty) {
    super(employeeId, salary, startDate);
    this.specialty = specialty;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  @Override
  public long getSalary() {
    return super.getSalary() + Math.round(super.getSalary() * BONUS_RATE);
  }

  @Override
  public String toString() {
    // returns the string representation of Employee
    return "SoftwareDeveloper{" +
        "employeeId='" + super.getEmployeeId() + '\'' +
        ", salary=" + this.getSalary() +
        ", startDate=" + super.getStartDate() +
        ", specialty=" + this.specialty +
        '}';
  }
}
