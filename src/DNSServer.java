import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DNSServer {
    private int port_number = 53;
    private MasterFile masterFile;
    private ForeignResolver foreignResolver;

    public DNSServer(int port) throws IOException {
        masterFile = new MasterFile("hosts.txt");
        foreignResolver = new ForeignResolver();
    }

    public void sendQuery(String hostname) {
        try (DatagramSocket socket = new DatagramSocket(port_number)) {
            DNSQuery query = new DNSQuery(hostname, 1);
            DNSResponse response = generateResponse(query);
            System.out.println("Dirección del hostname: " + response.getAddress());
            /*
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            DNSQuery query = parseQuery(packet);
            DNSResponse response = generateResponse(query);
            byte[] responseData = generateResponseData(response);
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
            socket.send(responsePacket);

            */
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private DNSResponse generateResponse(DNSQuery query) {
        String address = masterFile.getAddress(query.getName());
        if (address != null) {
            return new DNSResponse(query.getName(), query.getType(), address);
        } else {
            return foreignResolver.resolve(query);
        }
    }
    /*
    private DNSQuery parseQuery(DatagramPacket data) {
        //Análisis de la consulta DNS desde el paquete DNS entrante
        String hostname = new String(data.getData(), 0, data.getLength());
        return new DNSQuery(hostname, 1);
    }

    private byte[] generateResponseData(DNSResponse response) {
        //Generación del paquete DNS saliente a partir de la respuesta DNS
        byte[] data = new byte[1024];
        return data = response.getName().getBytes();
    }
     */
}
