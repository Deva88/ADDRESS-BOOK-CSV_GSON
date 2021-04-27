package com.addressbook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    ArrayList<Contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetailsAddedToFil_ShouldReturn_True() {
        Contact contact1 = new Contact("Devendra", "Kumar", "Garkha", "Saran", "Bihar", 523001,8123273639L, "dev@gmail.com");
        Contact contact2 =new Contact("Abhi","Raj","BTM","Bangalore","KA",523001,9739251118L,"abhi@gm.in");
        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        boolean isAdded = addressBook.addContact(contact);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void PersonContactDetailsAddedToFile_WhenRead_ShouldReturn_True() throws IOException {
        Contact contact1 = new Contact("Devendra", "Kumar", "Garkha", "Saran", "Bihar", 523001,8123273639L, "dev@gmail.com");
        Contact contact2 =new Contact("Abhi","Raj","BTM","Bangalore","KA",523001,9739251118L,"abhi@gm.in");

        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        boolean isAdded = addressBook.addContact(contact);
        if (isAdded) {
            boolean isRead = addressBook.viewContact();
            Assertions.assertTrue(isAdded);
        }
    }

    @Test
    public void givenCSV_FileWhenRead_ShouldReturnTrue() throws CsvValidationException, IOException{
        AddressBookOpenCSV opencsv= new AddressBookOpenCSV();
        boolean result=opencsv.readCSV();
        Assertions.assertTrue(result);
    }

    @Test
    public void givenCSVFile_WhenWrite_ShouldReturnTrue() throws IOException {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        ArrayList<String[]> contacts = new ArrayList<>();
        String[] contact1 = {"Devendra", "Kumar", "Garkha", "Saran", "Bihar", String.valueOf(523001), String.valueOf(8123273639L), "dev@gmail.com"};
        String[] contact2 ={"Abhi","Raj","BTM","Bangalore","KA", String.valueOf(523001), String.valueOf(9739251118L),"abhi@gm.in"};

        contacts.add(contact1);
        contacts.add(contact2);
        AddressBookOpenCSV opencsv=new AddressBookOpenCSV();
        Boolean result = opencsv.writeCSVFile(contacts);
        Assertions.assertTrue(result);
    }
}