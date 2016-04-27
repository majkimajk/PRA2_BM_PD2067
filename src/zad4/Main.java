/**
 * @author Baran Michał PD2067
 */

package zad4;


import javax.swing.*;
import java.awt.*;

public class Main {

    public Main() {



        //tworzę textArea ze scrollem
        JTextArea textArea = new JTextArea(35, 70);
        JScrollPane scroll = new JScrollPane(textArea);

        // menu File i jego komponenty

        JMenu menuFile = new JMenu("File");

        MyMenuItem open = new MyMenuItem("Open", 'o', "control O");
        MyMenuItem save = new MyMenuItem("Save", 's', "control S");
        MyMenuItem saveAs = new MyMenuItem("Save As ...", 'a', "control A");
        MyMenuItem exit = new MyMenuItem("Exit", 'x', "control X");

        // Separator
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setMinimumSize(new Dimension(300, 300));
        sep.setBackground(Color.RED);
        menuFile.add(sep);

        //dodawanie elementów do menu File
        menuFile.add(open);
        menuFile.add(save);
        menuFile.add(saveAs);
        menuFile.add(sep);
        menuFile.add(exit);

        //menu Edit i jego komponenty

        JMenu menuEdit = new JMenu("Edit");
        MyMenu adresy = new MyMenu("Adresy");

        MyMenuItem praca = new MyMenuItem("Praca", 'p', "control shift P");
        MyMenuItem szkola = new MyMenuItem("Szkoła", 's', "control shift S");
        MyMenuItem dom = new MyMenuItem("Dom", 'd', "control shift D");
        adresy.add(praca);
        adresy.add(szkola);
        adresy.add(dom);
        menuEdit.add(adresy);

        //menu Options i jego komponenty
        JMenu menuOptions = new JMenu("Options");



        // menuBar i dodawanie wszytkich menu menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(10, 20));
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuOptions);



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