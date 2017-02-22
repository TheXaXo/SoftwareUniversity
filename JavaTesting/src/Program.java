public class Program {
    public static void main(String[] args) {
        Cat kitty = new Cat();
        kitty.setAge(10);

        System.out.println(kitty.getAge());
        kitty.makeNoise();
    }
}