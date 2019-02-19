package trees_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SweepAndPrune {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        List<GameObject> objects = new ArrayList<>();

        while (!line.equals("start")) {
            String[] split = line.split(" ");

            String name = split[1];
            int x1 = Integer.parseInt(split[2]);
            int y1 = Integer.parseInt(split[3]);

            objects.add(new GameObject(name, x1, y1));
            line = reader.readLine();
        }

        line = reader.readLine();
        int tickCount = 1;

        while (!line.equals("end")) {
            String[] split = line.split(" ");

            if (split[0].equals("move")) {
                String name = split[1];
                int newX1 = Integer.parseInt(split[2]);
                int newY1 = Integer.parseInt(split[3]);

                GameObject objectToUpdate = null;

                for (GameObject gameObject : objects) {
                    if (gameObject.getName().equals(name)) {
                        objectToUpdate = gameObject;
                        break;
                    }
                }

                if (objectToUpdate == null) {
                    line = reader.readLine();
                    continue;
                }

                objects.remove(objectToUpdate);
                objectToUpdate.setBounds(new Rectangle(newX1, newY1, 10, 10));
                objects.add(objectToUpdate);

                printCollisions(objects, tickCount++);
            } else if (split[0].equals("tick")) {
                printCollisions(objects, tickCount++);
            }

            line = reader.readLine();
        }
    }

    private static void printCollisions(List<GameObject> objects, int tickCount) {
        Collections.sort(objects);

        for (int i = 0; i < objects.size(); i++) {
            GameObject obj1 = objects.get(i);

            for (int j = i + 1; j < objects.size(); j++) {
                GameObject obj2 = objects.get(j);

                if (obj1.getBounds().getX2() < obj2.getBounds().getX1()) {
                    break;
                }

                if (obj1.getBounds().intersects(obj2.getBounds())) {
                    System.out.printf("(%d) %s collides with %s\n", tickCount, obj1.getName(), obj2.getName());
                }
            }
        }
    }
}