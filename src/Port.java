import java.util.LinkedList;

public class Port {
    private Cable cable;
    private LinkedList<Packet> received;
    private LinkedList<Packet> sendList;
    private boolean connected;

    public Port() {
        this.cable = null;
        this.received = new LinkedList<>();
        this.sendList = new LinkedList<>();
        this.connected = false;
    }

    public Cable getCable() {
        return this.cable;
    }

    public void setCable(Cable cable) {
        this.cable = cable;
    }

    public LinkedList<Packet> getReceived() {
        return this.received;
    }

    public LinkedList<Packet> getSendList() {
        return this.sendList;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void connect() {
        this.connected = true;
    }

    public void send(Packet pack) {
        System.out.println("Porta "+ this + " enviando pacote");
        sendList.add(pack);

        for (Packet packet : sendList) {
            cable.transfer(packet, this);
            sendList.removeFirst();
        }
    }

    public void recv(Packet pack) {
        System.out.println("Porta "+ this + " recebendo pacote");
        System.out.println("Adicionando na Lista de Recebidos");

        received.add(pack);
    }

}