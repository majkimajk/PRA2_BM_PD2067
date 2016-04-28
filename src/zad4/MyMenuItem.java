package zad4;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

/**
 * Created by jedzu_000 on 2016-04-27.
 */
public class MyMenuItem extends JMenuItem {

    private Color kolor;

    //// konstruktor dla menuItem w File
    public MyMenuItem(String text) {
        super(text);
    }


    //// kontruktor dla menuItem w File
    public MyMenuItem(String text, int mnemo, String accel) {
        super(text);
        setMnemonic(mnemo);
        setAccelerator(KeyStroke.getKeyStroke(accel));
        setOpaque(true);
        setBorder(BorderFactory.createRaisedBevelBorder());
    }

    //// kontruktor dla menuItem w Adresach
    public MyMenuItem(String text, int mnemo, String accel, String klucz) {
        super(text);
        setMnemonic(mnemo);
        setAccelerator(KeyStroke.getKeyStroke(accel));
        setOpaque(true);
        setBorder(BorderFactory.createRaisedBevelBorder());
        putClientProperty("Adres", klucz);
    }

    //// konstruktor dla menuItem w Font
    public MyMenuItem(String text, int rozmiar) {

        super(text);
        setOpaque(true);
        setBorder(BorderFactory.createRaisedBevelBorder());
        putClientProperty("Rozmiar", rozmiar);

    }

    //// konstruktor dla menuItem w Fore i Background
    public MyMenuItem(String text, MyIcon icon, String nazwaKoloru) {

        super(text, icon);
        setIconTextGap(20);

        setOpaque(true);
        setBorder(BorderFactory.createRaisedBevelBorder());
        //String do koloru

        try {
           Field field = Class.forName("java.awt.Color").getField(nazwaKoloru.toLowerCase());
            kolor = (Color) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //rysujemy ikonę

            putClientProperty("Kolor", kolor);
    }


}




