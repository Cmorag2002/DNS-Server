import java.net.InetAddress;
import java.net.UnknownHostException;

public class ForeignResolver {

    public ForeignResolver() {

    }
    public DNSResponse resolve(DNSQuery query) {
        try {
            InetAddress address = InetAddress.getByName(query.getName());
            String stringAddress = address.toString();
            return new DNSResponse(query.getName(), query.getType(), stringAddress.substring(stringAddress.lastIndexOf("/")+1));
        } catch (UnknownHostException e) {
            System.out.println("Dominio: " + query.getName() + " | IP: no encontrada");
            return null;
        }
    }
}

