public class Main_Client {

    public static void main(String[] args) {

        new ClientThread("cliente 1").start();
        new ClientThread("cliente 2").start();
        new ClientThread("cliente 3").start();

    }
}