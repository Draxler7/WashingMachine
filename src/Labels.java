import java.awt.Component;

import javax.swing.JLabel;

public class Labels extends WashingMachine {
    JLabel t30 = new JLabel("30");
    JLabel t40 = new JLabel("40");
    JLabel t60 = new JLabel("60");
    JLabel t70 = new JLabel("70");

    public Labels() {
        t30.setBounds(518, 33, 20, 20);
        t40.setBounds(551, 64, 20, 20);
        t60.setBounds(518, 97, 20, 20);
        t70.setBounds(485, 63, 20, 20);
    }

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
}
