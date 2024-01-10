import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.Random;

public class ClientThread extends Thread {

    private String clientName;

    public ClientThread(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(new Random().nextInt(3000)+2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int port = 10086;
        InetAddress inetAddress = null;
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            inetAddress = InetAddress.getByName("192.168.1.210");
            String s = "hola, soy " + this.clientName + ", conectado en " + new Date(System.currentTimeMillis());

            byte[] bytes = s.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);

            datagramSocket.send(datagramPacket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        datagramSocket.close();
    }
}
