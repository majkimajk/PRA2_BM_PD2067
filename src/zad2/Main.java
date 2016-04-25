/**
 * @author Baran Michał PD2067
 */

package zad2;


import javax.swing.*;
import java.awt.*;

public class Main {


    public Main() {


        JFrame f = new JFrame();
        GridBagLayout gridLay = new GridBagLayout();
        f.setLayout(gridLay);
        GridBagConstraints c = new GridBagConstraints();

        //Panel 1
        JPanel flow1 = new JPanel(new FlowLayout());

        flow1.add(new JButton("A1"));
        flow1.add(new JButton("A2"));
        flow1.add(new JButton("A2"));
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        f.add(flow1, c);

        //Panel 2
        JPanel flow2 = new JPanel(new FlowLayout());

        flow2.add(new JButton("B1"));
        flow2.add(new JButton("B2"));
        flow2.add(new JButton("B2"));
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_END;

        f.add(flow2, c);

        //JTextArea

        JScrollPane scroll = new JScrollPane(new JTextArea("To jest JTextArea", 30, 60));
        //c.fill = GridBagConstraints.BOTH;
       // c.weightx = 1;
        //c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.ipady = 50;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        f.add(scroll, c);

        // Numpad

        JPanel numPad = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            String nazwa = String.valueOf(i+1);
            numPad.add(new JButton(nazwa));
        }
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;

        f.add(numPad, c);


        // JTextFields

        JPanel textFields = new JPanel();
        textFields.setLayout(new BoxLayout(textFields, BoxLayout.Y_AXIS));
        for (int i = 0; i < 3; i++) {
            JTextField textF = new JTextField("To jest JTextField", 12);
            textF.setBorder(BorderFactory.createLineBorder(Color.RED));
            textFields.add(textF);
            textFields.add(Box.createRigidArea(new Dimension(10,10)));
        }

        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;

        f.add(textFields, c);



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