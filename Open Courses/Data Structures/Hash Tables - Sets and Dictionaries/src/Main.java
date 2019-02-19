public class Main {

    public static void main(String[] args) {
        CustomHashSet<Integer> set1 = new CustomHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        CustomHashSet<Integer> set2 = new CustomHashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        for (Integer element : set1.symmetricalExcept(set2)) {
            System.out.println(element);
        }
    }
}