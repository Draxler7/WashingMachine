import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Random;

import javax.swing.JTextField;

public class Buttons extends WashingMachine {

    // Текстовые поля панели "Выбор режима"
    static JTextField mode1 = new JTextField("Cмеш. ткани");
    static JTextField mode2 = new JTextField("Хлопок");
    static JTextField mode3 = new JTextField("Детская одежда");
    static JTextField mode4 = new JTextField("Быстрая стирка");
    static JTextField pressMode = new JTextField("");
    static JTextField spinMode = new JTextField("");
    static JTextField weight = new JTextField("");
    private Random random = new Random();

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
        pressMode.setBounds(130, 50, 24, 25);
        pressMode.setFont(new Font(null, 0, 20));
        pressMode.setBackground(new Color(143, 23, 23));
        pressMode.setEnabled(false);
        pressMode.setHorizontalAlignment(0);
        spinMode.setBounds(10, 10, 180, 30);
        spinMode.setFont(new Font(null, 0, 20));
        spinMode.setBackground(new Color(250, 180, 214));
        spinMode.setEnabled(false);
        spinMode.setHorizontalAlignment(0);
        spinMode.setDisabledTextColor(new Color(7, 140, 11));

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

    public Component pressMode() {
        return pressMode;
    }

    public Component spinMode() {
        return spinMode;
    }

    public String getWeight() {
        return weight.getText();
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

    public void activemode(String i) {
        pressMode.setText(i);
        switch (i) {
            case "1":
                pressMode.setDisabledTextColor(Color.pink);
                break;

            case "2":
                pressMode.setDisabledTextColor(Color.CYAN);
                break;
            case "3":
                pressMode.setDisabledTextColor(Color.ORANGE);
                break;
            default:
                break;
        }
    }

    public void setSpin(int controlSpin) {
        switch (controlSpin) {
            case 1:
                spinMode.setText("400 оборотов");
                break;
            case 2:
                spinMode.setText("600 оборотов");
                break;
            case 3:
                spinMode.setText("800 оборотов");
                break;
            case 4:
                spinMode.setText("1000 оборотов");
                break;
            default:
                break;
        }
    }

    public JTextField weight() {
        int randomNumber = random.nextInt(9) + 1;
        weight.setText("Вес набранной ткани составляет: " + randomNumber + " кг");
        weight.setFont(new Font("Segor UI", Font.BOLD, 10));
        weight.setBounds(250, 10, 200, 30);
        weight.setEnabled(false);
        weight.setDisabledTextColor(new Color(0, 0, 0));
        weight.setBackground(new Color(189, 194, 155));
        weight.setHorizontalAlignment(0);
        return weight;
    }
}
