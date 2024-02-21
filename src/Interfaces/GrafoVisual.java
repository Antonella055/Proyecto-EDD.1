/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;


import Grafo.Grafo;
import Hormigas.Colonia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author Antonella
 */
public class GrafoVisual extends javax.swing.JFrame {
    DefaultTableModel modelo;
     boolean cerrar;
   
    public GrafoVisual() {
        initComponents();
        this.cerrar=false;
        setVisible(false);
        Matriz.setEnabled(false);
        Matriz.setRowSelectionAllowed(false);
        
    }
       public void setModeloTabla(DefaultTableModel modelo) {
           Matriz.setModel(modelo);
           Matriz.setCellSelectionEnabled(false);
           Matriz.getColumnModel().getColumn(0).setCellRenderer(renderizador);

           
    }
       public void MostrarHormigas(){
        Colonia colonia= new Colonia();
        
           System.out.println(colonia.getNro_hormigas());
        nroHormigas.setText(String.valueOf(colonia.getNro_hormigas()));
       }

    public boolean isCerrar() {
        return cerrar;
    }

       
       
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new Fondo();
        jScrollPane1 = new javax.swing.JScrollPane();
        Matriz = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nroHormigas = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Matriz.setBackground(new java.awt.Color(204, 204, 204));
        Matriz.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        Matriz.setForeground(new java.awt.Color(51, 51, 51));
        Matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Matriz.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Matriz.setEnabled(false);
        Matriz.setFillsViewportHeight(true);
        Matriz.setSelectionBackground(new java.awt.Color(51, 51, 51));
        Matriz.setSelectionForeground(new java.awt.Color(51, 51, 51));
        Matriz.setShowGrid(false);
        jScrollPane1.setViewportView(Matriz);

        jLabel1.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        jLabel1.setText("Matriz");

        volver.setBackground(new java.awt.Color(255, 204, 204));
        volver.setFont(new java.awt.Font("Simplex_IV50", 1, 12)); // NOI18N
        volver.setForeground(new java.awt.Color(102, 102, 102));
        volver.setText("Volver");
        volver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 0), null, null));
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/hormiga.png"))); // NOI18N
        jLabel2.setText("Numero de hormigas");

        nroHormigas.setForeground(new java.awt.Color(51, 51, 51));
        nroHormigas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nroHormigas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Guardar");

        jButton2.setText("Guardar Como");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FondoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nroHormigas, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(FondoLayout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nroHormigas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        
        
    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(GrafoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrafoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrafoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrafoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafoVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JTable Matriz;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nroHormigas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
class Fondo extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/imagen.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    
                    super.paint(g);
        }
    }


//Editar la primera columna que tambien contiene indices
DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
          if (c instanceof JLabel && column == 0) {
        ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
        
        Border flatButtonBorder = BorderFactory.createRaisedBevelBorder();
          ((JComponent) c).setBorder(flatButtonBorder);
    }
          
        // Establecer el color de fondo para la primera columna (índice)
       if (column == 0 ){
        c.setBackground(new Color(221,221,221)); 
        c.setForeground(new Color(51, 51, 51)); 
    
    }  else {
            c.setBackground(Color.WHITE); // Restablecer el color de fondo predeterminado para otras columnas
            c.setForeground(new Color(51, 51, 51)); 
        }
        
        return c;
    }
};


}
