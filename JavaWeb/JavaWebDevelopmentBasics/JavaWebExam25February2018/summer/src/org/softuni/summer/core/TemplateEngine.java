package org.softuni.summer.core;

import org.softuni.summer.api.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TemplateEngine {
    private final String templatesFolderPath;

    private final Pattern partialsPattern = Pattern.compile("\\{(.+?)}");

    private Model model;

    public TemplateEngine(String templatesFolderPath) {
        this.templatesFolderPath = templatesFolderPath;
    }

    private String renderContent(String templateContent) {
        String renderedContent = templateContent;

        for (Map.Entry<String, Object> attributeEntry : this.model.getAttributes().entrySet()) {
            String attributeEntryPlaceholder = "$(" + attributeEntry.getKey() + ")";

            renderedContent = renderedContent.replace(attributeEntryPlaceholder, attributeEntry.getValue().toString());
        }

        Matcher matcher = this.partialsPattern.matcher(renderedContent);

        while (matcher.find()) {
            String partialName = matcher.group(1);

            try {
                String partialHtml = this.loadTemplate(partialName);
                renderedContent = renderedContent.replace(matcher.group(), partialHtml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return renderedContent;
    }

    public Model getNewModel() {
        return this.model = new Model();
    }

    public boolean isTemplate(String result) {
        return result.startsWith("template:");
    }

    public String loadTemplate(String templateName) throws IOException {
        String templateContent = String.join("", Files.readAllLines(
                Paths.get(this.templatesFolderPath + templateName + ".html")));

        return this.renderContent(templateContent);
    }
}