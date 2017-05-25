package CustomList;

public class CommandInterpreter {

    private CustomList<String> elements;

    public CommandInterpreter() {
        this.elements = new CustomList<String>();
    }

    public void interpretCommand(String command, String[] tokens) {
        switch (command) {
            case "Add":
                this.elements.add(tokens[1]);
                break;

            case "Remove":
                this.elements.remove(Integer.parseInt(tokens[1]));
                break;

            case "Contains":
                System.out.println(this.elements.contains(tokens[1]));
                break;

            case "Swap":
                this.elements.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;

            case "Greater":
                System.out.println(this.elements.countGreaterThan(tokens[1]));
                break;

            case "Max":
                System.out.println(this.elements.getMax());
                break;

            case "Min":
                System.out.println(this.elements.getMin());
                break;

            case "Print":
                System.out.print(this.elements);
                break;
        }
    }
}
