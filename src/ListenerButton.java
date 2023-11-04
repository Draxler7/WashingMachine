import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ListenerButton extends WashingMachine implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO document why this method is empty
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char press = e.getKeyChar();
        switch (press) {
            case 'q': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Смешанная ткань\"");
                Buttons but = new Buttons();
                but.set1();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }
            case 'w': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Хлопок\"");
                Buttons but = new Buttons();
                but.set2();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }
            case 'e': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Детская стирка\"");
                Buttons but = new Buttons();
                but.set3();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }
            case 'r': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Быстрая стирка\"");
                Buttons but = new Buttons();
                but.set4();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO document why this method is empty
        try {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                working();
                Timer tm = new Timer();
                Thread th = new Thread(tm);
                th.start();
                th.join();
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}
