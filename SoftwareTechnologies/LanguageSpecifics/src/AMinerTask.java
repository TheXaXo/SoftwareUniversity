import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, Long> resourceAndQuanity = new LinkedHashMap<String, Long>();

        String resource = null;
        long quanity = 0;

        while (true){
            resource = console.nextLine();
            if (resource.equals("stop")){
                break;
            }
            quanity = Long.parseLong(console.nextLine());

            if (!resourceAndQuanity.containsKey(resource)){
                resourceAndQuanity.put(resource, quanity);
            }
            else{
                long currentQuanity = resourceAndQuanity.get(resource);
                resourceAndQuanity.put(resource, currentQuanity + quanity);
            }
        }

        for (Map.Entry<String, Long> pair : resourceAndQuanity.entrySet()){
            System.out.printf("%s -> %d%n", pair.getKey(), pair.getValue());
        }
    }
}
