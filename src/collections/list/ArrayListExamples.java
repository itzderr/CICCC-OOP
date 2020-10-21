package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExamples {
  public static void main(String[] args) {
    // 1. creating an empty ArrayList of Strings
    // <type> : generic for stronger typing system (static)
    ArrayList<String> cities = new ArrayList<>();
    cities.add("Vancouver");
    cities.add("Toronto");
    cities.add("Calgary");
    cities.add("Montreal");
    cities.add("Edmonton");
    cities.add("Victoria");

    // 2. get the number of elements
    System.out.println(cities.size());

    // 3. print the arraylist
    System.out.println(cities);

    // 4. insert at index 0
    cities.add(0, "Burnaby");
    System.out.println(cities);

    // 5. get(i): returns the element at index i
    //      e.g) For arrays, array[i]
    System.out.println(cities.get(1));

    // 6. set(i, obj): set the object at index i to obj
    cities.set(0, "Paris");
    System.out.println(cities);

    // 7. remove(i): remove the element at index i
    //    remove(obj): remove the obj (the first occurrence)
    cities.remove(0);
    cities.remove("Montreal");
    System.out.println(cities);

    // 8. indexOf(obj): returns the index of obj in the list
    //    contains(obj)
    System.out.println(cities.indexOf("Vancouver"));
    System.out.println(cities.contains("Vancouver"));

    // 9. clear(): remove all elements
    cities.clear();
    System.out.println(cities);

    // 10. creating an arraylist with elements
    List<String> usa = Arrays.asList("New York", "Seattle", "LA", "SF", "Boston");
    ArrayList<String> citiesUSA = new ArrayList<>(usa);
    System.out.println(citiesUSA);
    System.out.println(citiesUSA.get(citiesUSA.size() - 1));

    // declaration
    ArrayList<String> friends;
    // initialization
    friends = new ArrayList<>();

    ArrayList<Integer> a = new ArrayList();
    a.add(1);  // primitive?

    // Wrapper classes for primitive types
    Integer j = new Integer(10);
    Integer k = 10; // auto-boxing
    int l = k;  // auto-unboxing
    Double d;
    Boolean b;

    /* before java 1.2
    ArrayList countries = new ArrayList();
    countries.add("Canada");
    countries.add("USA");
    countries.add("Mexico");
    countries.add(1);
    countries.add(20);
    countries.add(3.14);

    for (int i = 0; i < countries.size(); i++) {
      String country = (String) countries.get(i);
      System.out.println(country.charAt(0));
    }
    */
  }
}
