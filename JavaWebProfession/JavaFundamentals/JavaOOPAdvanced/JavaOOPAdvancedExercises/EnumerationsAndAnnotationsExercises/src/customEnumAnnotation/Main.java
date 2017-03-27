package customEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class classToInspect = Class.forName("customEnumAnnotation.Card" + reader.readLine());

        CustomAnnotation annotation = (CustomAnnotation) classToInspect.getDeclaredAnnotation(CustomAnnotation.class);
        System.out.printf("Type = %s, Description = %s", annotation.type(), annotation.description());
    }
}