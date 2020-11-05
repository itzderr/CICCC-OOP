package miniProject2;

/**ContactList represents an ArrayList of Contact**/

import java.util.ArrayList;

public class ContactList extends Contact {

    // instance variable
    public static ArrayList<Contact> contactList = new ArrayList<>();

    // constructor
    public ContactList (String name, String mobile, String work, String home, String city, int index,ArrayList<Contact> contactList){
        super(index, name, mobile, work, home, city);
        this.contactList = contactList;
    }

    // getter
    public static ArrayList<Contact> getContactList() {
        return contactList;
    }
    // setter
    public static void setContactList(ArrayList<Contact> contactList) {
        ContactList.contactList = contactList;
    }


    /**
     * display all the contacts
     */
    public static void displayContacts(){
        for (int i = 0; i < ContactList.getContactList().size(); i++){
            System.out.println(getContactList().get(i));
        }
    }


    /**
     * insert contact into the ContactList's arrayList, and set it as a new contact list
     * @param newContact
     */
    public static void addContact(Contact newContact){
        getContactList().add(newContact);
        setContactList(contactList);
    }


    /**
     * Check if the inputted index is in the list
     * @param inputIndex
     * @return boolean
     */
    public static boolean isInList(int inputIndex){
        if (inputIndex < getContactList().size()){
            return true;
        }
        return false;
    }

    /**
     * Check if there is a contact with the same name and same mobile phone number
     * @param newName
     * @param newMobile
     * @return boolean
     */

    public static boolean isDuplicate(String newName, String newMobile){
        for (int i = 0; i < getContactList().size(); i++){
            if (getContactList().get(i).getName().equals(newName) && getContactList().get(i).getMobile().equals(newMobile)){
                System.out.println("The contact already exists, and can not be created.");
                System.out.println(getContactList().get(i));
                return true;
            }
        }
        return false;
    }


    /**
     * remove designated element, and update index of the remained contacts
     * @param index
     */
    public static void removeElement(int index){
        ContactList.getContactList().remove(index);
        setContactList(contactList);
        for(int i = index; i < getContactList().size();i++){
            getContactList().get(i).setIndex(i);
        }
    }
}
