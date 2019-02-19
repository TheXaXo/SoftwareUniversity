import hash_tables_exercise.OrderedSet;

public class Main {
    public static void main(String[] args) {
        OrderedSet<Integer> set = new OrderedSet<>();
        set.add(17);
        set.add(9);
        set.add(12);
        set.add(19);
        set.add(6);
        set.add(25);

        set.remove(12);

        for (Integer item : set) {
            System.out.println(item);
        }
    }
}