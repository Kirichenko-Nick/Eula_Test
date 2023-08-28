package JavaMit.ProjektArbeit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("person.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Person person = (Person) objectInputStream.readObject();
            System.out.println("Person object deserialized: " + person);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
