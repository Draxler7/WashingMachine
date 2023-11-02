import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

public class Buttons extends WashingMachine {

    static JTextField mode1 = new JTextField("Cмешанные ткани");
    static JTextField mode2 = new JTextField("Хлопок");
    static JTextField mode3 = new JTextField("Детская одежда");
    static JTextField mode4 = new JTextField("Быстрая стирка");

    public Buttons() {
        mode1.setBounds(20, 120, 100, 50);
        mode1.setHorizontalAlignment(0);
        mode1.setEnabled(true);
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

    public void activemode(JTextField mode12, JTextField mode22, JTextField mode32, JTextField mode42) {
        mode12.setBackground(new Color(163, 255, 189));
        mode22.setBackground(Color.DARK_GRAY);
        mode32.setBackground(Color.DARK_GRAY);
        mode42.setBackground(Color.DARK_GRAY);
    }
}
