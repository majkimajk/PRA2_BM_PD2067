package zad4;

import javax.swing.*;

/**
 * Created by jedzu_000 on 2016-04-27.
 */
public class MyMenuItem extends JMenuItem {

    private JMenuItem mi;
    private String text;
    private int mnemo;
    private Icon i;
    private String accel;

//// konstruktor dla menuItem w File
    public MyMenuItem(String text) {
        super(text);
    }



//// kontruktor dla menuItem w Adresach
    public MyMenuItem (String text, int mnemo, String accel) {
        super(text);
        setMnemonic(mnemo);
        setAccelerator(KeyStroke.getKeyStroke(accel));
        setOpaque(true);
        setBorder(BorderFactory.createRaisedBevelBorder());
    }
}




