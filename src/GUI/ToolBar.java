package GUI;

import Listener.ToolBarListener;
import Model.*;
import Model.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import static java.awt.Color.BLACK;

public class ToolBar extends JToolBar implements ActionListener
{
    private JButton firstCategory;
    private JButton secondCategory;
    private JButton thirdCategory;
    private JButton fourthCategory;

    public ToolBarListener toolBarListener;

    public ToolBar(String nume1, String nume2, String nume3, String nume4)
    {
        setBorder(null);

        firstCategory = new JButton(nume1);
        secondCategory = new JButton(nume2);
        thirdCategory= new JButton(nume3);
        fourthCategory = new JButton(nume4);


        firstCategory.setBorderPainted(false);
        secondCategory.setBorderPainted(false);
        thirdCategory.setBorderPainted(false);
        fourthCategory.setBorderPainted(false);

        firstCategory.setBackground(new Color(160,97,9));
        secondCategory.setBackground(new Color(160,97,9));
        thirdCategory.setBackground(new Color(160,97,9));
        fourthCategory.setBackground(new Color(160,97,9));

        firstCategory.setForeground(new Color(196,206,211));
        secondCategory.setForeground(new Color(196,206,211));
        thirdCategory.setForeground(new Color(196,206,211));
        fourthCategory.setForeground(new Color(196,206,211));

/*
        firstCategory.setBackground(new Color(214,214,205));
        secondCategory.setBackground(new Color(214,214,205));
        thirdCategory.setBackground(new Color(214,214,205));
        fourthCategory.setBackground(new Color(214,214,205));*/

        firstCategory.addActionListener(this);
        secondCategory.addActionListener(this);
        thirdCategory.addActionListener(this);
        fourthCategory.addActionListener(this);

        setFloatable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0; // Make all buttons equally expandable
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.insets = new Insets(0, 0, 0, 0); // No extra space between buttons

        add(firstCategory, gbc);
        add(secondCategory, gbc);
        add(thirdCategory, gbc);
        add(fourthCategory, gbc);
        setBackground(new Color(214,214,205));

    }

    public void setFirstCategory(String nume)
    {
        firstCategory.setText(nume);
    }

    public void setSecondCategory(String nume)
    {
        secondCategory.setText(nume);
    }

    public void setThirdCategory(String nume)
    {
        thirdCategory.setText(nume);
    }

    public void setFourthCategory(String nume)
    {
        fourthCategory.setText(nume);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == firstCategory)
        {
            if(toolBarListener != null)
            {
//                List<String> sir = new ArrayList<String>();
//                sir.add("Lungime");
//                sir.add("Suprafata");
//                sir.add("Greutate");
//                sir.add("Volum");

                Map<String, List<String>> valori = new LinkedHashMap<String , List<String>>();

                valori.put("Greutate", new Greutate().returnareSirDenumiri());
                valori.put("Lungime", new Lungime().returnareSirDenumiri());
                valori.put("Suprafata", new Suprafata().returnareSirDenumiri());
                valori.put("Volum", new Volum().returnareSirDenumiri());
                toolBarListener.setMiniToolBars(valori);
            }
        }
        //////////////////// TO DO LATER /////////////////////////////

        else if(e.getSource() == secondCategory)
        {
            Map<String, List<String>> valori = new LinkedHashMap<String , List<String>>();
            valori.put("Temperatura", new Temperatura().returnareSirDenumiri());
            valori.put("Moneda", new Moneda().returnareSirDenumiri());
            valori.put("Timp", new Timp().returnareSirDenumiri());
            valori.put("Viteza", new Viteza().returnareSirDenumiri());
            toolBarListener.setMiniToolBars(valori);
        }

        else if(e.getSource() == thirdCategory)
        {
            Map<String, List<String>> valori = new LinkedHashMap<String , List<String>>();
            valori.put("Presiune", new Presiune().returnareSirDenumiri());
            valori.put("Forta", new Forta().returnareSirDenumiri());
            valori.put("Energie", new Energie().returnareSirDenumiri());
            valori.put("Putere", new Putere().returnareSirDenumiri());
            toolBarListener.setMiniToolBars(valori);
        }
        else {
            Map<String, List<String>> valori = new LinkedHashMap<String , List<String>>();
            valori.put("Unghi", new Unghi().returnareSirDenumiri());
            valori.put("Date", new Date().returnareSirDenumiri());
            valori.put("Combustibil", new Combustibil().returnareSirDenumiri());
            valori.put("Gatit", new Gatit().returnareSirDenumiri());
            toolBarListener.setMiniToolBars(valori);
        }
    }

    public void setToolBarListener(ToolBarListener toolBarListener)
    {
        this.toolBarListener = toolBarListener;
    }

    public void init()
    {
        firstCategory.doClick();
    }


}
