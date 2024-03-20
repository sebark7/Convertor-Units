package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableCellRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Customize the rendering based on the cell value

        setHorizontalAlignment(SwingConstants.RIGHT);
        cellComponent.setForeground(Color.RED); // Set text color to red for ages 30 and above
        Font font = cellComponent.getFont();
        font = font.deriveFont(font.getStyle() | Font.BOLD);
        cellComponent.setFont(font);

        return cellComponent;
    }
}
