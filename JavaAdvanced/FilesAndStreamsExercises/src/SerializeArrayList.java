import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(2d);
        list.add(3d);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("C:\\Users\\TheXaXo\\Desktop\\list.ser"));
             ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\TheXaXo\\Desktop\\list.ser"))) {
            output.writeObject(list);

            ArrayList<Double> listFromSave = (ArrayList<Double>) input.readObject();

            for (Double number : listFromSave) {
                System.out.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}