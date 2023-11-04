import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WashingMachine implements Runnable {

    static LoadP lp;
    public static JFrame frame;
    private JPanel mainPanel;
    private static JLabel windowMachine;
    private static JLabel windowMachine1;
    private ImageIcon image;
    private ImageIcon image1;
    private boolean loading = true;
    private static String str;

    public void run() {
        try {
            Thread.sleep(10);
            lp = new LoadP();

            Thread load = new Thread(lp);

            load.start();

            frame = new JFrame();
            frame.setLayout(null);
            frame.getContentPane().setBackground(java.awt.Color.GRAY);
            frame.setBounds(350, 10, 600, 650);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setTitle("Стиральная машина \"Оптимус Прайм v1.0.0\"");

            mainPanel = new JPanel();
            mainPanel.setLayout(null);
            mainPanel.setBounds(0, 0, 600, 180);
            mainPanel.setBackground(Color.LIGHT_GRAY);
            frame.add(mainPanel);

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

                Image img = Toolkit.getDefaultToolkit().getImage("bin\\iconic.jpg");
                frame.setIconImage(img);
            } catch (Exception e) {
                System.err.println("Картинка не найдена");
            }

            frame.add(windowMachine);

            addButtons();

            frame.validate();
            frame.repaint();

            load.join();

            frame.setVisible(true);

            ListenerButton clicker = new ListenerButton();
            frame.addKeyListener(clicker);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void addButtons() {
        Buttons but = new Buttons();
        Component comp1 = but.btn1();
        Component comp2 = but.btn2();
        Component comp3 = but.btn3();
        Component comp4 = but.btn4();
        mainPanel.add(comp1);
        mainPanel.add(comp2);
        mainPanel.add(comp3);
        mainPanel.add(comp4);

    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void working() {
        frame.remove(windowMachine);
        frame.add(windowMachine1);
        System.out.println("Стирка началась!");
        frame.validate();
        frame.repaint();
    }

    public void stopWorking() {
        frame.remove(windowMachine1);
        frame.add(windowMachine);
        System.out.println("Стирка закончилась");
        frame.validate();
        frame.repaint();
    }

}
