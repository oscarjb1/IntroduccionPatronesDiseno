package oscarblancarte.ipd.memento.gui;

import javax.swing.JOptionPane;
import oscarblancarte.ipd.memento.entity.Employee;
import oscarblancarte.ipd.memento.impl.EmployeeCaretaker;
import oscarblancarte.ipd.memento.impl.EmployeeMemento;

public class EmployeeGUI extends javax.swing.JFrame {
    Employee employee = new Employee();
    private EmployeeCaretaker caretaker = new EmployeeCaretaker();
    
    public EmployeeGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        empNumberTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patrón de diseño Memento ");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("Número empleado");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save(evt);
            }
        });

        prevBtn.setText("<");
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous(evt);
            }
        });

        nextBtn.setText(">");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(prevBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(empNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 141, Short.MAX_VALUE))
                            .addComponent(lastNameTxt)
                            .addComponent(nameTxt))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(prevBtn)
                    .addComponent(nextBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save
        employee.setName(nameTxt.getText());
        employee.setLastName(lastNameTxt.getText());
        employee.setEmployeeNumber(empNumberTxt.getText());
        
        caretaker.addNewMemento(employee.createMemento());
        
        JOptionPane.showMessageDialog(this, "Estado guardado");
    }//GEN-LAST:event_save

    private void previous(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous
        
        EmployeeMemento menento = caretaker.getPreviousMemento();
        if(menento==null){
            JOptionPane.showMessageDialog(this, "No existen mas estados");
            return;
        }
        employee.restoreMemento(menento);
        updateModel();
    }//GEN-LAST:event_previous

    private void next(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next
        // TODO add your handling code here:
        
        EmployeeMemento memento = caretaker.getNextMemento();
        if(memento==null){
            JOptionPane.showMessageDialog(this, "No existen mas estados");
            return;
        }
        employee.restoreMemento(memento);
        updateModel();
    }//GEN-LAST:event_next

    private void updateModel(){
        nameTxt.setText(employee.getName());
        lastNameTxt.setText(employee.getLastName());
        empNumberTxt.setText(employee.getEmployeeNumber());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField empNumberTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton prevBtn;
    // End of variables declaration//GEN-END:variables
}
