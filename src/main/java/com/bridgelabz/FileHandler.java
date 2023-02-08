package com.bridgelabz;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
public class FileHandler {
    public void writeIntoFile(String adBookName, AddressBook addressBook) {

        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\bridgelabz\\ContactBook");

        try {
            String data = "";
            for (Contacts contact: addressBook.contactList) {
                data += contact.toString();
            }
            java.nio.file.Files.write(path,data.getBytes());
            System.out.println("Data written into file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(){
        Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\bridgelabz\\ContactBook");
        try {
            System.out.println(Files.readAllLines(path));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void writeToCSV(String name,AddressBook addressBook) {
        try {
            CSVWriter write = new CSVWriter(new FileWriter("C:\\Users\\User\\IdeaProjects\\AddressBook\\src\\main\\java\\com\\bridgelabz\\Contact.csv"));
            for (Contacts contact : addressBook.contactList) {
                String[] data = new String[]{contact.firstName, contact.lastName, contact.address, contact.city, contact.state, contact.email, contact.phoneNo};
                write.writeNext(data);
            }
            write.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}