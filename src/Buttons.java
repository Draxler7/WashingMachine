import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

public class Buttons extends WashingMachine {

    // Текстовые поля панели "Выбор режима"
    static JTextField mode1 = new JTextField("Cмеш. ткани");
    static JTextField mode2 = new JTextField("Хлопок");
    static JTextField mode3 = new JTextField("Детская одежда");
    static JTextField mode4 = new JTextField("Быстрая стирка");

    public Buttons() {
        // Настройка текстовых полей
        mode1.setForeground(Color.BLACK);
        mode1.setBounds(20, 120, 100, 50);
        mode1.setHorizontalAlignment(0);
        mode1.setEnabled(false);
        mode1.setBackground(Color.DARK_GRAY);
        mode2.setBounds(140, 120, 100, 50);
        mode2.setHorizontalAlignment(0);
        mode2.setEnabled(false);
        mode2.setBackground(Color.DARK_GRAY);
        mode3.setBounds(260, 120, 100, 50);
        mode3.setHorizontalAlignment(0);
        mode3.setEnabled(false);
        mode3.setBackground(Color.DARK_GRAY);
        mode4.setBounds(380, 120, 100, 50);
        mode4.setHorizontalAlignment(0);
        mode4.setEnabled(false);
        mode4.setBackground(Color.DARK_GRAY);

    }

    // Получение текстовых полей для реализации
    public Component btn1() {
        return mode1;
    }

    public Component btn2() {
        return mode2;
    }

    public Component btn3() {
        return mode3;
    }

    public Component btn4() {
        return mode4;
    }

    // Методы активации режимов
    public void set1() {
        activemode(mode1, mode2, mode3, mode4);
    }

    public void set2() {
        activemode(mode2, mode1, mode3, mode4);
    }

    public void set3() {
        activemode(mode3, mode2, mode1, mode4);
    }

    public void set4() {
        activemode(mode4, mode2, mode3, mode1);
    }

    // Изменение цветов режимов, активный - зеленый : неактивный - серый
    public void activemode(JTextField b1, JTextField b2, JTextField b3, JTextField b4) {
        b1.setBackground(new Color(163, 255, 189));
        b1.setDisabledTextColor(Color.BLACK);
        b2.setBackground(Color.DARK_GRAY);
        b2.setDisabledTextColor(Color.WHITE);
        b3.setBackground(Color.DARK_GRAY);
        b3.setDisabledTextColor(Color.WHITE);
        b4.setBackground(Color.DARK_GRAY);
        b4.setDisabledTextColor(Color.WHITE);
    }
}
