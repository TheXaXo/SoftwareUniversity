package org.softuni.main.casebook.utils;

import java.util.Map;

public final class TemplateEngine {
    public TemplateEngine() {

    }

    public String renderHtml(String html, Map<String, String> viewData) {
        for (Map.Entry<String, String> viewDataPair : viewData.entrySet()) {
            html = html.replace("$(" + viewDataPair.getKey() + ")", viewDataPair.getValue());
        }

        return html;
    }
}