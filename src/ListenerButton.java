import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ListenerButton extends WashingMachine implements KeyListener {

    private int controlTemp = 1;

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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            working();
            Timer tm = new Timer();
            Thread th = new Thread(tm);
            th.start();
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if ((controlTemp > 0) && (controlTemp < 4)) {
                    controlTemp++;
                    System.out.print("Вы нажали вверх: ");
                    setTemp(controlTemp);
                }
                break;

            case KeyEvent.VK_DOWN:
                if ((controlTemp > 1) && (controlTemp < 5)) {
                    controlTemp--;
                    System.out.print("Вы нажали вниз: ");
                    setTemp(controlTemp);
                }
                break;
            case KeyEvent.VK_LEFT:

                break;
            case KeyEvent.VK_RIGHT:

                break;
            default:
                break;
        }
    }

}
