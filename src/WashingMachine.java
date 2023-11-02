import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WashingMachine implements Runnable {

    private JFrame frame;
    private JPanel panel;
    private JPanel mainPanel;
    private JLabel windowMachine;
    private ImageIcon image;

    public void run() {
        try {
            Thread.sleep(1);
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

            panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(200, 0, 600, 395);
            panel.setBackground(java.awt.Color.GRAY);

            try {
                image = new ImageIcon(getClass().getResource("okno.png"));
                Image scalImage = image.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                image = new ImageIcon(scalImage);
                windowMachine = new JLabel(image);
                windowMachine.setBounds(90, 200, 400, 400);
                frame.add(windowMachine);
            } catch (Exception e) {
                System.err.println("Картинка не найдена");
            }

            // frame.getContentPane().add(panel);
            frame.show();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
