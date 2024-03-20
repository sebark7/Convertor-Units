package GUI;

import Listener.ToolBarListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input extends JPanel
{
    private final ToolBar unitati;
    //    private JTextField input;
    //    private JComboBox comboBox;
    private final Tabel tabel; //JPANEL

    public Input()
    {
        unitati = new ToolBar("De baza", "Zi de zi", "Diverse", "Stiintifice");
        tabel = new Tabel();
        setLayout(new BorderLayout());
        add(unitati, BorderLayout.NORTH);
        add(tabel, BorderLayout.CENTER);
        setBorder(null);
        unitati.setToolBarListener(new ToolBarListener()
        {
            @Override
            public void setMiniToolBars(Map<String, List<String>> valori)
            {
                tabel.setNumeToolBarSecundar(valori);
                tabel.setDefaultButton();
            }
        });
        unitati.init();
    }
}
