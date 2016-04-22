/**
 * @author Baran Michał PD2067
 */

package zad1;


import javax.swing.*;
import java.awt.*;
import static javax.swing.SwingConstants.*;

public class Main{

    final int NUMOFET = 5;


    Color backCol[] = { new Color(191, 225, 255), new Color(255, 255, 200),
            new Color(201, 245, 245), new Color(255, 255, 140),
            new Color(161, 224, 224), new Color(255, 255, 200), };
    Color fontCol[] = { new Color(191, 225, 255), new Color(255, 255, 200),
            new Color(201, 245, 245), new Color(255, 255, 140),
            new Color(161, 224, 224), new Color(255, 255, 200), };
  /*  String[] backCol = {"BLACK","RED","YELLOW","BLUE","GREEN"};
    String[] fontCol = {"RED","YELLOW","BLACK","GREEN","BLUE"};*/
  String place[] = { "West", "North", "East", "South", "Center" };
    int[] fontSize = {12, 21, 10, 8, 30, 14};
    String[] texts = {"Jeden","Dwa","Trzy","Cztery","Pięć"};
    String[] tips = {"One","Two","Three","Four","Five"};


    Main() {

        JFrame f = new JFrame("Etykiety");
        f.setLayout(new BorderLayout());

        for (int i = 0; i < NUMOFET; i++) {

            JLabel l = new JLabel();
           // l.setBackground(backCol[i]);
            l.setFont(new Font("aaa", Font.ITALIC, 30));
            l.setText(texts[i]);
            l.setToolTipText(tips[i]);
            l.setBorder(BorderFactory.createLineBorder(Color.BLUE));
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