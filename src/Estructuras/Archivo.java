/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Antonella
 */
public class Archivo {
    public static File archivo_seleccionado;

    
    public void abrir(){
        JFileChooser fileChooser= new JFileChooser();
        JTextArea text= new JTextArea();
        text.setEditable(false);
        
        fileChooser.setCurrentDirectory(new File("C://Users//Antonella//OneDrive//Escritorio//Github//Proyecto 1//ArchivoTxt"));
        
        //Filtrar solo los archivos de texto
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.txt","txt");
        fileChooser.setFileFilter(filtro);
        
        // llamada a  el cuadro de diálogo de selección de archivo
        int retornaV = fileChooser.showOpenDialog(null);
        
        if(retornaV==JFileChooser.APPROVE_OPTION){
            archivo_seleccionado= fileChooser.getSelectedFile();
            
            if(archivo_seleccionado.length() != 0 && archivo_seleccionado.exists()){
                System.out.println("Archivo seleccionado: "+ archivo_seleccionado.getAbsolutePath());
            }else{
                JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void leerArchivo(){
   
        ListaDobleEnlazada ciudades=new ListaDobleEnlazada();
          ListaDobleEnlazada conexiones=new ListaDobleEnlazada();
        try{
            BufferedReader leer= new BufferedReader(new FileReader(archivo_seleccionado));
            String linea;
            boolean ciudad_encontrada=true;
            while ((linea = leer.readLine()) != null) {
                if(linea.equals("aristas")){
                    ciudad_encontrada=false;
                    continue;}
                if(ciudad_encontrada){
                    ciudades.agregarFinal(linea);
                }else{
                    conexiones.agregarFinal(linea);
                }
            }leer.close();
        }catch(IOException e){
             e.printStackTrace();
        }
    }
       
}
