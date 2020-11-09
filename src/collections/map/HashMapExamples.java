package collections.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExamples {
  public static void main(String[] args) {
    HashMap<String, String> acronyms = new HashMap<>();
    acronyms.put("Lol", "Laughing out loud");
    acronyms.put("Yolo", "You only live once");
    acronyms.put("Smh", "Shake my head😑");
    acronyms.put("Lmk", "Let me know");
    acronyms.put("Brb", "Be right back");
    acronyms.put("LGTM", "Looks good to me");
    acronyms.put("wtf", "What the f");
    acronyms.put("jk", "Just kidding");
    acronyms.put("www", "Laughing in Japanese");
    acronyms.put("kkk", "kaka");

    System.out.println(acronyms);

    // get O(1)
    System.out.println(acronyms.get("www"));

    // remove O(1)
    acronyms.remove("wtf");
    System.out.println(acronyms);

    System.out.println(acronyms.containsKey("kkk"));

    // values
    for (String value : acronyms.values()) {
      System.out.println(value);
    }

    // keys
    for (String key : acronyms.keySet()) {
      System.out.println(key);
    }

    // entry (key, value)
    for (Entry<String, String> entry : acronyms.entrySet()) {
      System.out.println(acronyms.get(entry.getKey()));
      System.out.println(entry.getValue());
    }

    // size
    System.out.println(acronyms.size());

    HashMap<Person, String> countries = new HashMap<>();
    Person p1 = new Person("1934129","Derrick", new Date());
    countries.put(p1, "Brazil");
  }
}
