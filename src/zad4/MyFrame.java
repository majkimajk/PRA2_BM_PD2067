package zad4;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Created by jedzu_000 on 2016-04-28.
 */
public class MyFrame extends JFrame {

    private final JTextArea textArea = new JTextArea(35, 70);

    final private String TITLE = "MyEditor 1.0 - ";
    private String pathFile = "bez tytułu";
    private String recentFolder = null;

    public MyFrame() {

        setTitle(TITLE + pathFile);

        //dodaję scroll do textArea

        JScrollPane scroll = new JScrollPane(textArea);


        // menu File i jego komponenty
        JMenu menuFile = new JMenu("File");


        JMenuItem open = new MyMenuItem("Open", 'o', "control O");
        JMenuItem save = new MyMenuItem("Save", 's', "control S");
        JMenuItem saveAs = new MyMenuItem("Save As ...", 'a', "control A");
        JMenuItem exit = new MyMenuItem("Exit", 'x', "control X");


        // akcja open z jednoczesną zmianą tytułu frame'a
        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (recentFolder == null) {
                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
            } else {
                fc.setCurrentDirectory(new File(recentFolder));
            }
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                // int i = fc.showOpenDialog(this);
                File wybranyPlik = fc.getSelectedFile();
               /* if (wybranyPlik == null) {
                    return;
                }*/
                try {
                    FileReader fr = new FileReader(wybranyPlik);
                    BufferedReader br = new BufferedReader(fr);
                    textArea.read(br, null);

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                setTitle(TITLE + wybranyPlik.toString());
                pathFile = wybranyPlik.getAbsolutePath();
                recentFolder = pathFile.substring(0, pathFile.lastIndexOf(File.separator));
            }
        });


        //akcja save
        save.addActionListener(e -> {
            if (!pathFile.equals("bez tytułu")) {
                File plikIstniejacy = new File(pathFile);
                try {
                    PrintWriter pw = new PrintWriter(plikIstniejacy);
                    String texToWrite = textArea.getText();
                    pw.write(texToWrite);
                    pw.flush();
                    pw.close();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            else {
                JFileChooser fc = new JFileChooser();
                if (recentFolder == null) {
                    fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                } else {
                    fc.setCurrentDirectory(new File(recentFolder));
                }
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                    File nowyPlik = fc.getSelectedFile();
                    try {
                        PrintWriter pw = new PrintWriter(nowyPlik);
                        String texToWrite = textArea.getText();
                        pw.write(texToWrite);
                        pw.flush();
                        pw.close();
                        setTitle(TITLE + nowyPlik.toString());
                        pathFile = nowyPlik.getAbsolutePath();

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        // akcja save as
        saveAs.addActionListener(e -> {

            JFileChooser fc = new JFileChooser();
            if (recentFolder == null) {
                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
            } else {
                fc.setCurrentDirectory(new File(recentFolder));
            }
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                File nowyPlik = fc.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(nowyPlik);
                    String texToWrite = textArea.getText();
                    pw.write(texToWrite);
                    pw.flush();
                    pw.close();
                    setTitle(TITLE + nowyPlik.toString());
                    pathFile = nowyPlik.getAbsolutePath();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }

        });
        //akcja exit

        exit.addActionListener(e -> System.exit(0));

        // Separator
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setMinimumSize(new

                        Dimension(300, 300)

        );
        sep.setBackground(Color.RED);


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
        praca.addActionListener(new

                        MyListener(textArea)

        );
        szkola.addActionListener(new

                        MyListener(textArea)

        );
        dom.addActionListener(new

                        MyListener(textArea)

        );

        adresy.add(praca);
        adresy.add(szkola);
        adresy.add(dom);
        menuEdit.add(adresy);


        //menu Options i jego komponenty
        JMenu menuOptions = new JMenu("Options");

        String[] kolory = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};

        JMenu foreground = new MyMenu("Foreground");
        for (
                int k = 0;
                k < kolory.length; k++)

        {
            JMenuItem kolorFor = new MyMenuItem(kolory[k], new MyIcon(), kolory[k]);
            kolorFor.addActionListener(new MyListener(textArea, "for"));
            foreground.add(kolorFor);
        }

        JMenu background = new MyMenu("Background");
        for (
                int k = 0;
                k < kolory.length; k++)

        {
            JMenuItem kolorBack = new MyMenuItem(kolory[k], new MyIcon(), kolory[k]);
            kolorBack.addActionListener(new MyListener(textArea, "back"));
            background.add(kolorBack);
        }


        JMenu font = new MyMenu("Font");
        for (
                int f = 8;
                f < 26; f += 2)

        {
            JMenuItem rozmiarFonta = new MyMenuItem(Integer.toString(f) + " pts", f);
            rozmiarFonta.addActionListener(new MyListener(textArea, f));
            font.add(rozmiarFonta);
        }

        menuOptions.add(foreground);
        menuOptions.add(background);
        menuOptions.add(font);


        // menuBar i dodawanie wszystkich menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new

                        Dimension(10, 20)

        );
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuOptions);


        //tworzę JFrame + BorderLayout
        // JFrame frame = new JFrame();
        getContentPane()

                .

                        setLayout(new BorderLayout()

                        );


        //dodaję menu

        add(menuBar, BorderLayout.NORTH);

        //dodaję textArea

        add(scroll, BorderLayout.CENTER);

        //pakuję Jframe
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

}
