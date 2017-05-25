package blobs.core;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.models.Blob;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandInterpreter {

    private Map<String, Blob> blobs;

    public CommandInterpreter() {
        this.blobs = new LinkedHashMap();
    }

    public void interpretCommand(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        switch (tokens[0]) {
            case "create":
                String name = tokens[1];
                int health = Integer.parseInt(tokens[2]);
                int damage = Integer.parseInt(tokens[3]);

                Class<?> behaviorClass = Class.forName("blobs.models.behaviours." + tokens[4]);
                Constructor<?> behaviourConstructor = behaviorClass.getDeclaredConstructor();
                Behavior behavior = (Behavior) behaviourConstructor.newInstance();

                Class<?> attackClass = Class.forName("blobs.models.attacks." + tokens[5]);
                Constructor<?> attackConstructor = attackClass.getDeclaredConstructor();
                Attack attack = (Attack) attackConstructor.newInstance();

                this.blobs.put(name, new Blob(name, health, damage, behavior, attack));

                break;
            case "attack":
                String attackerName = tokens[1];
                String targetName = tokens[2];

                Blob attacker = this.blobs.get(attackerName);
                Blob target = this.blobs.get(targetName);

                attacker.attack(target);

                break;
            case "status":
                for (Blob blob : this.blobs.values()) {
                    System.out.println(blob);
                }

                break;
        }
    }

    public void updateBlobs() {
        for (Blob blob : this.blobs.values()) {
            blob.update();
        }
    }
}