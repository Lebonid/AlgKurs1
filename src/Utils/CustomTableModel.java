package Utils;

import Entity.LibraryEntity;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class CustomTableModel<T> extends AbstractTableModel {

    private final Class<T> cls;

    private final String[] columnNames;

    private List<T> rows;

    public CustomTableModel(Class<T> cls, String[] columnNames, List<T> rows) {
        this.cls = cls;
        this.columnNames = columnNames;
        this.rows = rows;
    }


    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cls.getDeclaredFields().length;
    }

    public Class<?> getColumnClass(int columnIndex){
        return cls.getDeclaredFields()[columnIndex].getType();
    }

    @Override
    public String getColumnName(int column) {
        return column >= columnNames.length ? "NAME" : columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            Field field = cls.getDeclaredFields()[columnIndex];
            field.setAccessible(true);
            return field.get(this.rows.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public List<LibraryEntity> heapSort(List<LibraryEntity> list)
    {
        int size  = list.size();

        for(int i = size / (2 - 1); i >= 0 ; i--)
        {
            Heapify(list, size, i);
        }

        for(int i = size - 1; i >= 0; i--)
        {
            /*
            LibraryEntity temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i,temp);*/
            Collections.swap(list, 0, i);
            Heapify(list,i,0);
        }
        fireTableDataChanged();

        return list;
    }

    private static void Heapify(List<LibraryEntity> list, int size, int rootIndex)
    {
        int largest = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        if(leftChildIndex < size && list.get(leftChildIndex).compareTo(list.get(largest)) > 0)
        {
            largest = leftChildIndex;
        }

        if (rightChildIndex < size && list.get(rightChildIndex).compareTo(list.get(largest)) > 0)
        {
            largest = rightChildIndex;
        }
        if (largest != rootIndex) {
            /*
            LibraryEntity swap = list.get(rootIndex);
            list.set(largest,list.get(largest));
            list.set(largest,swap);*/
            Collections.swap(list, rootIndex, largest);
            Heapify(list, size, largest);
        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
