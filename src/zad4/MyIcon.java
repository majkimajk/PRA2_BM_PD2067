package zad4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by jedzu_000 on 2016-04-28.
 */
public class MyIcon implements Icon {


    public MyIcon() {

    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        MyMenuItem mi = (MyMenuItem) c;
        Color kolorIkony =  (Color) mi.getClientProperty("Kolor");
        g.setColor(kolorIkony);
        g.fillOval(5, 5, 10, 10);

    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }
}
