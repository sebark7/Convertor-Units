import GUI.MainFrame;

import javax.swing.*;
import java.util.jar.JarEntry;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainFrame();
            }
        });
    }

}