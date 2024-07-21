package Yandex.Sprint2.bibliotek;

public class Contact {
    public String name;
    public String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
