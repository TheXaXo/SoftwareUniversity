import java.util.ArrayDeque;

public class TestProgram9 {
    public static void main(String[] args) {
        ArrayDeque<Integer> asd = new ArrayDeque<>();
        asd.add(2);
        asd.add(3);
        asd.push(4);

        System.out.println(asd);
    }
}