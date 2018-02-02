package javache;

import javache.repositories.UserRepository;
import javache.http.*;
import javache.io.Reader;
import javache.io.Writer;
import javache.models.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RequestHandler {
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;
    private HttpSession session;
    private HashMap<String, String> contentTypes;

    public RequestHandler(HttpSession session) {
        this.session = session;
        this.seedContentTypes();
    }

    public byte[] handleRequest(String requestContent) throws IOException {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();

        String url = this.httpRequest.getRequestUrl();
        String method = this.httpRequest.getMethod();

        //Routes
        switch (url) {
            case "/":
                this.getIndex();
                break;
            case "/login":
                if (method.equals("GET")) {
                    this.getLogin();
                } else if (method.equals("POST")) {
                    this.postLogin();
                }
                break;
            case "/register":
                if (method.equals("GET")) {
                    this.getRegister();
                } else if (method.equals("POST")) {
                    this.postRegister();
                }
                break;
            case "/profile":
                this.getProfile();
                break;
            case "/home":
                this.getHome();
                break;
            case "/logout":
                this.getLogout();
                break;
            default:
                File file = new File(WebConstants.ASSETS_FOLDER + url);

                if (!file.getCanonicalPath().startsWith(WebConstants.ASSETS_FOLDER)) {
                    this.httpResponse.setContent(new byte[0]);
                    this.httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
                }

                this.httpResponse.setContent(Reader.readFile(WebConstants.ASSETS_FOLDER + url));
                this.httpResponse.setStatusCode(HttpStatus.OK);
                this.httpResponse.addHeader("Content-Type", this.getContentTypeFromPath(url));
                break;
        }

        return this.httpResponse.getBytes();
    }

    private void seedContentTypes() {
        this.contentTypes = new LinkedHashMap<>();

        this.contentTypes.put("png", "image/png");
        this.contentTypes.put("jpg", "image/jpeg");
        this.contentTypes.put("jpeg", "image/jpeg");
        this.contentTypes.put("html", "text/html");
        this.contentTypes.put("css", "text/css");
    }

    private String getContentTypeFromPath(String path) {
        String extension = path.substring(path.lastIndexOf(".") + 1);

        if (this.contentTypes.containsKey(extension)) {
            return this.contentTypes.get(extension);
        }

        return "text/plain";
    }

    private void getIndex() {
        this.httpResponse.setContent(Reader.readFile(WebConstants.ASSETS_FOLDER + "\\html\\index.html"));
        this.httpResponse.setStatusCode(HttpStatus.OK);
    }

    private void getLogin() {
        if (this.isLoggedIn()) {
            this.httpResponse.addHeader("Location", "/profile");
            this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);

            return;
        }

        this.httpResponse.setContent(Reader.readFile(WebConstants.ASSETS_FOLDER + "\\html\\login.html"));
        this.httpResponse.setStatusCode(HttpStatus.OK);
    }

    private void postLogin() throws IOException {
        String email = this.httpRequest.getBodyParameters().get("email");
        String password = this.httpRequest.getBodyParameters().get("password");

        User user = UserRepository.findOneByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            this.httpResponse.setContent("<h1>User does not exist or passwords don't match!</h1>".getBytes());
            this.httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);

            return;
        }

        String sessionId = UUID.randomUUID().toString();
        this.httpResponse.addCookie("sessionId", sessionId);

        Map<String, Object> sessionData = new HashMap<>();
        sessionData.put("email", user.getEmail());
        sessionData.put("password", user.getPassword());

        this.session.addSessionData(sessionId, sessionData);

        this.httpResponse.addHeader("Location", "/profile");
        this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);
    }

    private void getRegister() {
        if (this.isLoggedIn()) {
            this.httpResponse.addHeader("Location", "/profile");
            this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);

            return;
        }

        this.httpResponse.setContent(Reader.readFile(WebConstants.ASSETS_FOLDER + "\\html\\register.html"));
        this.httpResponse.setStatusCode(HttpStatus.OK);
    }

    private void postRegister() throws IOException {
        String email = this.httpRequest.getBodyParameters().get("email");
        String password = this.httpRequest.getBodyParameters().get("password");
        String confirmPassword = this.httpRequest.getBodyParameters().get("confirmPassword");

        if (!password.equals(confirmPassword)) {
            this.httpResponse.setContent("<h1>Passwords do not match!</h1>".getBytes());
            this.httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);

            return;
        }

        User user = UserRepository.findOneByEmail(email);

        if (user != null) {
            this.httpResponse.setContent("<h1>User with the same email already exists!</h1>".getBytes());
            this.httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);

            return;
        }

        user = new User(String.valueOf(UUID.randomUUID()), email, password);
        Writer.writeUser(user);

        this.httpResponse.addHeader("Location", "/login");
        this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);
    }

    private void getProfile() throws IOException {
        if (!this.isLoggedIn()) {
            this.httpResponse.addHeader("Location", "/login");
            this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);

            return;
        }

        String sessionId = this.httpRequest.getCookies().get("sessionId");
        String email = (String) this.session.getSessionData(sessionId).get("email");
        String password = (String) this.session.getSessionData(sessionId).get("password");

        String profilePage = Reader.readAllLines(new FileInputStream(WebConstants.PAGES_FOLDER + "/users/profile.html"));
        profilePage = String.format(profilePage, email, password);

        this.httpResponse.setContent(profilePage.getBytes());
        this.httpResponse.setStatusCode(HttpStatus.OK);
    }

    private void getHome() throws IOException {
        if (!this.isLoggedIn()) {
            this.httpResponse.addHeader("Location", "/login");
            this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);

            return;
        }

        String sessionId = this.httpRequest.getCookies().get("sessionId");
        String currentlyLoggedInEmail = (String) this.session.getSessionData(sessionId).get("email");

        List<User> usersWithoutCurrentlyLoggedIn = UserRepository.findAll().stream()
                .filter(u -> !u.getEmail().equals(currentlyLoggedInEmail))
                .collect(Collectors.toList());

        StringBuilder htmlAsString = new StringBuilder();

        for (User user : usersWithoutCurrentlyLoggedIn) {
            htmlAsString.append("<p>").append(user.getEmail()).append("</p>");
        }

        String homePage = Reader.readAllLines(new FileInputStream(WebConstants.PAGES_FOLDER + "/home.html"));
        homePage = String.format(homePage, htmlAsString);

        this.httpResponse.setContent(homePage.getBytes());
        this.httpResponse.setStatusCode(HttpStatus.OK);
    }

    private void getLogout() {
        if (!this.isLoggedIn()) {
            this.httpResponse.addHeader("Location", "/login");
            this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);

            return;
        }

        String sessionId = this.httpRequest.getCookies().get("sessionId");
        this.session.removeSessionData(sessionId);

        this.httpResponse.addHeader("Location", "/");
        this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);
    }

    private boolean isLoggedIn() {
        String sessionId = this.httpRequest.getCookies().get("sessionId");

        return sessionId != null && this.session.getSessionData(sessionId) != null;
    }
}