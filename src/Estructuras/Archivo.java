/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Grafo.Nodo;
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
    public static int nodoOrigen;
    public static int nodoDestino;
    public static double peso;
    
    
    public void abrirArchivo(){
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
    
    public static ArrayList<String>leerArchivo() throws FileNotFoundException, IOException{
        ArrayList<String>contenido=new ArrayList();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo_seleccionado))){
            String linea;
            while ((linea=br.readLine()) !=null){
                contenido.insertar(linea);
                String[] partes=linea.split(",");
                if (partes.length==3){
                    nodoOrigen=Integer.parseInt(partes[0]);
                    nodoDestino=Integer.parseInt(partes[1]);
                    peso=Double.parseDouble(partes[2]);
                }
                
            }
        }catch  (IOException e){
            e.printStackTrace();
        }
    return contenido;
    }
    
}
