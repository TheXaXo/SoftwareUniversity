package org.softuni.main.javache.http;

import java.util.Map;

public interface HttpSession {
    void addSessionData(String sessionId, Map<String, Object> dataMap);

    void removeSessionData(String sessionId);

    Map<String, Object> getSessionData(String sessionId);
}