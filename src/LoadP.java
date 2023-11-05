import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

// Класс поток, для загрузки
public class LoadP implements Runnable {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();
    JPanel p7 = new JPanel();
    JPanel p8 = new JPanel();
    JPanel p9 = new JPanel();
    JPanel p10 = new JPanel();
    JPanel p11 = new JPanel();

    public void run() {
        JFrame load;
        try {

            LoadP lp = new LoadP();
            load = new JFrame();
            load.setLayout(null);
            load.getContentPane().setBackground(java.awt.Color.WHITE);
            load.setBounds(350, 10, 400, 80);
            load.setResizable(false);
            load.setTitle("Загрузка");
            setPanel();
            load.getContentPane().add(p1);
            load.setVisible(true);
            ;
            Thread.sleep(100);
            load.getContentPane().add(p2);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p3);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p4);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p5);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p6);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p7);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p8);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p9);
            load.validate();
            load.repaint();
            Thread.sleep(100);
            load.getContentPane().add(p10);
            load.validate();
            load.repaint();
            // JOptionPane.showMessageDialog(load,
            // "Загрузка завершена",
            // null, JOptionPane.PLAIN_MESSAGE);
            Thread.sleep(100);
            load.setVisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPanel() {
        p1.setBounds(0, 0, 40, 80);
        p1.setBackground(Color.GREEN);
        p2.setBounds(40, 0, 60, 80);
        p2.setBackground(Color.GREEN);
        p3.setBounds(60, 0, 80, 80);
        p3.setBackground(Color.GREEN);
        p4.setBounds(80, 0, 100, 80);
        p4.setBackground(Color.GREEN);
        p5.setBounds(100, 0, 120, 80);
        p5.setBackground(Color.GREEN);
        p6.setBounds(120, 0, 140, 80);
        p6.setBackground(Color.GREEN);
        p7.setBounds(140, 0, 160, 80);
        p7.setBackground(Color.GREEN);
        p8.setBounds(160, 0, 180, 80);
        p8.setBackground(Color.GREEN);
        p9.setBounds(180, 0, 200, 80);
        p9.setBackground(Color.GREEN);
        p10.setBounds(200, 0, 220, 80);
        p10.setBackground(Color.GREEN);
        p11.setBounds(220, 0, 240, 80);
        p11.setBackground(Color.GREEN);
    }
}
