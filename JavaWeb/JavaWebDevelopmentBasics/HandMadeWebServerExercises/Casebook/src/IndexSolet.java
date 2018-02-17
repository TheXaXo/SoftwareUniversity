import org.softuni.broccolina.annotations.WebSolet;
import org.softuni.broccolina.solet.BaseHttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.javache.http.HttpStatus;
import org.softuni.javache.io.Writer;

import java.io.IOException;

@WebSolet(route = "/index")
public class IndexSolet extends BaseHttpSolet {
    @Override
    public void doGet(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse) {
        soletResponse.setStatusCode(HttpStatus.OK);
        soletResponse.setContent("<h1>Hello from solet</h1>".getBytes());
        soletResponse.addHeader("Content-Type", "text/html");

        System.out.println(soletResponse.getBytes());
        System.out.println(soletResponse.getResponseStream());

        try {
            Writer.writeBytes(soletResponse.getBytes(), soletResponse.getResponseStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}