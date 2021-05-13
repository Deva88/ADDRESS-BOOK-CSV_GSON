package com.addressbook;

/**
 https://howtodoinjava.com/gson/gson-serialize-deserialize-json/
 toJson -->serialization
 fromJson -->De-serialization
 setPrettyPrinting().create();  -->proper readable way of printing
 Gson gson = new Gson();    -->pre defined class
 Gson gson = new GsonBuilder() -->customization gson
 **/
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class AddressBookJSONTest {
    @Test
    public void givenJSONFile_WhenRead_ShouldReturnTrue(){
        AddressBookJSON json=new AddressBookJSON();
        boolean result=json.jsonRead();
        Assertions.assertTrue(result);
    }

    @Test
    public void givenJSONFile_WhenWrite_ShouldReturnTrue() throws IOException {
        AddressBookJSON json = new AddressBookJSON();
        ContactInfo contact1 = new ContactInfo("Devendra","Kumar","garkha","saran","Bihar",841311,
                "8123273639","dev123@gmail.com");
        boolean result1=json.jsonWrite(contact1);
        //boolean result2=json.jsonWrite(contact2);
        Assertions.assertTrue(result1);
        //Assert.assertTrue(result2);
    }
}