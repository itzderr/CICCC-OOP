package miniProject2;

/**
 * @yumi
 */

import java.util.ArrayList;

public class Driver {

    public static ArrayList<Contact> contactList = new ArrayList<>();
    public static void main(String[] args) {


        Contact c1 = new Contact(0, "Derrick Park", "123-456-7890", "", "", "Vancouver");
        Contact c2 = new Contact(1, "Miranda Kerr", "098-123-1431", "", "123-123-1234", "LA");
        Contact c3 = new Contact(2, "Lebron James", "123-567-1234","432-123-5432", "","LA");

        ContactList.addContact(c1);
        ContactList.addContact(c2);
        ContactList.addContact(c3);

        while (true) {
            try {
                System.out.print("+==== Contact  App ====+\n" +
                        "| 1. List all Contacts |\n" +
                        "| 2. Add new Contact   |\n" +
                        "| 3. Remove Contacts   |\n" +
                        "| 4. Update Contacts   |\n" +
                        "| 5. Quit              |\n" +
                        "+======================+\n" +
                        "Enter your option: ");

                String optionInput = InputCollector.getUserInput("Enter your option");
                while (optionInput.equals("") || optionInput.equals(" ")){
                    throw new Exception();
                }
                int optionIntInput = Integer.parseInt(optionInput);                    // Convert string to int

                switch (optionIntInput) {

                    case 1:
                        ContactList.displayContacts();
                        break;

                    case 2:
                        while (true) {
                            int tempIndex = ContactList.getContactList().size();
                            System.out.println("Enter name: ");
                            String tempName = InputCollector.getUserInput("Enter name");
                            while (tempName.equals("")) {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter name: ");
                                tempName = InputCollector.getUserInput("Enter name");
                            }
                            while (!Contact.isNameValid(tempName)) {                             // check validity of name
                                System.out.println("You must enter full name with a space.");
                                System.out.println("Enter name: ");
                                tempName = InputCollector.getUserInput("Enter name");
                            }
                            tempName = Contact.nameFormat(tempName);                              // Align name format

                            System.out.println("Enter mobile: ");
                            String tempMobile = InputCollector.getUserInput("Enter mobile: ");
                            while (tempMobile.equals("") || tempMobile.equals(" ")) {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter mobile: ");
                                tempMobile = InputCollector.getUserInput(("Enter mobile:"));
                            }
                            while (!Contact.isValidNumber(tempMobile)) {
                                System.out.println("Please enter a valid phone number using the format: XXX-XXX-XXXX.");
                                System.out.println("Enter mobile: ");
                                tempMobile = InputCollector.getUserInput(("Enter mobile:"));
                            }

                            System.out.println("Enter work: ");
                            String tempWork = InputCollector.getUserInput("Enter work:");
                            System.out.println("Enter home: ");
                            String tempHome = InputCollector.getUserInput("Enter home:");
                            System.out.println("Enter city: ");
                            String tempCity = InputCollector.getUserInput("Enter city:");

                            if (ContactList.isDuplicate(tempName, tempMobile)) {                // check any duplicated contacts
                                break;
                            }
                            Contact newContact = new Contact(tempIndex, tempName, tempMobile, tempWork, tempHome, tempCity);
                            ContactList.addContact(newContact);
                            ContactList.displayContacts();
                            System.out.println("Successfully added a new contact");
                            break;
                        }
                        break;

                    case 3:
                        while (true) {
                            try {
                                ContactList.displayContacts();
                                System.out.println("Enter index to be removed: ");
                                String option = InputCollector.getUserInput("Enter index:");
                                if (option.equals("") || option.equals(" ")) {
                                    throw new Exception();
                                }
                                int indexOption = Integer.parseInt(option);
                                System.out.printf("Are you sure you want to delete " + ContactList.getContactList().get(indexOption) + "?\n" +
                                            "press y to remove, n to go back to menu.");

                                String rep = InputCollector.getUserInput("y/n");
                                String yes = "y";
                                String no = "n";

                                while (true) {
                                    if(rep.equals("") || rep.equals(" ")){
                                        System.out.println("Please enter either y or n.");
                                        rep = InputCollector.getUserInput("y/n");
                                    }
                                    if (rep.equals(yes)) {
                                        String temp = ContactList.getContactList().get(indexOption).getName();
                                        ContactList.removeElement(indexOption);
                                        ContactList.displayContacts();
                                        System.out.printf("Successfully removed " + temp);
                                        System.out.println();
                                        break;
                                    } else if (rep.equals(no)) {
                                        System.out.println("Bye!");
                                        break;
                                    } else {
                                        System.out.println("Please enter either y or n.");
                                        rep = InputCollector.getUserInput("y/n");
                                    }
                                    }
                                break;
                                } catch (Exception e) {
                                    System.out.println("not found, the current Contact list is as below: ");
                                }
                            }
                            break;
                    case 4:

                        while (true) {
                            try {
                                ContactList.displayContacts();
                                System.out.println("Enter index to be updated: ");
                                String toBeUpdated = InputCollector.getUserInput("Enter index:");
                                int indexOption = Integer.parseInt(toBeUpdated);

                                if (toBeUpdated.equals("") || toBeUpdated.equals(" ")) {
                                    throw new Exception();
                                }

                                while (indexOption >= ContactList.getContactList().size() || toBeUpdated.equals("") || toBeUpdated.equals(" ")) {
                                    System.out.println("Contact not found. Please enter a valid index.");
                                    System.out.println("Enter index to be updated: ");
                                    toBeUpdated = InputCollector.getUserInput("Enter index: ");
                                    indexOption = Integer.parseInt(toBeUpdated);
                                    if (indexOption < ContactList.getContactList().size()) {
                                        ContactList.getContactList().get(indexOption);      // get the contact to be updated
                                        System.out.println("Enter name: ");
                                        String tempName = InputCollector.getUserInput("Enter name");
                                        // when nothing is inputted -> keep the old data
                                        while (tempName.equals("")) {
                                            tempName = ContactList.getContactList().get(indexOption).getName();
                                        }
                                        while (!Contact.isNameValid(tempName)) {                             // check validity of name
                                            System.out.println("You must enter full name with a space.");
                                            System.out.println("Enter name: ");
                                            tempName = InputCollector.getUserInput("Enter name");
                                        }
                                        tempName = Contact.nameFormat(tempName);
                                        ContactList.getContactList().get(indexOption).setName(tempName);

                                        System.out.println("Enter mobile: ");
                                        String tempMobile = InputCollector.getUserInput("Enter mobile: ");
                                        if (tempMobile.equals("") || tempMobile.equals(" ")) {
                                            tempMobile = ContactList.getContactList().get(indexOption).getMobile();
                                        }
                                        while (!Contact.isValidNumber(tempMobile)) {
                                            System.out.println("Please enter a valid phone number using the format: XXX-XXX-XXXX.");
                                            System.out.println("Enter mobile: ");
                                            tempMobile = InputCollector.getUserInput(("Enter mobile:"));
                                        }
                                        ContactList.getContactList().get(indexOption).setMobile(tempMobile);

                                        System.out.println("Enter work: ");
                                        ContactList.getContactList().get(indexOption).setWork(InputCollector.getUserInput("Enter work:"));
                                        System.out.println("Enter home: ");
                                        ContactList.getContactList().get(indexOption).setHome(InputCollector.getUserInput("Enter home:"));
                                        System.out.println("Enter city: ");
                                        ContactList.getContactList().get(indexOption).setCity(InputCollector.getUserInput("Enter city: "));
                                        ContactList.displayContacts();
                                        System.out.println("Successfully updated");
                                        break;
                                    }
                                }
                                if (indexOption < ContactList.getContactList().size()) {
                                        ContactList.getContactList().get(indexOption);      // get the contact to be updated
                                        System.out.println("Enter name: ");
                                        String tempName = InputCollector.getUserInput("Enter name");
                                        // when nothing is inputted -> keep the old data
                                        while (tempName.equals("")) {
                                            tempName = ContactList.getContactList().get(indexOption).getName();
                                        }
                                        while (!Contact.isNameValid(tempName)) {                             // check validity of name
                                            System.out.println("You must enter full name with a space.");
                                            System.out.println("Enter name: ");
                                            tempName = InputCollector.getUserInput("Enter name");
                                        }
                                        tempName = Contact.nameFormat(tempName);
                                        ContactList.getContactList().get(indexOption).setName(tempName);

                                        System.out.println("Enter mobile: ");
                                        String tempMobile = InputCollector.getUserInput("Enter mobile: ");
                                        if (tempMobile.equals("") || tempMobile.equals(" ")) {
                                            tempMobile = ContactList.getContactList().get(indexOption).getMobile();
                                        }
                                        while (!Contact.isValidNumber(tempMobile)) {
                                            System.out.println("Please enter a valid phone number using the format: XXX-XXX-XXXX.");
                                            System.out.println("Enter mobile: ");
                                            tempMobile = InputCollector.getUserInput(("Enter mobile:"));
                                        }
                                        ContactList.getContactList().get(indexOption).setMobile(tempMobile);

                                        System.out.println("Enter work: ");
                                        ContactList.getContactList().get(indexOption).setWork(InputCollector.getUserInput("Enter work:"));
                                        System.out.println("Enter home: ");
                                        ContactList.getContactList().get(indexOption).setHome(InputCollector.getUserInput("Enter home:"));
                                        System.out.println("Enter city: ");
                                        ContactList.getContactList().get(indexOption).setCity(InputCollector.getUserInput("Enter city: "));
                                        ContactList.displayContacts();
                                        System.out.println("Successfully updated");
                                        break;
                                }
                                    break;
                            } catch (Exception e) {
                                System.out.println("not found, the current Contact list is as below: ");
                            }
                        }
                        break;

                    case 5:
                            System.out.println("Bye!");
                            System.exit(0);

                    default:
                            System.out.println("Invalid option. Please enter a valid option on the menu.");
                            continue;
                }

            } catch (Exception e){
                System.out.println("Invalid option. Please enter a valid option on the menu.");
            }
        }
    }
}














