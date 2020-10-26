import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RandomPicker {

  private static final int MAX = 8;
  private static int DAYS = 18;
  private static ArrayList<String> studentList = new ArrayList<>(Arrays.asList(
      "Shintaro", "Nico", "Kideok", "Miriam", "Yumi", "Adriano",
      "Takayuki", "Takayasu", "Danilo", "Kazu"
  ));

  // Takayasu on Friday
  public static void main(String[] args) {
    int availableSlots = MAX * DAYS;
    int numOfStudents = studentList.size();
    int maxFrequency = availableSlots / numOfStudents + 1;

    HashMap<String, Integer> freqTable = new HashMap<>();
    for (String student : studentList) {
      freqTable.put(student, 0);
    }

    while (DAYS --> 0) {
      ArrayList<String> students = new ArrayList<>();
      while (students.size() < MAX) {
        String selectedStudent = studentList.get((int) (Math.random() * studentList.size()));
        while (freqTable.get(selectedStudent) >= maxFrequency || students.contains(selectedStudent)) {
          int i = (int) (Math.random() * studentList.size());
          selectedStudent = studentList.get(i);
        }
        students.add(selectedStudent);
        freqTable.put(selectedStudent, freqTable.get(selectedStudent) + 1);
        // clean up the student list if student already reached the max
        if (freqTable.get(selectedStudent) == maxFrequency) {
          studentList.remove(selectedStudent);
        }
      }
      System.out.println();
      System.out.println(studentList);
      System.out.println(freqTable);
      System.out.println();
      for(String student : students) {
        System.out.println(student);
      }
      System.out.println();
      System.out.println();
    }
  }
}

