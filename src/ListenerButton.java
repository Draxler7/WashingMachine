import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ListenerButton extends WashingMachine implements KeyListener {

    private int controlTemp = 1;
    private int controlMode = 0;
    private static boolean working = false;

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
                controlMode = 1;
                Buttons but = new Buttons();
                but.set1();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }
            case 'w': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Хлопок\"");
                controlMode = 2;
                Buttons but = new Buttons();
                but.set2();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }
            case 'e': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Детская стирка\"");
                controlMode = 3;
                Buttons but = new Buttons();
                but.set3();
                JFrame frm = getFrame();
                frm.validate();
                frm.repaint();
                break;
            }
            case 'r': {
                System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Быстрая стирка\"");
                controlMode = 4;
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
            working = true;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if ((controlTemp > 0) && (controlTemp < 4) && (working == false)) {
                    controlTemp++;
                    System.out.print("Вы нажали вверх: ");
                    setTemp(controlTemp);
                }
                break;

            case KeyEvent.VK_DOWN:
                if ((controlTemp > 1) && (controlTemp < 5) && (working == false)) {
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

    public static void setOff() {
        working = false;
    }

}
