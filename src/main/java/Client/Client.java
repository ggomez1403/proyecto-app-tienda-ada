package Client;

public class Client {
    private int id;
    private String name;
    private String address;

    private static int lastId;

    public Client(String name, String address) {
        this.id = ++lastId;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
