import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/selected_columnsText.txt"));
            String line = br.readLine();
            while(line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            String[] parts = line.split(",");
//            try {
                System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
//            }
//            catch(IndexOutOfBoundsException ioe) {
//                System.out.println(line);
//            }
        }

    }
}
