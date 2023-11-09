public class App {
    static WashingMachine wm;

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Добро пожаловать, это Стиральная Машина \"Оптимус прайм\"");

        // Creates a new instance of the Washing Machine
        wm = new WashingMachine();

        // Starts a new thread for the application
        Thread th = new Thread(wm);
        th.start();// Thread running

    }

}
