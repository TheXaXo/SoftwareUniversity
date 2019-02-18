package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TextEditorImpl implements TextEditor {
    private Trie<User> usernameString;

    public TextEditorImpl() {
        this.usernameString = new Trie<>();
    }

    @Override
    public void login(String username) {
        this.usernameString.insert(username, new User());
    }

    @Override
    public void logout(String username) {
        User user = this.usernameString.getValue(username);

        user.setLoggedIn(false);
        user.setPastStrings(new ArrayDeque<>());
        user.setStringBuilder(new StringBuilder());
    }

    @Override
    public void prepend(String username, String string) {
        this.insert(username, 0, string);
    }

    @Override
    public void insert(String username, int index, String string) {
        User user = this.usernameString.getValue(username);

        if (!user.isLoggedIn()) {
            return;
        }

        StringBuilder userStringBuilder = user.getStringBuilder();

        user.getPastStrings().addLast(userStringBuilder.toString());
        userStringBuilder.insert(index, string);
    }

    @Override
    public void substring(String username, int startIndex, int length) {
        User user = this.usernameString.getValue(username);

        if (!user.isLoggedIn()) {
            return;
        }

        StringBuilder userStringBuilder = user.getStringBuilder();

        user.getPastStrings().addLast(userStringBuilder.toString());
        user.setStringBuilder(new StringBuilder(userStringBuilder.substring(startIndex, startIndex + length)));
    }

    @Override
    public void delete(String username, int startIndex, int length) {
        User user = this.usernameString.getValue(username);

        if (!user.isLoggedIn()) {
            return;
        }

        StringBuilder userStringBuilder = user.getStringBuilder();

        user.getPastStrings().addLast(userStringBuilder.toString());
        user.setStringBuilder(new StringBuilder(userStringBuilder.delete(startIndex, startIndex + length)));
    }

    @Override
    public void clear(String username) {
        User user = this.usernameString.getValue(username);

        if (!user.isLoggedIn()) {
            return;
        }

        user.getPastStrings().addLast(user.getStringBuilder().toString());
        user.setStringBuilder(new StringBuilder());
    }

    @Override
    public int length(String username) {
        User user = this.usernameString.getValue(username);

        return user.getStringBuilder().length();
    }

    @Override
    public String print(String username) {
        User user = this.usernameString.getValue(username);

        return user.getStringBuilder().toString();
    }

    @Override
    public void undo(String username) {
        User user = this.usernameString.getValue(username);

        if (!user.isLoggedIn()) {
            return;
        }

        user.setStringBuilder(new StringBuilder(user.getPastStrings().removeLast()));
    }

    @Override
    public Iterable<String> users(String prefix) {
        List<String> loggedInUsers = new ArrayList<>();

        for (String user : this.usernameString.getByPrefix(prefix)) {
            if (this.usernameString.getValue(user).isLoggedIn()) {
                loggedInUsers.add(user);
            }
        }

        return loggedInUsers;
    }

    private class User {
        private boolean isLoggedIn;
        private Deque<String> pastStrings;
        private StringBuilder stringBuilder;

        private User() {
            this.isLoggedIn = true;
            this.pastStrings = new ArrayDeque<>();
            this.stringBuilder = new StringBuilder();
        }

        private boolean isLoggedIn() {
            return this.isLoggedIn;
        }

        private void setLoggedIn(boolean loggedIn) {
            isLoggedIn = loggedIn;
        }

        private Deque<String> getPastStrings() {
            return this.pastStrings;
        }

        private void setPastStrings(Deque<String> pastStrings) {
            this.pastStrings = pastStrings;
        }

        private StringBuilder getStringBuilder() {
            return this.stringBuilder;
        }

        private void setStringBuilder(StringBuilder stringBuilder) {
            this.stringBuilder = stringBuilder;
        }
    }
}