/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Estructuras.Archivo;
import Estructuras.HashMap;
import Estructuras.ListaArray;
import Estructuras.Matriz;
import Grafo.Grafo;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonella
 */
public class Menu extends javax.swing.JFrame {
    boolean archivoSeleccionado=false;
    /**
     * Creates new form Menu_principal
     */
    public Menu() {
        initComponents();
        
         newsimulacion.setEnabled(false);
         Cargargrafo.setEnabled(false);
         SvGrafo.setEnabled(false);
         addciudad.setEnabled(false);
         delciudad.setEnabled(false);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        Fondo = new Fondo();
        jPanel1 = new Fondo();
        newsimulacion = new javax.swing.JButton();
        delciudad = new javax.swing.JButton();
        SvGrafo = new javax.swing.JButton();
        addciudad = new javax.swing.JButton();
        Cargargrafo = new javax.swing.JButton();
        CargarArchivo = new javax.swing.JButton();

        jButton7.setText("Guardar Grafo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 255, 204));
        jButton10.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setText("Eliminar Ciudad");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        newsimulacion.setBackground(new java.awt.Color(22, 19, 15));
        newsimulacion.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        newsimulacion.setForeground(new java.awt.Color(132, 107, 82));
        newsimulacion.setText("Iniciar Simulacion");
        newsimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newsimulacionActionPerformed(evt);
            }
        });
        Fondo.add(newsimulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 360, 40));

        delciudad.setBackground(new java.awt.Color(22, 19, 15));
        delciudad.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        delciudad.setForeground(new java.awt.Color(102, 102, 102));
        delciudad.setText("Eliminar Ciudad");
        delciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delciudadActionPerformed(evt);
            }
        });
        Fondo.add(delciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 170, 40));

        SvGrafo.setBackground(new java.awt.Color(22, 19, 15));
        SvGrafo.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        SvGrafo.setForeground(new java.awt.Color(102, 102, 102));
        SvGrafo.setText("Guardar ");
        SvGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SvGrafoActionPerformed(evt);
            }
        });
        Fondo.add(SvGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 170, 40));

        addciudad.setBackground(new java.awt.Color(22, 19, 15));
        addciudad.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        addciudad.setForeground(new java.awt.Color(102, 102, 102));
        addciudad.setText("Agregar ciudad");
        addciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addciudadActionPerformed(evt);
            }
        });
        Fondo.add(addciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, 40));

        Cargargrafo.setBackground(new java.awt.Color(22, 19, 15));
        Cargargrafo.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        Cargargrafo.setForeground(new java.awt.Color(102, 102, 102));
        Cargargrafo.setText("Cargar Grafo");
        Cargargrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargargrafoActionPerformed(evt);
            }
        });
        Fondo.add(Cargargrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 170, 40));

        CargarArchivo.setBackground(new java.awt.Color(12, 7, 1));
        CargarArchivo.setFont(new java.awt.Font("Artifakt Element Light", 0, 12)); // NOI18N
        CargarArchivo.setForeground(new java.awt.Color(169, 155, 141));
        CargarArchivo.setText("Cargar Archivo");
        CargarArchivo.setBorder(new javax.swing.border.MatteBorder(null));
        CargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArchivoActionPerformed(evt);
            }
        });
        Fondo.add(CargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void newsimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newsimulacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newsimulacionActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void delciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delciudadActionPerformed

    private void SvGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SvGrafoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SvGrafoActionPerformed

    private void addciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addciudadActionPerformed

    private void CargargrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargargrafoActionPerformed
        GrafoVisual x =new GrafoVisual();
        x.setVisible(true);
        
       Archivo a=new Archivo();
       HashMap<String, ListaArray> relaciones = a.leerRelaciones();
       ListaArray<String> ciudades= a.obtCiudades(relaciones);
       Matriz b= new Matriz();
       int[][] matriz=b.Crear(relaciones, ciudades);
       b.imprimirMatriz(matriz);
       new Grafo().construir(matriz);

     
       
         x.modelo=new DefaultTableModel();
         x.modelo.addColumn("0");
        for (int i = 0; i < ciudades.getSize(); i++) {
            x.modelo.addColumn(ciudades.get(i));
        }
            for (int i = 0; i < matriz.length; i++) {
            Object[] rowData= new Object[matriz[i].length+1];
            rowData[0]=ciudades.get(i);
            for (int j = 0; j < matriz[i].length; j++) {
            rowData[j + 1] = matriz[i][j];
    }
    x.modelo.addRow(rowData);
    
    
}
      x.setModeloTabla(x.modelo);
    }//GEN-LAST:event_CargargrafoActionPerformed

    private void CargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArchivoActionPerformed
        // TODO add your handling code here:
        Path file= Paths.get("recorridos.txt");
        try {
            Files.delete(file);
        } catch (IOException ex) {
            
        } 
        Path doc= Paths.get("recorrido.txt");
         try {
            Files.delete(doc);
        } catch (IOException ex) {
            
        } 
         new Archivo().abrir();
         archivoSeleccionado=true;
         
         
         newsimulacion.setEnabled(true);
         Cargargrafo.setEnabled(true);
         SvGrafo.setEnabled(true);
         addciudad.setEnabled(true);
         delciudad.setEnabled(true);
    }//GEN-LAST:event_CargarArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarArchivo;
    private javax.swing.JButton Cargargrafo;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton SvGrafo;
    private javax.swing.JButton addciudad;
    private javax.swing.JButton delciudad;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newsimulacion;
    // End of variables declaration//GEN-END:variables

  class Fondo extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/menuprinc.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    
                    super.paint(g);
        }
    }}


