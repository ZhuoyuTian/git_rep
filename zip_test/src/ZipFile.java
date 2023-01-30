import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path to the file：");
        String path = sc.nextLine();
        System.out.println(path);
        Zip(path);
        System.out.println("Enter the original path to the zip file：");
        String originalPath = sc.nextLine();
        System.out.println("Enter the target path to the zip file：");
        String targetPath = sc.nextLine();
        unZip(originalPath,targetPath);

    }

    public static void Zip(String path) {
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;
        try {
            String sourceFile = path;
            FileOutputStream fos = new FileOutputStream("compressed.zip");
            zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);
            fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        } catch (IOException ioExp) {
            System.out.println("Error while zipping " + ioExp.getMessage());
        } finally {
            if (zipOut != null) {
                try {
                    //closing output stream
                    zipOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    //closing buffered input stream
                    fis.close();
                } catch (IOException e) {
                    //prints exception
                    e.printStackTrace();
                }
            }
        }
    }
    public static void unZip(String originalPath,String targetPath){
        File dir = new File(targetPath);
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(originalPath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry zipEntry = zis.getNextEntry();
            while(zipEntry != null){
                String fileName = zipEntry.getName();
                File newFile = new File(targetPath + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                zipEntry = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
