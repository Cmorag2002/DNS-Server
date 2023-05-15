import java.io.*;
import java.util.Hashtable;

public class MasterFile {
    private Hashtable<String, String> addresses = new Hashtable<String, String>();

    public MasterFile(String filename) throws IOException {
        File file = new File(filename);
        FileReader file_reader = new FileReader(file);
        BufferedReader reader = new BufferedReader(file_reader);
        String line_of_file;
        while((line_of_file=reader.readLine())!=null){
            String[] columns = line_of_file.split(" ");
            addresses.put(columns[0], columns[1]);
        }
        reader.close();
    }
    public String getAddress(String name) {
        return addresses.get(name);
    }
}
