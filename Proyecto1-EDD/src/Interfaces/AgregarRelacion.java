/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import javax.swing.JOptionPane;
import org.graphstream.graph.Node;

/**
 *
 * @author Giuseppe Vaccaro
 */
public class AgregarRelacion extends javax.swing.JFrame {
    private static Grafo grafo;
    private static int id;
    private static String filePath;
    /**
     * Creates new form AgregarRelacion
     */
    public AgregarRelacion(int id, Grafo grafo, String filePath) {
        initComponents();
        this.grafo = grafo;
        this.id = id;
        this.filePath = filePath;
        idCiudad.setText(Integer.toString(id));
        agregarR();
        
        
        
    }
        public void agregarR(){ //Agregar la relacion para mostrarla al usuario las existentes
            for (int i = 0; i < grafo.getAristas().getSize(); i++) {
            Arista aux = (Arista) grafo.getAristas().get(i);
            if(relacionExistente.getText().isBlank()){
                
                relacionExistente.setText(aux.getOrigen().getValor() + 
                " - " + aux.getDestino().getValor() + " - Distancia: " + aux.getDistancia());
                
            }else{
                relacionExistente.setText(relacionExistente.getText() + "\n" + 
                + aux.getOrigen().getValor() + " - " + aux.getDestino().getValor() + " - Distancia: " 
                + aux.getDistancia() );
            }
                
                
            
        }
        }
        public void reset(){
            relacionText.setText("");
            distanciaText.setText("");
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
        relacionText = new javax.swing.JTextField();
        agregarRelacion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        distanciaText = new javax.swing.JTextField();
        ciudadFinal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        relacionesActuales = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        relacionExistente = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idCiudad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Relaciones de la Nueva Ciudad");

        jLabel2.setText("Relacion");

        relacionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacionTextActionPerformed(evt);
            }
        });

        agregarRelacion.setText("Agregar Relacion");
        agregarRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarRelacionActionPerformed(evt);
            }
        });

        jLabel3.setText("Distancia");

        distanciaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaTextActionPerformed(evt);
            }
        });

        ciudadFinal.setText("Terminar proceso");
        ciudadFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadFinalActionPerformed(evt);
            }
        });

        jLabel4.setText("Relaciones Actuales");

        relacionExistente.setEditable(false);
        relacionExistente.setColumns(20);
        relacionExistente.setRows(5);
        jScrollPane1.setViewportView(relacionExistente);

        jLabel5.setText("Relaciones Existentes");

        jLabel6.setText("Id de la Ciudad");

        idCiudad.setEditable(false);
        idCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(relacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ciudadFinal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(agregarRelacion)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(relacionesActuales, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(distanciaText, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44))))
                        .addGap(233, 233, 233))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(idCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 97, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(relacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(distanciaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(agregarRelacion)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(relacionesActuales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ciudadFinal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarRelacionActionPerformed
        // TODO add your handling code here:
        try{
                
            if(relacionText.getText().isBlank() || distanciaText.getText().isBlank()){
                JOptionPane.showMessageDialog(null, "Llene todos los espacios");
            }
            else if(Integer.parseInt(relacionText.getText()) == id){
                JOptionPane.showMessageDialog(null, "No puedes relacionar la misma ciudad");
                reset();
            }
            else if(!grafo.isVertex(Integer.parseInt(relacionText.getText())))
               JOptionPane.showMessageDialog(null, "No existe la ciudad a relacionar");

            else{ 
                String relacion = relacionText.getText();
                String distancia = distanciaText.getText();
                
                if(grafo.isEdge(id, Integer.parseInt(relacion), Double.parseDouble(distancia))){
                    JOptionPane.showMessageDialog(null, "No puedes agregar la misma relación");
                    reset();
                    
                }
                else{
                    grafo.AgregarArista(id, Integer.parseInt(relacion), Double.parseDouble(distancia));
                    if(relacionesActuales.getText().isBlank()){
                        relacionesActuales.setText(relacion);
                        relacionExistente.setText("");

                        agregarR();
                        
                    }
                    else{
                        relacionesActuales.setText(relacionesActuales.getText() +"," + relacion);
                        relacionExistente.setText("");
                        agregarR();
                        
                    }
                }
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Valor ingresado no válido");
            reset();
            
            
        }
        
    }//GEN-LAST:event_agregarRelacionActionPerformed

    private void ciudadFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadFinalActionPerformed
        // TODO add your handling code here:
        if(relacionesActuales.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "La ciudad necesita estar relacionada");
        }  
        else{
            this.dispose();
            Menu menu = new Menu(grafo, filePath);
            menu.setVisible(true);
        }
            
        
    }//GEN-LAST:event_ciudadFinalActionPerformed

    private void relacionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relacionTextActionPerformed

    private void distanciaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaTextActionPerformed

    private void idCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCiudadActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarRelacion(id, grafo, filePath).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarRelacion;
    private javax.swing.JButton ciudadFinal;
    private javax.swing.JTextField distanciaText;
    private javax.swing.JTextField idCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea relacionExistente;
    private javax.swing.JTextField relacionText;
    private javax.swing.JTextField relacionesActuales;
    // End of variables declaration//GEN-END:variables
}
