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

    public MyListener(JComponent c) {
        comp = c;
    }

    // konstruktor dla Fonta
    public MyListener(JComponent c, int rozmF) {

        comp = c;
        rozmiarFonta = rozmF;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JTextArea textArea = (JTextArea) comp;
        JComponent src = (JComponent) e.getSource();

        // jeœli przekazaliœmy wielkoœc czcionki
        if (rozmiarFonta != 0) {
            int rozmiar = (int) src.getClientProperty("Rozmiar");
            Font font = textArea.getFont();
            font = new Font(font.getName(), font.getStyle(), rozmiar);
            textArea.setFont(font);



        }// jeœli nie przekazaliœmy czcionki
        else {
            String adres = (String) src.getClientProperty("Adres");
            textArea.append(adres);
        }

        //
    }
}
