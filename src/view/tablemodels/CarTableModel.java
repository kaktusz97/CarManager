package view.tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.Car;
import utils.StringFormatter;

public class CarTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Car> cars;

    public CarTableModel(List<Car> cars) {
        columnNames
                = new String[]{"Licence plate", "Brand", "Model", "Engine size"};
        this.cars = cars;
    }

    @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Car temp = cars.get(rowIndex);
        String value = temp.getLicencePlate().
                toUpperCase();
        switch (columnIndex) {
            case 1:
                value = StringFormatter.firstCharUpperRestLower(temp.getBrand());
                break;
            case 2:
                value = StringFormatter.firstCharUpperRestLower(temp.getModel());
                break;
            case 3:
                value = temp.getEngineSize() + " cm3";
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
