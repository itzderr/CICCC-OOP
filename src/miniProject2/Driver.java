package miniProject2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static ArrayList<Contact> contactList = new ArrayList<>();
    public static void main(String[] args) {

        // default contact list
        Contact c1 = new Contact(0, "Derrick Park", "123-456-7890", "", "", "Vancouver");
        Contact c2 = new Contact(1, "Miranda Kerr", "098-123-1431", "", "123-123-1234", "LA");
        contactList.add(c1);
        contactList.add(c2);
        ContactList.setContactList(contactList);
        System.out.println(contactList);
        ContactList.displayContacts();
        System.out.println(ContactList.getContactList().size());
        System.out.println(ContactList.getContactList().get(0));
        System.out.println(ContactList.getContactList().get(1));

        //while true
        while (true) {
                System.out.print("+==== Contact  App ====+\n" +
                        "| 1. List all Contacts |\n" +
                        "| 2. Add new Contact   |\n" +
                        "| 3. Remove Contacts   |\n" +
                        "| 4. Update Contacts   |\n" +
                        "| 5. Quit              |\n" +
                        "+======================+\n" +
                        "Enter your option: ");

                int optionInput = InputCollector.getUserIntInput("Enter your option");
                if (String.valueOf(optionInput).length() == 1) {
                    switch (optionInput) {
                        case 1:
                            ContactList.displayContacts();
                            break;

                        case 2:
                            Contact newContact = new Contact();
                            newContact.setIndex(ContactList.getContactList().size());   // set index
                            System.out.println(newContact.getIndex());                  //新しいindex確認

                            System.out.println("Enter name: ");
                            String n = InputCollector.getUserInput("Enter name");
                            while (n == "") {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter name: ");
                                n = InputCollector.getUserInput("Enter name");
                            }
                            newContact.setName(n);

                            System.out.println("Enter mobile: ");
                            String m = InputCollector.getUserInput("Enter mobile: ");
                            while (m == "") {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter mobile: ");
                                m = InputCollector.getUserInput(("Enter mobile:"));
                            }
                            newContact.setMobile(m);

                            System.out.println("Enter work: ");
                            newContact.setWork(InputCollector.getUserInput("Enter work:"));
                            System.out.println("Enter home: ");
                            newContact.setHome(InputCollector.getUserInput("Enter home:"));
                            System.out.println("Enter city: ");
                            newContact.setCity(InputCollector.getUserInput("Enter city: "));

                            contactList.add(newContact);             //　Arrayに追加
                            ContactList.setContactList(contactList);     //
                            ContactList.displayContacts();
                            System.out.println("Successfully added a new contact");
                            break;

                        case 3:
                            ContactList.displayContacts();

                            System.out.println("Enter index to be removed: ");
                            int option = InputCollector.getUserIntInput("Enter index: ");
                            String temp = ContactList.getContactList().get(option).getName();
                            while (option >= ContactList.getContactList().size()) {
                                System.out.println("invalid input");
                                System.out.println("Enter index to be removed: ");
                                option = InputCollector.getUserIntInput("Enter index: ");
                            }
                            ContactList.removeElement(option);
                            ContactList.displayContacts();
                            System.out.printf("Successfully removed " + temp);
                            System.out.println();
                            break;

                        case 4:
                            ContactList.displayContacts();
                            System.out.println("Enter index to be updated: ");
                            int toBeUpdated = InputCollector.getUserIntInput("Enter index: ");
                            while (toBeUpdated >= ContactList.getContactList().size()) {
                                System.out.println("invalid input");
                                System.out.println("Enter index to be removed: ");
                                toBeUpdated = InputCollector.getUserIntInput("Enter index: ");
                            }
                            ContactList.getContactList().get(toBeUpdated); // updateするコンタクト

                            System.out.println("Enter name: ");
                            String nn = InputCollector.getUserInput("Enter name");
                            while (nn == "") {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter name: ");
                                nn = InputCollector.getUserInput("Enter name");
                            }
                            ContactList.getContactList().get(toBeUpdated).setName(nn);

                            System.out.println("Enter mobile: ");
                            String mm = InputCollector.getUserInput("Enter mobile: ");
                            while (mm == "") {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter mobile: ");
                                mm = InputCollector.getUserInput(("Enter mobile:"));
                            }
                            ContactList.getContactList().get(toBeUpdated).setMobile(mm);

                            System.out.println("Enter work: ");
                            ContactList.getContactList().get(toBeUpdated).setWork(InputCollector.getUserInput("Enter work:"));
                            System.out.println("Enter home: ");
                            ContactList.getContactList().get(toBeUpdated).setHome(InputCollector.getUserInput("Enter home:"));
                            System.out.println("Enter city: ");
                            ContactList.getContactList().get(toBeUpdated).setCity(InputCollector.getUserInput("Enter city: "));

                            ContactList.setContactList(contactList);
                            ContactList.displayContacts();


                            System.out.println("Successfully updated");
                            break;

                        case 5:
                            System.exit(0);
                    }
            }
        }
    }
}














