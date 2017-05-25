package p03_employee_info;

public class ConsoleClient {

    private InfoProvider infoProvider;
    private Formatter formatter;

    public ConsoleClient(InfoProvider infoProvider, Formatter formatter) {
        this.infoProvider = infoProvider;
        this.formatter = formatter;
    }

    public void printOutput(String criteria) {
        System.out.println(this.formatter.format(this.infoProvider.getEmployees(criteria)));
    }
}