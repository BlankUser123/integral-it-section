public class Program {

    public static void main(String[] args) {
        Animal cat = new Cat(false, "cat family", 2, "Matilda");

        cat.eat();
        cat.move();
        ((Cat) cat).climbOnTree();
    }
}

class Animal {

    private final boolean male;

    private final String type;

    private final int age;

    public Animal(boolean male, String type, int age) {
        this.male = male;
        this.type = type;
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void eat() {
        System.out.println(type + " is eating...");
    }

    public void move() {
        System.out.println(type + " is moving...");
    }
}

class Cat extends Animal {

    private final String name;

    public Cat(boolean male, String type, int age, String name) {
        super(male, type, age);
        this.name = name;
    }

    public void climbOnTree() {
        System.out.println(getType() + " " + name + " is climbing on tree...");
    }
}
