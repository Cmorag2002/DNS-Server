import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DNSServer server = new DNSServer(53);
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre del dominio: ");
            String entrada = scanner.next();
            server.sendQuery(entrada);
        }
    }
}