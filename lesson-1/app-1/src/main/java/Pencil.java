public class Pencil {

    private String brand;

    private String color;

    private boolean eraser;

    public Pencil(String brand, String color, boolean eraser) {
        this.brand = brand;
        this.color = color;
        this.eraser = eraser;
    }

    public void draw() {
        System.out.println("Pencil of brand " + brand + " with color " + color + " and having eraser = " + eraser + " is drawing...");
    }
}
