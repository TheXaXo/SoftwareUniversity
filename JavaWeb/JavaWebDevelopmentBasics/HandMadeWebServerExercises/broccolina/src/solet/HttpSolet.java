package solet;

public interface HttpSolet {
    void doGet(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);

    void doPostGet(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);

    void doPut(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);

    void doDelete(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);
}