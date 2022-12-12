
package Models;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Tables extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean b1n, boolean b1n1, int row, int column) {
        super.getTableCellRendererComponent(jtable, o, b1n, b1n1, row, column); 
        if (jtable.getValueAt(row, column).toString().equals("Inactivo")) {
            setBackground(Color.red);
            setForeground(Color.white);
            
        }else{
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
    
}
