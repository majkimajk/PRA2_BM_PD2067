package zad4;

import javax.swing.*;
import java.awt.*;


public class MyMenu extends JMenu {

    public MyMenu(String text) {

        super(text);
        setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public MyMenu(String text, int mnemo, String accel) {
        super(text);
        setMnemonic(mnemo);
        setAccelerator(KeyStroke.getKeyStroke(accel));
        setBorder(BorderFactory.createRaisedBevelBorder());
        setOpaque(true);
    }


}
