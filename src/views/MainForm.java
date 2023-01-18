package views;

import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.Car;
import logic.CarHandler;
import views.strategies.DeleteCarStrategy;
import views.strategies.InsertCarStrategy;
import views.strategies.UpdateCarStrategy;

/**
 *
 * @author Marci
 */
public class MainForm extends javax.swing.JFrame {

    private CarHandlingStrategy strategy;
    private AbstractTableModel carTableModel;
    private List<Car> cars;
    private CarEventListener eventListener;
    private CarHandlerForm carHandlerForm;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        cars = CarHandler.getCarList();
        carTableModel = new CarTableModel(cars);
        tblCar.setModel(carTableModel);
        eventListener = new CarListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCar = new javax.swing.JTable();
        btNew = new javax.swing.JButton();
        btChange = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CarManager");
        setLocationByPlatform(true);
        setResizable(false);

        tblCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCar);

        btNew.setText("New");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btChange.setText("Edit");
        btChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangeActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btNew)
                .addGap(18, 18, 18)
                .addComponent(btChange)
                .addGap(18, 18, 18)
                .addComponent(btDelete)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        carHandlerForm = new CarHandlerForm(this);
        carHandlerForm.addcarEventListener(eventListener);
        carHandlerForm.setcarHandlingStrategy(new InsertCarStrategy());
        carHandlerForm.setVisible(true);
    }//GEN-LAST:event_btNewActionPerformed

    private void tblCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() > 1) {
            int index = tblCar.getSelectedRow();
            carHandlerForm = new CarHandlerForm(this, cars.get(index));
            carHandlerForm.addcarEventListener(eventListener);
            carHandlerForm.setcarHandlingStrategy(new UpdateCarStrategy());
            carHandlerForm.setVisible(true);
        }
    }//GEN-LAST:event_tblCarMouseClicked

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (tblCar.getSelectedRow() > -1 && !cars.isEmpty()) {
            int index = tblCar.getSelectedRow();
            strategy = new DeleteCarStrategy();
            strategy.save(cars.get(index));
            eventListener.carDeleted(cars.get(index));
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeActionPerformed
        if (tblCar.getSelectedRow() > -1 && !cars.isEmpty()) {
            int index = tblCar.getSelectedRow();
            carHandlerForm = new CarHandlerForm(this, cars.get(index));
            carHandlerForm.addcarEventListener(eventListener);
            carHandlerForm.setcarHandlingStrategy(new UpdateCarStrategy());
            carHandlerForm.setVisible(true);
        }
    }//GEN-LAST:event_btChangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    private class CarListener implements CarEventListener {

        @Override
        public void carCreated(Car newCar) {
            cars.add(newCar);
            drawTable();
        }

        @Override
        public void carUpdated() {
            drawTable();
        }

        @Override
        public void carDeleted(Car c) {
            cars.remove(c);
            drawTable();
        }

        private void drawTable() {
            carTableModel.fireTableDataChanged();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChange;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCar;
    // End of variables declaration//GEN-END:variables
}