package org.softuni.broccolina.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarUnzipUtil {
    public void unzipJar(String jarCanonicalPath) throws IOException {
        File outDirectory = new File(jarCanonicalPath.replace(".jar", ""));

        JarFile jarFile = new JarFile(new File(jarCanonicalPath));
        Enumeration<JarEntry> entries = jarFile.entries();

        if (outDirectory.exists()) {
            outDirectory.delete();
        }

        outDirectory.mkdir();

        while (entries.hasMoreElements()) {
            JarEntry currentEntry = entries.nextElement();
            File currentFile = new File(outDirectory.getCanonicalPath() + File.separator + currentEntry.getName());

            if (currentEntry.isDirectory()) {
                currentFile.mkdir();
                continue;
            }

            InputStream inputStream = jarFile.getInputStream(currentEntry);
            FileOutputStream outputStream = new FileOutputStream(currentFile);

            while (inputStream.available() > 0) {
                outputStream.write(inputStream.read());
            }

            outputStream.close();
            inputStream.close();
        }

        jarFile.close();
    }
}
