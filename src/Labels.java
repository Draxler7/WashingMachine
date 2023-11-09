import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;

public class Labels extends WashingMachine {
    // Метки температуры
    JLabel t30 = new JLabel("30");
    JLabel t40 = new JLabel("40");
    JLabel t60 = new JLabel("60");
    JLabel t70 = new JLabel("70");
    JLabel temp = new JLabel("Температура:");

    JLabel press = new JLabel("<html>Количество<br>отжимов: </html>");

    public Labels() {
        // Определение расположения меток
        t30.setBounds(518, 33, 20, 20);
        t40.setBounds(551, 64, 20, 20);
        t60.setBounds(518, 97, 20, 20);
        t70.setBounds(485, 63, 20, 20);
        temp.setBounds(485, 13, 100, 20);
        press.setBounds(15, 15, 200, 55);
        press.setFont(new Font(null, 0, 25));
    }

    // Получения меток с этого класса для реализации вне
    public Component l30() {
        return t30;
    }

    public Component l40() {
        return t40;
    }

    public Component l60() {
        return t60;
    }

    public Component l70() {
        return t70;
    }

    public Component temp() {
        return temp;
    }

    public Component press() {
        return press;
    }

}
