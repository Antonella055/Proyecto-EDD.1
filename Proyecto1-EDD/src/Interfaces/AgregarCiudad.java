/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Grafo.Grafo;
import Grafo.Vertice;
import javax.swing.JOptionPane;

/**
 *
 * @author Giuseppe Vaccaro
 */
public class AgregarCiudad extends javax.swing.JFrame {
    private static Grafo grafo;
    private static String filePath;
    /**
     * Creates new form AgregarCiudad
     */
    public AgregarCiudad(Grafo grafo, String filePath) {
        initComponents();
        
       this.grafo = grafo;
       this.filePath = filePath;
       agregarCiudades();
       
       
       
    }
    
    public void agregarCiudades(){
        for (int i = 0; i < grafo.getVertices().getSize(); i++) {
        Vertice aux = (Vertice) grafo.getVertices().get(i);
        String id = Integer.toString(aux.getValor());
       if(ciudadExistente.getText().isBlank()){
            ciudadExistente.setText("Ciudad --> " + id);
        }
       else{
            ciudadExistente.setText(ciudadExistente.getText() + "\n" + "Ciudad --> " + id);
        }

        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        agregarCiudad = new javax.swing.JButton();
        idCiudad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ciudadExistente = new javax.swing.JTextArea();
        otraRelacion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agregar Ciudad");

        jLabel2.setText("Id de la ciudad");

        agregarCiudad.setText("Agregar");
        agregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCiudadActionPerformed(evt);
            }
        });

        idCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCiudadActionPerformed(evt);
            }
        });

        jLabel3.setText("Ciudades Existentes");

        ciudadExistente.setColumns(20);
        ciudadExistente.setRows(5);
        jScrollPane1.setViewportView(ciudadExistente);

        otraRelacion.setText("Nuevas relaciones");
        otraRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otraRelacionActionPerformed(evt);
            }
        });

        jButton1.setText("Crear Relaciones");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Si la ciudad existe...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agregarCiudad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(otraRelacion)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarCiudad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(otraRelacion)
                            .addComponent(jLabel4)))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCiudadActionPerformed
        // TODO add your handling code here:
            
            try{
                int id = Integer.parseInt(idCiudad.getText());

                if(grafo.getVertices().getSize() == 0 && idCiudad.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Recuerda agregar un id");

                }
                else if(grafo.getVertices().getSize() == 0){
                    grafo.AgregarVertice(Integer.parseInt(idCiudad.getText()));
                    agregarCiudades();
                }
                
                else if(this.grafo.isVertex(id)) {
                    JOptionPane.showMessageDialog(null, "Ya esta ciudad existe");
                    idCiudad.setText("");


                }
                else if(idCiudad.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Recuerda agregar un id");

                }

                else{
                    grafo.AgregarVertice(id);
                    ciudadExistente.setText("");
                    agregarCiudades();



                }
            
            
            }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Dato inválido, ingresa un entero");
                    
                
                    
                    
            }
            
        
        
        
    }//GEN-LAST:event_agregarCiudadActionPerformed

    private void idCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCiudadActionPerformed

    private void otraRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otraRelacionActionPerformed
        // TODO add your handling code here:
        if(grafo.getVertices().getSize() <= 1){
            JOptionPane.showMessageDialog(null, "Necesitas al menos dos ciudades existentes");
   
        }else{
            try{
                int id = Integer.parseInt(idCiudad.getText());
                if(!this.grafo.isVertex(id)) {
                    JOptionPane.showMessageDialog(null, "No puedes relacionar una ciudad que no existe");
                    
                }
                else{
                    AgregarRelacion agregarRelacion = new AgregarRelacion(id, grafo, filePath);
                    agregarRelacion.setLocationRelativeTo(null);
                    this.dispose();
                    agregarRelacion.setVisible(true);

                }
            }catch(Exception e){
                if(grafo.getVertices().getSize() != 1){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Dato ingresado debe ser un entero");
                    
                }
                    
                    
            }
            
        }
        
        
          
    }//GEN-LAST:event_otraRelacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(grafo.getVertices().getSize() == 1){
            JOptionPane.showMessageDialog(null, "Necesitas al menos una ciudad más");
        }
        else{
            this.dispose();
            int id = Integer.parseInt(idCiudad.getText());
            AgregarRelacion agregarRelacion = new AgregarRelacion(id, grafo, filePath);
            agregarRelacion.setLocationRelativeTo(null);

            agregarRelacion.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCiudad(grafo, filePath).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCiudad;
    private javax.swing.JTextArea ciudadExistente;
    private javax.swing.JTextField idCiudad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton otraRelacion;
    // End of variables declaration//GEN-END:variables
}
