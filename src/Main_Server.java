import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main_Server {

    public static void main(String[] args) throws IOException {

        int port = 10086;

        DatagramSocket datagramSocket = new DatagramSocket(port);

        byte[] bytes = new byte[1024];

        while(true) {

            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            datagramSocket.receive(datagramPacket);

            byte[] data = datagramPacket.getData();

            System.out.println(new String(data).trim() + datagramPacket.getAddress());
        }
    }
}
