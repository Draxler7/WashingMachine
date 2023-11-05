public class App {
    static WashingMachine wm;

    public static void main(String[] args) {
        // Приветствие
        System.out.println("Добро пожаловать, это Стиральная Машина \"Оптимус прайм\"");

        wm = new WashingMachine();

        // Создание потока для приложения
        Thread th = new Thread(wm);
        th.start();// Запуск потока
    }

}
