import java.io.*;
import java.util.Hashtable;

public class MasterFile {
    private Hashtable<String, String> addresses = new Hashtable<String, String>();
    private File file;

    public MasterFile(String filename) throws IOException {
        File file = new File(filename);
        this.file = file;
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
    public void addAddress(String name, String address){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write(name+" "+address);
        } catch (IOException e) {
            System.out.println("Error al agregar la dirección nueva: " + e.getMessage());
        }
    }
}
