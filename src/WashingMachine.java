import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WashingMachine implements Runnable {

    // Загрузка
    static LoadP lp;
    // Главный фрейм
    public static JFrame frame;
    // Верхняя панель
    private static JPanel mainPanel;
    private static JPanel pressPanel;
    // Окно неработающей стиралки
    private static JLabel windowMachine;
    // Окно работающей стиралки
    private static JLabel windowMachine1;
    // Режимы температуры
    private static JLabel tempLabel30;
    private static JLabel tempLabel40;
    private static JLabel tempLabel60;
    private static JLabel tempLabel70;
    // Иконка
    protected ImageIcon image;

    private JPanel spinPanel;

    public void run() {
        try {
            Thread.sleep(10);

            // Создание потока загрузки и запуск его(Пока загрузка происходит обрабатывается
            // дальнейший код)
            lp = new LoadP();
            Thread load = new Thread(lp);
            load.start();

            // Создание и настройка Фрейма
            frame = new JFrame();
            frame.setLayout(null);
            frame.getContentPane().setBackground(java.awt.Color.GRAY);
            frame.setBounds(350, 10, 600, 650);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setTitle("Стиральная машина \"Оптимус Прайм v1.0.0\"");

            // Создание и настройка панели сверху
            mainPanel = new JPanel();
            mainPanel.setLayout(null);
            mainPanel.setBounds(0, 0, 600, 180);
            mainPanel.setBackground(Color.LIGHT_GRAY);
            frame.add(mainPanel);

            pressPanel = new JPanel();
            pressPanel.setLayout(null);
            pressPanel.setBounds(20, 20, 180, 90);
            pressPanel.setBackground(new Color(184, 143, 143));
            mainPanel.add(pressPanel);

            spinPanel = new JPanel();
            spinPanel.setLayout(null);
            spinPanel.setBounds(250, 60, 200, 50);
            spinPanel.setBackground(new Color(151, 28, 153));
            mainPanel.add(spinPanel);

            // Добавление картинок
            setImages();
            // Добавление меток температуры
            addLabels();
            // Добавление текстовых полей режимов
            addButtons();

            // Добавление элементовна панель, фрейм
            mainPanel.add(tempLabel30);
            frame.add(windowMachine);

            // refresh frame
            frame.validate();
            frame.repaint();

            // Ожидание потока загрузки
            load.join();

            // Отображение фрейма
            frame.setVisible(true);

            // Добавление отработчика события нажатия клавиш
            ListenerButton clicker = new ListenerButton();
            frame.addKeyListener(clicker);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Добавление текстовых полей на панель
    public void addButtons() {
        Buttons but = new Buttons();
        mainPanel.add(but.btn1());
        mainPanel.add(but.btn2());
        mainPanel.add(but.btn3());
        mainPanel.add(but.btn4());
        pressPanel.add(but.pressMode());
        spinPanel.add(but.spinMode());
        mainPanel.add(but.weight());
    }

    // Добавление меток температуры
    public void addLabels() {
        Labels labels = new Labels();
        mainPanel.add(labels.l30());
        mainPanel.add(labels.l40());
        mainPanel.add(labels.l60());
        mainPanel.add(labels.l70());
        mainPanel.add(labels.temp());
        pressPanel.add(labels.press());
    }

    // Метод получения фрейма этого класса
    public JFrame getFrame() {
        return WashingMachine.frame;
    }

    // Процесс работы стиральной машины, оповещение, смена картинки окна
    public void working() {
        frame.remove(windowMachine);
        frame.add(windowMachine1);
        System.out.println("Стирка началась\nРежим стирки: " + ListenerButton.getMode() + "\nТемпература: "
                + ListenerButton.getTemp() + "\nКол-во отжимов: " + ListenerButton.getPress() + "\nКол-во оборотов: "
                + ListenerButton.getSpin() + "\nВес одежды составляет: " + ListenerButton.getWeight());
        frame.validate();
        frame.repaint();
    }

    // Остановка работы стиральной машины
    public void stopWorking() {
        frame.remove(windowMachine1);
        frame.add(windowMachine);
        System.out.println("Стирка закончилась");
        frame.validate();
        frame.repaint();
        ListenerButton.setOff();
    }

    // Отображение крутилки картинки о температуры
    public void setTemp(int set) {
        switch (set) {
            case 1:
                mainPanel.remove(tempLabel30);
                mainPanel.remove(tempLabel40);
                mainPanel.remove(tempLabel60);
                mainPanel.remove(tempLabel70);
                mainPanel.add(tempLabel30);
                System.out.println("Поставлено 30'");
                frame.validate();
                frame.repaint();
                break;
            case 2:
                mainPanel.remove(tempLabel30);
                mainPanel.remove(tempLabel40);
                mainPanel.remove(tempLabel60);
                mainPanel.remove(tempLabel70);
                mainPanel.add(tempLabel40);
                System.out.println("Поставлено 40'");
                frame.validate();
                frame.repaint();
                break;
            case 3:
                mainPanel.remove(tempLabel30);
                mainPanel.remove(tempLabel40);
                mainPanel.remove(tempLabel60);
                mainPanel.remove(tempLabel70);
                mainPanel.add(tempLabel60);
                System.out.println("Поставлено 60'");
                frame.validate();
                frame.repaint();
                break;
            case 4:
                mainPanel.remove(tempLabel30);
                mainPanel.remove(tempLabel40);
                mainPanel.remove(tempLabel60);
                mainPanel.remove(tempLabel70);
                mainPanel.add(tempLabel70);
                System.out.println("Поставлено 70'");
                frame.validate();
                frame.repaint();
                break;
            default:
                break;
        }
    }

    // Добавление картинок из /bin
    public void setImages() {
        ImageIcon setTemp70;
        ImageIcon setTemp60;
        ImageIcon setTemp40;
        ImageIcon setTemp30;
        ImageIcon image1;
        try {
            image = new ImageIcon(getClass().getResource("okno.png"));
            Image scalImage = image.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            image = new ImageIcon(scalImage);
            windowMachine = new JLabel(image);
            windowMachine.setBounds(90, 200, 400, 400);

            image1 = new ImageIcon(getClass().getResource("work okno.png"));
            Image scalImage1 = image1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            image1 = new ImageIcon(scalImage1);
            windowMachine1 = new JLabel(image1);
            windowMachine1.setBounds(90, 200, 400, 400);

            setTemp30 = new ImageIcon(getClass().getResource("temp30.png"));
            tempLabel30 = new JLabel(setTemp30);
            tempLabel30.setBounds(500, 50, 50, 50);

            setTemp40 = new ImageIcon(getClass().getResource("temp40.png"));
            tempLabel40 = new JLabel(setTemp40);
            tempLabel40.setBounds(500, 50, 50, 50);

            setTemp60 = new ImageIcon(getClass().getResource("temp60.png"));
            tempLabel60 = new JLabel(setTemp60);
            tempLabel60.setBounds(500, 50, 50, 50);

            setTemp70 = new ImageIcon(getClass().getResource("temp70.png"));
            tempLabel70 = new JLabel(setTemp70);
            tempLabel70.setBounds(500, 50, 50, 50);

            Image img = Toolkit.getDefaultToolkit().getImage("bin\\iconic.jpg");
            frame.setIconImage(img);
        } catch (Exception e) {
            System.err.println("Картинка не найдена");
        }

    }
}
