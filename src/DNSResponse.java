import java.net.InetAddress;

public class DNSResponse {
    private String name;
    private int type;
    private String address;

    public DNSResponse(String name, int type, String address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }
}
