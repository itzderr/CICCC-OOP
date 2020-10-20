package lab2;

public class Province {

  // Constants
  private static final long DEFAULT_POPULATION = 4_648_055;
  private static final String DEFAULT_PROVINCE = "British Columbia";
  private static final String DEFAULT_CAPITAL = "Victoria";
  public static final String[] PROVINCES = {
      "Ontario",
      "Quebec",
      "British Columbia",
      "Alberta",
      "Manitoba",
      "Saskatchewan",
      "Nova Scotia",
      "New Brunswick",
      "Newfoundland and Labrador",
      "Prince Edward Island"
  };
  public static final String[] capitals = {
      "Edmonton",
      "Victoria",
      "Winnipeg",
      "Fredericton",
      "St. John's",
      "Halifax",
      "Toronto",
      "Charlottetown",
      "Quebec City",
      "Regina"
  };
  // fields - instance variables
  private String name;
  private String capital;
  private long population;

  // constructor
  public Province(String name, String capital, long population) {
    if (isValidPopulation(population)
        && isValidProvince(name)
        && isValidCapitalCity(capital)) {
      this.name = name;
      this.capital = capital;
      this.population = population;
    } else {
      this.population = DEFAULT_POPULATION; // 4,648,055
      this.name = DEFAULT_PROVINCE; // “British Columbia”
      this.capital = DEFAULT_CAPITAL; // “Victoria”
    }
  }

  // getters & setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }

  // returns string representation of Province object
  @Override
  public String toString() {
    return "The capital of " + name + " (population. " + population + ") is " + capital + ".";
  }

  public String getDetails() {
    return "The capital of " + name + " (population. " + population + ") is " + capital + ".";
  }

  // helper methods
  private boolean isValidProvince(String name) {
    // local array
    for (String province : PROVINCES) {
      if (province.equals(name)) {
        return true;
      }
    }
    return false;
  }

  private boolean isValidCapitalCity(String capital) {
    for (String cap : capitals) {
      if (cap.equals(capital)) {
        return true;
      }
    }
    return false;
  }

  private boolean isValidPopulation(long population) {
    return population >= 30_000 && population <= 15_000_000;
  }
}
