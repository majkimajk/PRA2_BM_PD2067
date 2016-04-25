/**
 * @author Baran Michał PD2067
 */

package zad1;




import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class Main {

    final int NUMOFET = 5;


    Color[] backCol = {Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.LIGHT_GRAY, Color.GREEN}; //Kolor tła
    Color[] fonCol = {Color.MAGENTA, Color.CYAN, Color.GREEN, Color.YELLOW, Color.LIGHT_GRAY}; //Kolor pisma
    Font[] fonts = {                                                                           // Rozmiary i rodzaje pisma
            (new Font("West", Font.BOLD, 18)),
            (new Font("North", Font.ITALIC, 34)),
            (new Font("East", Font.BOLD | Font.ITALIC, 23)),
            (new Font("South", Font.ROMAN_BASELINE | Font.ITALIC, 58)),
            (new Font("Center", Font.PLAIN, 44))
    };
    String place[] = {"West", "North", "East", "South", "Center"};      //rozmieszczenie etykiet
    String[] texts = {"West", "North", "East", "South", "Center"};      //teksty etykiet
    String[] tips = {"Zachód", "Północ", "Wschód", "Południe", "Centrum"}; //teksty podpowiedzi
    Border[] borders = {                                                   // ramki etykiet
            BorderFactory.createTitledBorder("West"),
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEtchedBorder(),
            BorderFactory.createMatteBorder(23,18,27,18, new ImageIcon("icon.gif"))
    };


    public Main() {

        JFrame f = new JFrame("Etykiety");
        f.getContentPane().setLayout(new BorderLayout());

        for (int i = 0; i < NUMOFET; i++) {

            JLabel l = new JLabel();
            l.setOpaque(true);
            l.setBackground(backCol[i]);
            l.setFont(fonts[i]);
            l.setForeground(fonCol[i]);
            l.setText(texts[i]);
            l.setToolTipText(tips[i]);
            l.setBorder(borders[i]);
            f.add(l, place[i]);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);


        }


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });

    }
}