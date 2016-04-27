/**
 * @author Baran Michał PD2067
 */

package zad4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public Main() {



        //tworzę textArea ze scrollem
        JTextArea textArea = new JTextArea(35, 70);
        JScrollPane scroll = new JScrollPane(textArea);

        // menu File i jego komponenty

        JMenu menuFile = new JMenu("File");

        JMenuItem open = new MyMenuItem("Open", 'o', "control O");
        JMenuItem save = new MyMenuItem("Save", 's', "control S");
        JMenuItem saveAs = new MyMenuItem("Save As ...", 'a', "control A");
        JMenuItem exit = new MyMenuItem("Exit", 'x', "control X");


        //akcja exit

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

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

        JMenuItem praca = new MyMenuItem("Praca", 'p', "control shift P", "adres pracy");
        JMenuItem szkola = new MyMenuItem("Szkoła", 's', "control shift S", "adres szkoly");
        JMenuItem dom = new MyMenuItem("Dom", 'd', "control shift D", "adres domu");

        // actionListenerzy do Adresów
        praca.addActionListener(new MyListener(textArea));
        szkola.addActionListener(new MyListener(textArea));
        dom.addActionListener(new MyListener(textArea));


       // szkola
        adresy.add(praca);
        adresy.add(szkola);
        adresy.add(dom);
        menuEdit.add(adresy);


        //menu Options i jego komponenty
        JMenu menuOptions = new JMenu("Options");

        JMenu font = new MyMenu("Font");
        for (int f = 8; f < 26; f+=2) {
            JMenuItem rozmiarFonta = new MyMenuItem(Integer.toString(f) + " pts", f);
            rozmiarFonta.setBorder(BorderFactory.createRaisedBevelBorder());
            rozmiarFonta.addActionListener(new MyListener(textArea, f));
            font.add(rozmiarFonta);
        }
        menuOptions.add(font);



        // menuBar i dodawanie wszystkich menu
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