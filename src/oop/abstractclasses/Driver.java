package oop.abstractclasses;

import java.util.ArrayList;
import java.util.Date;

public class Driver {
  public static void main(String[] args) {
    // Object a = new String("hello");
    // dynamic type -> downcast
    // ((String) a).substring(0, 1);

    Employee[] facebook = new Employee[5];
    facebook[0] = new SoftwareDeveloper("swe1", 80_000, new Date(), "Java Backend");
    facebook[1] = new ProductManager("pm1", 75_000, new Date(), "whatsapp123");
    facebook[2] = new Designer("dsg1", 60_000, new Date(), true);
    facebook[3] = new SoftwareDeveloper("swe2", 100_000, new Date(), "Java Backend");
    facebook[4] = new DataScientist("ds1", 70_000, new Date(), "idc84js");

    // ClassCastException: Error!
    // System.out.println(((ProductManager) facebook[0]).getProductCode());

    Employee e1 = facebook[0];
    // down-casting
    System.out.println(((SoftwareDeveloper) e1).getSpecialty());
    SoftwareDeveloper s1 = (SoftwareDeveloper) e1;

    int total = 0;
    for (Employee employee : facebook) {
      total += employee.getSalary();  // polymorphism
    }
    System.out.println(80_000 + 75_000 + 60_000 + 100_000 + 70_000);
    System.out.println(total);


    for (Employee employee : facebook) {
      employee.work();
    }

  }
}
