import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String fileOnePath = "C:\\Users\\TheXaXo\\Desktop\\one.txt";
        String fileTwoPath = "C:\\Users\\TheXaXo\\Desktop\\two.txt";
        String fileThreePath = "C:\\Users\\TheXaXo\\Desktop\\three.txt";

        String outputZip = "C:\\Users\\TheXaXo\\Desktop\\files.zip";

        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(outputZip))) {

            writeToZip(fileOnePath, output);
            writeToZip(fileTwoPath, output);
            writeToZip(fileThreePath, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToZip(String path, ZipOutputStream zos) throws IOException {
        File fileToAdd = new File(path);
        FileInputStream fis = new FileInputStream(fileToAdd);
        ZipEntry entry = new ZipEntry(path);
        zos.putNextEntry(entry);

        byte[] bytes = new byte[1024];
        int length;

        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }
}
