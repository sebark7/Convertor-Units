package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame
{

    private Input input;

    public MainFrame()
    {

        super("Convertor Units");

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.gc();
            }
        });

        //toolBar = new ToolBar("De Baza", "Zi de zi", "Stiinta", "Diverse");
        input = new Input();
        setLayout(new BorderLayout());
        add(input, BorderLayout.CENTER);
        setMinimumSize(new Dimension(300,600));
        setSize(new Dimension(300,600));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocation(350,350);

    }
}
