import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WashingMachine implements Runnable {

    static LoadP lp;
    public static JFrame frame;
    private static JPanel mainPanel;
    private static JLabel windowMachine;
    private static JLabel windowMachine1;
    private static JLabel tempLabel30;
    private static JLabel tempLabel40;
    private static JLabel tempLabel60;
    private static JLabel tempLabel70;
    private ImageIcon image;
    private ImageIcon image1;
    private ImageIcon setTemp30;
    private ImageIcon setTemp40;
    private ImageIcon setTemp60;
    private ImageIcon setTemp70;
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

            setImages();
            addButtons();
            addLabels();

            mainPanel.add(tempLabel30);
            frame.add(windowMachine);

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

    public void addLabels() {
        Labels tempLabels = new Labels();
        mainPanel.add(tempLabels.l30());
        mainPanel.add(tempLabels.l40());
        mainPanel.add(tempLabels.l60());
        mainPanel.add(tempLabels.l70());
        mainPanel.add(tempLabels.temp());
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
        ListenerButton.setOff();
    }

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

    public void setImages() {
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
