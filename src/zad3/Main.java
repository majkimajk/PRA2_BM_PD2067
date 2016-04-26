/**
 * @author Baran Michał PD2067
 */

package zad3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class Main {

    Color[] colors = {
            Color.MAGENTA,
            Color.RED,
            Color.GREEN,
            Color.CYAN,
            Color.ORANGE
    };

    int licznik = 0;


    public Main() {

        JButton b = new JButton();
        b.setPreferredSize(new Dimension(700, 700));


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                b.setBackground(colors[licznik]);
                licznik++;

                if (licznik == colors.length) {
                    licznik = 0;
                }
                ;
            }

        });

        JFrame f = new JFrame();
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();

    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });

    }

}