package GUI;

import Model.Tuple;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableModel extends AbstractTableModel
{

    List<Tuple> denumire;
    //Map<String, String> valori;

    @Override
    public int getRowCount()
    {
        if(denumire == null)
        {
            return 7;
        }
        return denumire.size();
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Tuple valoare = denumire.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return valoare.getFirst();
            case 1:
                return valoare.getSecond();
        }
        return null;
    }


    public void setData(List<Tuple> denumire)
    {
        this.denumire = denumire;
    }



}
