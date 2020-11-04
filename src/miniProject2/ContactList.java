package miniProject2;

import lab3.Piece;
import midTermExam.Vehicle;

import java.util.ArrayList;

public class ContactList extends Contact {
    // instance variable

    public static ArrayList<Contact> contactList = new ArrayList<>();

    public  ContactList (String name, String mobile, String work, String home, String city, int index,ArrayList<Contact> contactList){
        super(index, name, mobile, work, home, city);
        this.contactList = contactList;
    }

    public static ArrayList<Contact> getContactList() {
        return contactList;
    }

    public static void setContactList(ArrayList<Contact> contactList) {
        ContactList.contactList = contactList;
    }

    public static void displayContacts(){
        for (int i = 0; i < ContactList.getContactList().size(); i++){
            System.out.println(ContactList.getContactList().get(i));
        }
    }

    public static void removeElement(int index){

//        if (index >= getContactList().size()){
//            throw new IndexOutOfBoundsException("invalid input");
//        }
//        else if (index == getContactList().size()-1){
//            ContactList.getContactList().remove(index);
//            return getContactList();
//        } else {
            ContactList.getContactList().remove(index);
            setContactList(contactList);
            for(int i = index; i < getContactList().size();i++){
                getContactList().get(i).setIndex(i);
            }

    }



}
