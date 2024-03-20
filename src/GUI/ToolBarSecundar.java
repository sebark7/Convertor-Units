package GUI;

import Listener.ComboListener;
import Listener.InputListener;
import Listener.PreferencesListener;
import Listener.ToolBarSecundarListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ToolBarSecundar extends JToolBar implements ActionListener
{
    private JButton first;
    private JButton second;
    private JButton third;
    private JButton fourth;
    public ToolBarSecundarListener toolBarSecundarListener;
    public InputListener inputListener;
    public ComboListener comboListener;
    Map<String, List<String>> valoriSpecifice;
    public String unitateFolosita;
    private Color foregroundColor;
    private JPopupMenu popupMenu;
    private JMenuItem menuItem;
    public PreferencesListener preferencesListener;

    public ToolBarSecundar()
    {
        setBorder(null);
        valoriSpecifice = new LinkedHashMap<>();

        first = new JButton();
        second = new JButton();
        third = new JButton();
        fourth = new JButton();
        first.addActionListener(this);
        second.addActionListener(this);
        third.addActionListener(this);
        fourth.addActionListener(this);

        first.setBorderPainted(false);
        second.setBorderPainted(false);
        third.setBorderPainted(false);
        fourth.setBorderPainted(false);

        first.setBackground(new Color(160,97,9));
        second.setBackground(new Color(160,97,9));
        third.setBackground(new Color(160,97,9));
        fourth.setBackground(new Color(160,97,9));

        first.setForeground(new Color(196,206,211));
        second.setForeground(new Color(196,206,211));
        third.setForeground(new Color(196,206,211));
        fourth.setForeground(new Color(196,206,211));

        setFloatable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1; // Make all buttons equally expandable
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(0, 0, 0, 0); // No extra space between buttons
        setMaximumSize(new Dimension(100, 200));
        add(first, gc);
        add(second, gc);
        add(third, gc);
        add(fourth, gc);
        setBackground(new Color(214, 214, 205));
        //setPreferredSize(new Dimension(50,50));
    }

    public void addMapKeyAndValue(String cheie, List<String> sir)
    {
        valoriSpecifice.put(cheie, sir);
    }

    public void setFirst(String nume, String path)
    {
        for(Component component : first.getComponents())
        {
            first.remove(component);
        }

        first.setLayout(new BorderLayout());
        // Create a label for the icon and set it in the center
        try
        {
            JLabel iconLabel = new JLabel(createImageIcon(path));
            first.add(iconLabel, BorderLayout.CENTER);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        // Create a label for the text and set it at the bottom
        JLabel textLabel = new JLabel(nume, JLabel.CENTER);
        textLabel.setForeground(new Color(196,206,211));
        first.add(textLabel, BorderLayout.SOUTH);
        //first.setText(nume);
        first.setName(nume);
    }

    public void setSecond(String nume, String path)
    {
        for(Component component : second.getComponents())
        {
            second.remove(component);
        }

        second.setLayout(new BorderLayout());
        // Create a label for the icon and set it in the center

        try
        {
            JLabel iconLabel = new JLabel(createImageIcon(path));
            second.add(iconLabel, BorderLayout.CENTER);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        // Create a label for the text and set it at the bottom
        JLabel textLabel = new JLabel(nume, JLabel.CENTER);
        textLabel.setForeground(new Color(196,206,211));
        second.add(textLabel, BorderLayout.SOUTH);

        //second.setText(nume);
        second.setName(nume);
    }

    public void setThird(String nume, String path)
    {
        for(Component component : third.getComponents())
        {
            third.remove(component);
        }

        third.setLayout(new BorderLayout());
        // Create a label for the icon and set it in the center
        try
        {
            JLabel iconLabel = new JLabel(createImageIcon(path));
            third.add(iconLabel, BorderLayout.CENTER);

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }


        // Create a label for the text and set it at the bottom
        JLabel textLabel = new JLabel(nume, JLabel.CENTER);
        textLabel.setForeground(new Color(196,206,211));
        third.add(textLabel, BorderLayout.SOUTH);

        //third.setText(nume);
        third.setName(nume);
    }

    public void setFourth(String nume, String path)
    {
        for(Component component : fourth.getComponents())
        {
            fourth.remove(component);
        }

        fourth.setLayout(new BorderLayout());
        // Create a label for the icon and set it in the center

        try
        {
            JLabel iconLabel = new JLabel(createImageIcon(path));
            fourth.add(iconLabel, BorderLayout.CENTER);

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }


        // Create a label for the text and set it at the bottom
        JLabel textLabel = new JLabel(nume, JLabel.CENTER);
        textLabel.setForeground(new Color(196,206,211));
        fourth.add(textLabel, BorderLayout.SOUTH);

        //fourth.setText(nume);
        fourth.setName(nume);
    }

    private void deselectColor()
    {
        first.setForeground(new Color(196,206,211));
        second.setForeground(new Color(196,206,211));
        third.setForeground(new Color(196,206,211));
        fourth.setForeground(new Color(196,206,211));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == first)
        {
            if (comboListener != null)
            {
                deselectColor();
                unitateFolosita = first.getName();
                System.out.println("CEVA");
                System.out.println((String) first.getName());
                comboListener.setComboListener(valoriSpecifice.get(first.getName()));
                inputListener.setValue("0");
                first.setForeground(new Color(255,139,38));
            }
        }
        else if (e.getSource() == second)
        {
            if (comboListener != null)
            {
                deselectColor();
                unitateFolosita = second.getName();
                System.out.println("CEVA");
                System.out.println((String) second.getName());
                comboListener.setComboListener(valoriSpecifice.get(second.getName()));
                inputListener.setValue("0");
                second.setForeground(new Color(255,139,38));
            }
        }
        else if (e.getSource() == third)
        {
            if (comboListener != null)
            {
                deselectColor();
                unitateFolosita = third.getName();
                System.out.println("CEVA");
                System.out.println((String) third.getName());
                comboListener.setComboListener(valoriSpecifice.get(third.getName()));
                inputListener.setValue("0");
                third.setForeground(new Color(255,139,38));
            }
        }
        else if (e.getSource() == fourth)
        {
            if (comboListener != null)
            {
                deselectColor();
                unitateFolosita = fourth.getName();
                System.out.println("CEVA");
                System.out.println((String) fourth.getName());
                comboListener.setComboListener(valoriSpecifice.get(fourth.getName()));
                inputListener.setValue("0");
                fourth.setForeground(new Color(255,139,38));
            }
        }
    }

    public void setComboListener(ComboListener comboListener)
    {
        this.comboListener = comboListener;
    }

    public void setInputText(ToolBarSecundarListener toolBarListener)
    {
        this.toolBarSecundarListener = toolBarSecundarListener;
    }

    public void setToolBarSecundarListener(InputListener inputListener)
    {
        this.inputListener = inputListener;
    }


    public int valoriSpecifice()
    {
        if(first.isSelected())
        {
            return 1;
        }else if(second.isSelected())
        {
            return 2;
        }else if(third.isSelected())
        {
            return 3;
        }
        else if(fourth.isSelected())
        {
            return 4;
        }
        return 0;
    }

    public void setDefaultButton()
    {
        first.doClick();
    }


    // Method to load an image from the project directory

    protected static ImageIcon createImageIcon(String path) {
        URL imageURL = ToolBar.class.getResource(path);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.println("Resource not found: " + path);
            return null;
        }
    }

    public void setPreferencesListener(PreferencesListener preferencesListener)
    {
        this.preferencesListener = preferencesListener;
    }
}
