package JavaMit.ProjektArbeit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        try (FileOutputStream fileOutputStream = new FileOutputStream("person.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(person);
            System.out.println("Person object serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
