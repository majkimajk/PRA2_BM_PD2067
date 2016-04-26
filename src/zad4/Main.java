/**
 * @author Baran Michał PD2067
 */

package zad4;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main() {

        //tworzę textAre ze scrollem
        JTextArea textArea = new JTextArea(50, 100);
        JScrollPane scroll = new JScrollPane(textArea);

        //tworzę menu

        JMenu menuFile = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        menuFile.add(open);
        menuFile.add(save);

        JMenu menuEdit = new JMenu("Edit");
        JMenuItem adresy = new JMenu("Adresy");
        menuEdit.add(adresy);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(10, 20));
        menuBar.add(menuFile);
        menuBar.add(menuEdit);




        //tworzę JFrame + BorderLayout
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());


        //dodaję menu

        frame.add(menuBar, BorderLayout.NORTH);

        //dodaję textArea

        frame.add(scroll, BorderLayout.CENTER);

        //pakuję Jframe
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });


    }
}