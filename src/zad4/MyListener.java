package zad4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by majki on 27.04.2016.
 */
public class MyListener implements ActionListener {

    private JComponent comp;
    private int rozmiarFonta;
    private String which;

    public MyListener(JComponent c) {
        comp = c;
    }

    // konstruktor dla Fonta
    public MyListener(JComponent c, int rozmF) {

        comp = c;
        rozmiarFonta = rozmF;
    }

    // konstruktor dla Fore i Background

    public MyListener(JComponent c, String which) {

        comp = c;
        this.which = which;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JComponent src = (JComponent) e.getSource();
        JTextArea textArea = (JTextArea) comp;

        // je�li przekazali�my wielko�c czcionki
        if (rozmiarFonta != 0) {
           // int rozmiar = (int) src.getClientProperty("Rozmiar");
            Font font = textArea.getFont();
            font = new Font(font.getName(), font.getStyle(), rozmiarFonta);
            textArea.setFont(font);
            return;
        }
        // przekazali�my hint, �e foreground
        if (which == null) {
            String adres = (String) src.getClientProperty("Adres");
            textArea.append(adres);
            return;
        }
        if (which.equals("for")){
            Color col = (Color) src.getClientProperty("Kolor");
            textArea.setForeground(col);
            return;
        }
        // przekazali�my hint, �e background
        if (which.equals("back")){
            Color col = (Color) src.getClientProperty("Kolor");
            textArea.setBackground(col);
        }

        // je�li nie przekazali�my czcionki ani koloru


        //
    }
}
