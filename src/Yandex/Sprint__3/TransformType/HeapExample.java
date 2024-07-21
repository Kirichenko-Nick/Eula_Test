package Yandex.Sprint__3.TransformType;

public class HeapExample {

    public static void main(String[] args) {
        Ca cat = new Ca("Барсик", 4);
        // stack: {main: cat = [Cat@683]}
        soSmthInteresting(cat);
        System.out.println("Это " + cat.name + ", ему " + cat.age + " лет.");
    }

    static void soSmthInteresting(Ca cat) {
        // stack: {soSmthInteresting: [cat = [Cat@683], main: cat = [Cat@683]}
        cat.age++;
        cat = new Ca("Роджер", cat.age);
        // stack: {soSmthInteresting: [cat = [Cat@686], main: cat = [Cat@683]}
        System.out.println("Теперь кота зовут " + cat.name);
    }
}

class Ca {
    String name;
    int age;

    public Ca(String catName, int catAge) {
        name = catName;
        age = catAge;
    }
}
