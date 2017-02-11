import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        LinkedHashMap<String, Integer> nameGoing = new LinkedHashMap<>();

        for (String person : people) {
            nameGoing.put(person, 0);
        }

        String command = reader.readLine();

        HashSet<String> currentlyAppliedFilters = new HashSet<>();

        while (!command.equals("Print")) {
            if (currentlyAppliedFilters.contains(command)) {
                command = reader.readLine();
                continue;
            }

            String[] commandArgs = command.split(";");

            String filterStatus = commandArgs[0];
            String filterType = commandArgs[1];
            String filterParameter = commandArgs[2];

            if (currentlyAppliedFilters.size() == 0 && filterStatus.equals("Remove filter")) {
                command = reader.readLine();
                continue;
            }

            switch (filterType) {
                case "Starts with":
                    for (String name : nameGoing.keySet()) {
                        if (name.startsWith(filterParameter)) {
                            if (filterStatus.equals("Add filter")) {
                                currentlyAppliedFilters.add(command);
                                nameGoing.put(name, nameGoing.get(name) + 1);
                            } else {
                                currentlyAppliedFilters.remove(command);
                                nameGoing.put(name, nameGoing.get(name) - 1);
                            }
                        }
                    }

                    break;

                case "Ends with":
                    for (String name : nameGoing.keySet()) {
                        if (name.endsWith(filterParameter)) {
                            if (filterStatus.equals("Add filter")) {
                                currentlyAppliedFilters.add(command);
                                nameGoing.put(name, nameGoing.get(name) + 1);
                            } else {
                                currentlyAppliedFilters.remove(command);
                                nameGoing.put(name, nameGoing.get(name) - 1);
                            }
                        }
                    }

                    break;

                case "Length":
                    for (String name : nameGoing.keySet()) {
                        if (name.length() == Integer.parseInt(filterParameter)) {
                            if (filterStatus.equals("Add filter")) {
                                currentlyAppliedFilters.add(command);
                                nameGoing.put(name, nameGoing.get(name) + 1);
                            } else {
                                currentlyAppliedFilters.remove(command);
                                nameGoing.put(name, nameGoing.get(name) - 1);
                            }
                        }
                    }

                    break;

                case "Contains":
                    for (String name : nameGoing.keySet()) {
                        if (name.contains(filterParameter)) {
                            if (filterStatus.equals("Add filter")) {
                                currentlyAppliedFilters.add(command);
                                nameGoing.put(name, nameGoing.get(name) + 1);
                            } else {
                                currentlyAppliedFilters.remove(command);
                                nameGoing.put(name, nameGoing.get(name) - 1);
                            }
                        }
                    }

                    break;
            }

            command = reader.readLine();
        }

        for (String name : nameGoing.keySet()) {
            if (nameGoing.get(name) == 0) {
                System.out.print(name + " ");
            }
        }
    }
}