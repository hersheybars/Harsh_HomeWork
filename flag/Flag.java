

import java.awt.*;
import javax.swing.*;

public class Flag extends JApplet {

    @Override
    public void init() {

        setSize(955, 500);
        getContentPane().add(new AmericanFlag(950, 500), BorderLayout.CENTER);
    }
}