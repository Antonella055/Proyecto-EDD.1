/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Colonia;
import Clases.Hormiga;
import Grafo.Grafo;
import javax.swing.JOptionPane;

/**
 *
 * @author Giuseppe Vaccaro
 */
public class MostrarSimulacion extends javax.swing.JFrame {
    private static Colonia colonia;
    private static Grafo grafo;
    private static String ruta;
    private static int contador;
    /**
     * Creates new form MostrarSimulacion
     */
    public MostrarSimulacion(Colonia colonia, Grafo grafo, String ruta) {
        initComponents();
        this.colonia = colonia;
        this.grafo = grafo;
        this.ruta = ruta;
        this.contador = 0;
        colonia.crearHormigas();
        colonia.iniciarFeromonas();
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
        output = new javax.swing.JTextArea();
        salir = new javax.swing.JButton();
        siguienteCiclo = new javax.swing.JButton();
        caminoOptimo = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ciclo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        siguienteCiclo.setText("Siguiente ciclo");
        siguienteCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteCicloActionPerformed(evt);
            }
        });

        caminoOptimo.setText("Camino optimo");

        print.setText("print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel1.setText("Ciclo");

        ciclo.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(siguienteCiclo)
                        .addGap(34, 34, 34)
                        .addComponent(caminoOptimo)
                        .addGap(37, 37, 37)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(salir)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciclo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ciclo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(siguienteCiclo)
                    .addComponent(caminoOptimo)
                    .addComponent(print))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu(grafo, ruta);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void siguienteCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteCicloActionPerformed
        if(contador != colonia.getNro_ciclos()){
            while(!colonia.terminoCiclo()){

                for (int i = 0; i < colonia.getHormigas().getSize(); i++) {
                    Hormiga hormiga = colonia.getHormigas().get(i);
    //                System.out.print("hormiga " + i + " " + hormiga.getCiudadActual() + " --> ");
                    colonia.elegirSiguienteCamino(hormiga);
    //                System.out.println(hormiga.getCiudadActual());
                }
                colonia.actualizarEvaporacion();       
            }
            contador++;
            String str = "";
            for (int i = 0; i < colonia.getHormigas().getSize(); i++) {
                Hormiga hormiga = colonia.getHormigas().get(i);
                str += "hormiga " + i + ": ";
                for (int j = 0; j < hormiga.getCiudadesVisitadas().getSize(); j++) {
                    int id = hormiga.getCiudadesVisitadas().get(j);
                    if(j != hormiga.getCiudadesVisitadas().getSize() - 1){
                        str += id + " --> ";                    
                    }
                    else{
                        str += Integer.toString(id) + "\n\n"; 
                    }
                }
            }
            ciclo.setText(Integer.toString(contador));
            output.setText(str);
            colonia.reiniciar();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Termino la simulacion");
        }
        
    }//GEN-LAST:event_siguienteCicloActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        colonia.getGrafo().mostrarGrafo();
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(MostrarSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarSimulacion(colonia, grafo, ruta).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton caminoOptimo;
    private javax.swing.JLabel ciclo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output;
    private javax.swing.JButton print;
    private javax.swing.JButton salir;
    private javax.swing.JButton siguienteCiclo;
    // End of variables declaration//GEN-END:variables
}
