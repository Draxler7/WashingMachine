public class App {
    static WashingMachine wm;

    public static void main(String[] args) throws Exception {

        System.out.println("Добро пожаловать, это Стиральная Машина \"Оптимус прайм\"");

        wm = new WashingMachine();

        Thread th = new Thread(wm);
        th.start();
    }
}
