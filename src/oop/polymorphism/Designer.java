package oop.polymorphism;

import java.util.Date;

public class Designer extends Employee {
  private boolean hasUXSkills;

  public Designer(String employeeId, long salary, Date startDate, boolean hasUXSkills) {
    super(employeeId, salary, startDate);
    this.hasUXSkills = hasUXSkills;
  }

  public boolean isHasUXSkills() {
    return hasUXSkills;
  }

  public void setHasUXSkills(boolean hasUXSkills) {
    this.hasUXSkills = hasUXSkills;
  }

  @Override
  public long getSalary() {
    return hasUXSkills ? super.getSalary() + 3000 : super.getSalary();
  }

  @Override
  public String toString() {
    return "Designer{" +
        "employeeId='" + getEmployeeId() + '\'' +
        ", salary=" + getSalary() +
        ", startDate=" + getStartDate() +
        ", hasUXSkills=" + hasUXSkills +
        '}';
  }
}
