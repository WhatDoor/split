import java.io.*;

public class NovelTranslate {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "text.txt";

        // The name of the file to create.
        String fileNameOut = "temp.txt";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileNameOut), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                // do some processing with line, and then:
                System.out.println(line);
                out.println(line);
            }
            out.close();
            in.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
