/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;


//import Estructuras.HashMap.Entry;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.JTextArea;
//import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * La clase Archivo proporciona métodos para abrir, leer y obtener información del archivo seleccionado por el usuario.
 * @author Antonella
 */
public class Archivo {
//    public static File archivo_seleccionado;
//    private Grafo grafo;
    public static String filePath(){ //Obtenemos el archivo de texto y su dirección
        JFileChooser jf = new JFileChooser();
        String userHome = System.getProperty("user.home");
        jf.setCurrentDirectory(new File(userHome + "/Documents"));
        
        int value = jf.showOpenDialog(null);
        
        if(value == JFileChooser.APPROVE_OPTION){
            return jf.getSelectedFile().getAbsolutePath();
        }
        else{
            return "";
        }
    }
    
    public static void save(Grafo grafo, String filePath){
        try{
            File file = new File(filePath);
            
            FileWriter fw = new FileWriter(file);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            List<Vertice> vertices = grafo.getVertices();
            List<Arista> aristas = grafo.getAristas();
            
            bw.write("ciudad");
            bw.newLine();
            for (int i = 0; i < vertices.getSize(); i++) {
                Vertice auxVertex = (Vertice) vertices.get(i);
                int auxId = auxVertex.getValor();
                
                bw.write(Integer.toString(auxId));
                bw.newLine();               
            }
            
            bw.write("aristas");
            bw.newLine();
            
            for (int i = 0; i < aristas.getSize(); i++) {
                Arista auxEdge = (Arista) aristas.get(i);
                String auxOrigen = Integer.toString(auxEdge.getOrigen().getValor());
                String auxDestino = Integer.toString(auxEdge.getDestino().getValor());
                String auxSize = Double.toString(auxEdge.getDistancia());
                bw.write(auxOrigen + "," + auxDestino + "," + auxSize);
                bw.newLine();

                
            }
            bw.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
    
        }
    
    public static Grafo load(String filePath) {
        try{
            Grafo grafo = new Grafo();
            
            File file = new File(filePath);
            
            FileReader fr = new FileReader(file);
            
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while (!(line = br.readLine()).equals("aristas")) {
                if(!line.equals("ciudad")){
                    grafo.AgregarVertice(Integer.parseInt(line));                   
                }
            }
            
            while ((line = br.readLine()) != null) {
                if(!line.equals("aristas")){
                    String[] values = line.split(",");
                    int value1 = Integer.parseInt(values[0]);
                    int value2 = Integer.parseInt(values[1]);
                    double value3 = Double.parseDouble(values[2]);
                     
                    grafo.AgregarArista(value1, value2, value3);                   
                }
            }
            return grafo;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    
    
    
    } //Fin de la clase
    
    
//    
//    //Fin archivo anterior
//    /**
//     * Abre un cuadro de diálogo para seleccionar un archivo y muestra información sobre el archivo seleccionado.
//     */
//    public void abrir(){
//        JFileChooser fileChooser= new JFileChooser();
//        JTextArea text= new JTextArea();
//        text.setEditable(false);
//        
//        fileChooser.setCurrentDirectory(new File("C://Users//Antonella//OneDrive//Escritorio//Github//Proyecto 1//ArchivoTxt"));
//        
//        //Filtrar solo los archivos de texto
//        FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.txt","txt");
//        fileChooser.setFileFilter(filtro);
//        
//        // llamada a  el cuadro de diálogo de selección de archivo
//        int retornaV = fileChooser.showOpenDialog(null);
//        
//        if(retornaV==JFileChooser.APPROVE_OPTION){
//            archivo_seleccionado= fileChooser.getSelectedFile();
//            
//            if(archivo_seleccionado.length() != 0 && archivo_seleccionado.exists()){
//                System.out.println("Archivo seleccionado: "+ archivo_seleccionado.getAbsolutePath());
//            }else{
//                JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        
//    }
//  
//    
//    /**
//     * Lee las relaciones desde el archivo seleccionado y las almacena en un HashMap.
//     *
//     * @return HashMap que contiene las relaciones leídas desde el archivo.
//     */
//  public HashMap<String, ListaArray> leerGrafo(Grafo grafo) {
//   HashMap<String, ListaArray> mapaAristas = new HashMap<>();
//
//   
//   try (BufferedReader leer = new BufferedReader(new FileReader(archivo_seleccionado))) {
//        String linea;
//        boolean leer_Ciudad = true;
//        boolean leer_Relaciones = false;
//        String origen;
//        String destino ;
//        double distancia;
//        
//
//        while ((linea = leer.readLine()) != null) {
//            
//            if (linea.equals("aristas")) {
//                leer_Ciudad = false;
//                leer_Relaciones = true;
//            }
//            
//            if(leer_Relaciones) {
//                String[] partes = linea.split(",");
//                if (partes.length >= 3) {
//                    origen = partes[0].trim(); // PARA QUE SE USA TRIM????
//                    destino = partes[1].trim();
//                    distancia = Double.parseDouble(partes[2].trim());
//                    
//                    // LLamar al grafo
//                    grafo.AgregarArista(Integer.parseInt(origen), Integer.parseInt(destino), distancia);
//            
//            
//                    // Verificar si el origen ya está en el HashMap
//                    if (!mapaAristas.containsKey(origen)) {
//                        mapaAristas.insertar(origen,new ListaArray(10));
//                        
//                    }if(!mapaAristas.containsKey(destino)){
//                         mapaAristas.insertar(destino,new ListaArray(10));
//                    }
//                    
//                     mapaAristas.get(origen).insertar(destino);
//                
//                     
//
//                }
//            }
////            else if(leer_Ciudad) {
////                if(!linea.equals("ciudad")){
////                    grafo.AgregarVertice(Integer.parseInt(linea));
////                    
////                }
//                
////            }
//    }    
//        
//  
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//        return mapaAristas;
//    
//  }
//  
//    /**
//     * Obtiene la lista de ciudades a partir de las relaciones proporcionadas.
//     *
//     * @param relaciones HashMap con las relaciones entre ciudades.
//     * @return Una ListaArray que contiene las ciudades obtenidas de las relaciones.
//     */
//    public ListaArray<String> obtCiudades(HashMap<String,ListaArray> relaciones){  //PREGUNTAR PARA QUE USA ESTO!!! 
//        //Raro no se utiliza bufferedReader
//        ListaArray<String> ciudades = new ListaArray<>(20);
//        
//        for(Entry<String,ListaArray> entrada: relaciones.tabla){
//            while(entrada != null){
//                ciudades.insertar(entrada.clave);
//                entrada = entrada.siguiente;
//            }
//        }
//        
//    return ciudades;
//    }
//    
//   
//    
//    /**
//     * Obtiene la distancia entre dos ciudades a partir de las relaciones proporcionadas.
//     *
//     * @param origen   ciudad de origen.
//     * @param destino  ciudad de destino.
//     * @return La distancia entre las ciudades, o -1 si la distancia no se encuentra.
//     */
//    public double obtenerDistancia(String origen, String destino) {
//    double distancia = -1;  // Valor predeterminado si la distancia no se encuentra
//
//    try (BufferedReader leer = new BufferedReader(new FileReader(archivo_seleccionado))) {
//        String linea;
//        while ((linea = leer.readLine()) != null) {
//            String[] partes = linea.split(",");
//            if (partes.length >= 3) {
//                String origenDistancia = partes[0].trim();
//                String destinoDistancia = partes[1].trim();
//                if (origenDistancia.equals(origen) && destinoDistancia.equals(destino)) {
//                    distancia = Double.parseDouble(partes[2].trim());
//                    break;  // Se encontró la distancia, salir del bucle
//                }
//            }
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    return distancia;
//}
//    
// 
//    
//    }


