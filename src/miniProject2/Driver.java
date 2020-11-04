package miniProject2;

/**
 * @yumi
 */

import java.util.ArrayList;
//import java.util.Scanner;

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

        while (true) {

                // try catch でoptionインプットの入力確認
                System.out.print("+==== Contact  App ====+\n" +
                        "| 1. List all Contacts |\n" +
                        "| 2. Add new Contact   |\n" +
                        "| 3. Remove Contacts   |\n" +
                        "| 4. Update Contacts   |\n" +
                        "| 5. Quit              |\n" +
                        "+======================+\n" +
                        "Enter your option: ");

                int optionInput = InputCollector.getUserIntInput("Enter your option");
                // optionが1より大きく、5以下であるか確認(else:int以外である場合、スペースである場合)
                if (String.valueOf(optionInput).length() == 1) {
                    switch (optionInput) {
                        case 1:
                            ContactList.displayContacts();
                            break;

                        case 2:

                            // while trueにする
                            int tempIndex = ContactList.getContactList().size();
                            System.out.println("Enter name: ");
                            String tempName = InputCollector.getUserInput("Enter name");
                            while (tempName == ""){
                                System.out.println("You must enter this field.");
                                System.out.println("Enter name: ");
                                tempName = InputCollector.getUserInput("Enter name");
                            }
                            System.out.println("Enter mobile: ");
                            String tempMobile = InputCollector.getUserInput("Enter mobile: ");
                            while (tempMobile == "") {
                                System.out.println("You must enter this field.");
                                System.out.println("Enter mobile: ");
                                tempMobile = InputCollector.getUserInput(("Enter mobile:"));
                            }
                            System.out.println("Enter work: ");
                            String tempWork = InputCollector.getUserInput("Enter work:");
                            System.out.println("Enter home: ");
                            String tempHome = InputCollector.getUserInput("Enter home:");
                            System.out.println("Enter city: ");
                            String tempCity = InputCollector.getUserInput("Enter city:");
                            // 入力された名前と電話番号でこれまでのリスト内で重複がない場合、新しいコンタクト作成。
                            Contact newContact = new Contact(tempIndex, tempName,tempMobile,tempWork,tempHome,tempCity);
                            ContactList.addContact(newContact);
                            ContactList.displayContacts();
                            System.out.println("Successfully added a new contact");
                            break;
                             // 重複のある場合
                            //重複した箇所をディスプレイ->新しく作りたいかどうか-> 必要なければbreak,
                            //新しく作りたい場合は先頭に戻る


                        case 3:
                            ContactList.displayContacts();
                            while(true) {
                                try {
                                    System.out.println("Enter index to be removed: ");
                                    int option = InputCollector.getUserIntInput("Enter index: ");

                                    //when nothing is input//////
                                    if (String.valueOf(option).length() == 0) {
                                        throw new Exception("Please input an index");
                                    }
                                    System.out.printf("Are you sure you want to delete " + ContactList.getContactList().get(option) + "?\n" +
                                            "press y to remove, n to go back to menu.");

                                    String rep = InputCollector.getUserInput("y/n");
                                    if(rep.equals("n")){
                                        break;
                                    }

                                    String temp = ContactList.getContactList().get(option).getName();
                                    ContactList.removeElement(option);
                                    ContactList.displayContacts();
                                    System.out.printf("Successfully removed " + temp);
                                    System.out.println();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("not found, the current Contact list is as below: ");

                                }
                                ContactList.displayContacts();
                                System.out.println("Do you still want to remove a contact? press y or n.");
                                String str = InputCollector.getUserInput("Enter: ");
                                if (str.equals("n")){
                                    System.out.println("Bye");
                                    break;
                                }

                            }
                            break;

                        case 4:
                            // while trueでtry catch文にする
                            ContactList.displayContacts();
                            System.out.println("Enter index to be updated: ");
                            int toBeUpdated = InputCollector.getUserIntInput("Enter index: ");
                            // indexがArrayないにあるのがtrue
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
                            System.out.println("Bye!");
                            System.exit(0);

                        default:
                            System.out.println("Input invalid");
                            continue;
                    }
            }
        }
    }
}














