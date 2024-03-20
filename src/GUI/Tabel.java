package GUI;

import Listener.*;
import Model.DeBaza;
import Model.Greutate;
import Model.Tuple;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.prefs.Preferences;

public class Tabel extends JPanel
{
    private JTextField input;
    private JComboBox comboBox;
    private JTable table;
    private ToolBarSecundar toolBarSecundar;
    private DefaultTableModel defaultTableModel;
    private TableModel tableModel;
    private Converser converser;
    private SwingWorker<Map<Integer,Double[]>, Integer> worker;

    //private Preferences preferences;

    public Tabel()
    {
        setBorder(null);
        converser = new Converser();
        toolBarSecundar = new ToolBarSecundar();
        input = new JTextField(10);
        input.setEnabled(true);
        comboBox = new JComboBox();
        table = new JTable();
        table.setRowHeight(20);
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        ((AbstractDocument) input.getDocument()).setDocumentFilter(new LimitedDocumentFilter());
        DefaultComboBoxModel comboList = new DefaultComboBoxModel();
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(10,3));

        //////////////////// WORKER FOR UPDATE IN PARALLEL THE CURRENCY //////////////////

        worker = new SwingWorker<Map<Integer,Double[]>, Integer>()
        {

            @Override
            protected void process(List<Integer> chunks)
            {

            }

            @Override
            protected Map<Integer, Double[]> doInBackground() throws Exception
            {
                Map<Integer, Double[]> map = null;
                converser.conversieValutara();
                //map.put(0,sirToBig);
                //map.put(1,sirToSmall);
                return map;
            }

            @Override
            protected void done()
            {
                converser.updatePreferences();
                System.out.println("BACKGORUND");
            }
        };
        worker.execute();

        converser.setWorkerCancel(new WorkerCancel()
        {
            @Override
            public void cancelWorker()
            {
                if(worker != null)
                {
                    worker.cancel(true);
                }
            }
        });

        /*
        toolBarSecundar.setPreferencesListener(new PreferencesListener(){

            @Override
            public void updateCurrency()
            {
                converser.updatePreferences();
            }
        });*/

        toolBarSecundar.setToolBarSecundarListener(new InputListener()
        {

            @Override
            public void setValue(String defaultValue)
            {
                try
                {
                    String lungime = input.getText();

                    input.getDocument().remove(0,lungime.length());
                    input.getDocument().insertString(0,"0",null);
                } catch (BadLocationException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });

        toolBarSecundar.setComboListener(new ComboListener()
        {
            @Override
            public void setComboListener(List<String> sir)
            {
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                for(String val: sir)
                {
                    model.addElement(val);
                }
                comboBox.setModel(model);
            }
        });

        input.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            tableModel = new TableModel();
            String valoareNumerica = input.getText();
            String unitate = (String)comboBox.getSelectedItem();
            List<Tuple> valoriNumerice = converser.conversie(valoareNumerica, unitate, toolBarSecundar.unitateFolosita);
            tableModel.setData(valoriNumerice);
            tableModel.fireTableDataChanged();
            table.setModel(tableModel);
            table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer());
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            tableModel = new TableModel();
            String valoareNumerica = input.getText();
            String unitate = (String)comboBox.getSelectedItem();
            if(valoareNumerica == null || valoareNumerica.equals(""))
            {
                valoareNumerica = "0";
            }
            List<Tuple> valoriNumerice = converser.conversie(valoareNumerica, unitate, toolBarSecundar.unitateFolosita);
            tableModel.setData(valoriNumerice);
            tableModel.fireTableDataChanged();
            table.setModel(tableModel);
            table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not needed for plain text components
        }

        private void updateLabel() {
        }
    });


        comboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tableModel = new TableModel();
                String valoareNumerica = input.getText();
                String unitate = (String)comboBox.getSelectedItem();
                if(valoareNumerica.equals(""))
                {
                    valoareNumerica = "0";
                }
                List<Tuple> valoriNumerice = converser.conversie(valoareNumerica, unitate, toolBarSecundar.unitateFolosita);
                tableModel.setData(valoriNumerice);
                tableModel.fireTableDataChanged();
                table.setModel(tableModel);
                table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer());

            }
        });

        //Dimension dim = comboBox.getPreferredSize();
        //comboBox.setPreferredSize(new Dimension());
        comboBox.setPreferredSize(new Dimension(110,20));
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1; // Make all buttons equally expandable
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(0, 0, 0, 0); // No extra space between buttons
        ////////////// FIRST ROW ///////////////
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        gc.weightx = 1;
        add(toolBarSecundar,gc);
        //////////////////////// SECOND ROW /////////////////////
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = new Insets(2,0,0,5);
        gc.weighty = 0.001;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 1;
        add(input,gc);
        //////////////////////// SECOND COLUMN ////////////////////
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = new Insets(2,5,0,0);
        gc.weighty = 0.001;
        gc.gridx = 1;
        gc.weightx = 1;
        gc.gridy = 1;
        gc.gridwidth = 1;
        add(comboBox,gc);
        /////////////////// THIRD ROW /////////////////////////
        gc.anchor = GridBagConstraints.NORTH;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridy = 2;
        gc.gridx = 0;
        gc.gridwidth = 2;
        gc.weightx = 1.0;
        gc.weighty = 0.01;
        add(table,gc);

    }

    public void setNumeToolBarSecundar(Map<String, List<String>> valori)
    {

        List<String> sir = new ArrayList<String>();
        int nr = 0;

        for(Map.Entry<String, List<String>> entry : valori.entrySet())
        {
           if(nr == 0)
           {
               toolBarSecundar.setFirst(entry.getKey(), "/images/" + entry.getKey() + ".png");
               toolBarSecundar.addMapKeyAndValue((String) entry.getKey(), entry.getValue());

           }else if(nr == 1)
           {
               toolBarSecundar.setSecond(entry.getKey(), "/images/" + entry.getKey() + ".png");
               toolBarSecundar.addMapKeyAndValue((String) entry.getKey(), entry.getValue());

           }else  if(nr == 2)
           {
               toolBarSecundar.setThird(entry.getKey(), "/images/" + entry.getKey() + ".png");
               toolBarSecundar.addMapKeyAndValue((String) entry.getKey(), entry.getValue());

           }else
           {
               toolBarSecundar.setFourth(entry.getKey(), "/images/" + entry.getKey() + ".png");
               toolBarSecundar.addMapKeyAndValue((String) entry.getKey(), entry.getValue());
           }
           nr++;
        }

    }

    public void setDefaultButton()
    {
        toolBarSecundar.setDefaultButton();
    }


    class LimitedDocumentFilter extends DocumentFilter  {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            StringBuilder sb = new StringBuilder(input.getText());
            sb.insert(offset, string);
            if (!isValidInput(sb.toString())) {
                return;
            }
            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            StringBuilder sb = new StringBuilder(input.getText());
            sb.replace(offset, offset + length, text);
            if (!isValidInput(sb.toString())) {
                return;
            }
            super.replace(fb, offset, length, text, attrs);
        }

        // Check if the input is valid
        private boolean isValidInput(String text) {
            return text.isEmpty() || text.equals("0") || text.matches("[1-9][0-9]*");
        }
    }
}