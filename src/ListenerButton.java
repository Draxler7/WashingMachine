import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Обработчик нажатия кнопок клавиатуры
public class ListenerButton extends WashingMachine implements KeyListener {

    // Числа обозначения режима и температуры стирки
    private static int controlTemp = 1;
    private static int controlMode = 0;
    private static int controlPress = 0;
    // Процесс работы протекает или нет
    private static boolean working = false;
    Buttons but = new Buttons();

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO document why this method is empty
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Получение значения нажатой клавиши
        char press = e.getKeyChar();
        // Если процесс работы не протекает
        if (working == false) {
            // Определение нажатой кнопки
            switch (press) {
                case 'q': {
                    // Вывод о смене режима, активирование текстового поля с выбранным режимом
                    System.out.println("Вы нажали: " + e.getKeyChar() + " - Режим работы: выбрано \"Смешанная ткань\"");
                    controlMode = 1;
                    but.set1();
                    JFrame frm = getFrame();
                    frm.validate();
                    frm.repaint();
                    break;
                }
                case 'w': {
                    // Вывод о смене режима, активирование текстового поля с выбранным режимом
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
                    // Вывод о смене режима, активирование текстового поля с выбранным режимом
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
                    // Вывод о смене режима, активирование текстового поля с выбранным режимом
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

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Определение что нажат ЕНТЕР
        // Определение нажатия стрелочек клавиши клавиатуры
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:

                but.activemode("1");
                break;
            case KeyEvent.VK_2:
                but.activemode("2");
                break;
            case KeyEvent.VK_3:
                but.activemode("3");
                break;
            case KeyEvent.VK_ENTER:
                // Если режим мойки не выбран, то процесс запуска не включается
                // Запуск процесса мойки и создание нового потока таймера(определяющий время
                // работы)
                if (controlMode != 0) {
                    working();
                    Timer tm = new Timer();
                    Thread th = new Thread(tm);
                    th.start();
                    working = true;
                } else {
                    System.out.println("Выберите режим мойки");
                    JOptionPane.showOptionDialog(null, "Выберите для начала режим мойки", null, 0, 0, null, null, e);
                }
                break;

            // Если нажата стрелка вверх то температура подымается
            case KeyEvent.VK_UP:
                if ((controlTemp > 0) && (controlTemp < 4) && (working == false)) {
                    controlTemp++;
                    System.out.print("Вы нажали вверх: ");
                    setTemp(controlTemp);
                }
                break;

            // Если нажата стрелка вниз то температура опускается
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

    // Метод отключения процесса мойки
    public static void setOff() {
        working = false;
    }

    // Получения значения о выбранном режиме
    public static String getMode() {
        switch (controlMode) {
            case 1: {
                return "Смешанная ткань";
            }
            case 2: {
                return "Хлопок";
            }
            case 3: {
                return "Детская стирка";
            }
            case 4: {
                return "Быстрая стирка";
            }
            default: {
                return "Error";
            }
        }
    }

    // Получения значения о выбранной температуре
    public static String getTemp() {
        switch (controlTemp) {
            case 1: {
                return "30'";
            }
            case 2: {
                return "40'";
            }
            case 3: {
                return "60'";
            }
            case 4: {
                return "70'";
            }
            default: {
                return "Error";
            }
        }
    }
}
