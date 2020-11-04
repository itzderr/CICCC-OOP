package miniProject2;

/**ContactList represents an ArrayList of Contact**/

import java.util.ArrayList;

public class ContactList extends Contact {

    public static ArrayList<Contact> contactList = new ArrayList<>();

    public ContactList (String name, String mobile, String work, String home, String city, int index,ArrayList<Contact> contactList){
        super(index, name, mobile, work, home, city);
        this.contactList = contactList;
    }


    public static ArrayList<Contact> getContactList() {
        return contactList;
    }

    public static void setContactList(ArrayList<Contact> contactList) {
        ContactList.contactList = contactList;
    }

    /**
     * display all the contacts
     */
    public static void displayContacts(){
        for (int i = 0; i < ContactList.getContactList().size(); i++){
            System.out.println(ContactList.getContactList().get(i));
        }
    }

    /**
     * insert contact into the ContactList's arrayList
     * @param newContact
     */
    public static void addContact(Contact newContact){
        getContactList().add(newContact);
        setContactList(contactList);
    }

    // 入力されたindexがArrayList にあるかどうか
    public static boolean isInList(int inputIndex){
        if (inputIndex < getContactList().size()){
            return true;
        }
        return false;
    }

    // 名前と電話番号が一致する人の重複がないか確認
    public static boolean isDuplicate(String newName, String newMobile){
        for (int i = 0; i < getContactList().size(); i++){
            if (getContactList().get(i).getName() == newName && getContactList().get(i).getMobile() == newMobile){
                return true;
            }
            continue;
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
