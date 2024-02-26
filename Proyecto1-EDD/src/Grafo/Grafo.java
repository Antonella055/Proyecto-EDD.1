/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Clases.Tag;
import Estructuras.Archivo;
import Estructuras.List;
import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;


/**
*
 * @author Antonella
 * @param <E> El tipo de elementos que se almacenarán en el grafo
 * Clase Grafo, representa un grafo con vertices y aristas
 */
public class Grafo<E> {
    private  List<Vertice> vertices;
    private  List<Arista> aristas;
    private int size;
    
    /**
     * Constructor de la clase 
     */
    public Grafo() {
        this.vertices = new List (); //Esto lo cambié a 20 porque asumo que solo puede almacenar 20
        this.aristas = new List (); ///// preguntar con esto!!!
        this.size = 0;
        
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public int getSize() {
        return size;
    }
    
    
    // NUEVOOOO!
    public boolean isVertex(int id){ 
        if(this.vertices.isEmpty()){
            return false;
        }
        else{
            for (int i = 0; i < this.vertices.getSize(); i++) {
                Vertice auxVertex = (Vertice) this.vertices.get(i);
                if(auxVertex.getValor() == id){
                    return true;
                }

            }

        }
        return false;
    }
    
        

// NUEVOOOO!
    public boolean isEdge(int idA, int idB, double distance){
        if(this.aristas.isEmpty()){
            return false;
        }
        else{
            if(isVertex(idA) && isVertex(idB)){
                for (int i = 0; i < this.aristas.getSize(); i++) {
                    Arista auxArista = (Arista) this.aristas.get(i);
                    int valorOrigen = auxArista.getOrigen().getValor();
                    int valorDestino = auxArista.getDestino().getValor();
                    if((valorDestino == idA && valorOrigen == idB) || (valorDestino == idB && valorOrigen == idA) ){
                        if(auxArista.getDistancia() == distance){
                            return true;
                        }
                    }

                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No son vertices, no se pueden relacionar");
            }
        }   
        return false;
    }
    
    

 
    
    
    
//    /**
//     *Funcion para construir el grafo mediante una matriz de adyacencia 
//     * @param matriz Matriz de adyancencia que representa el grafo 
//     */
//    public void construir(int[][] matriz) {
//        for (int i = 0; i < matriz.length; i++) {
//            Vertice vertice = new Vertice(i + 1);
//            AgregarVertice(vertice);
//        }
//
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                if (matriz[i][j] == 1) {
//                    int distancia =new Archivo().obtenerDistancia(Integer.toString(i + 1), Integer.toString(j + 1));
//                    Arista arista = new Arista(vertices.get(i), vertices.get(j),distancia);
//                    AgregarArista(arista);
//                }
//            }
//        }
//         
//    }
    
    /**
     * Funcion para agregar un vertice al grafo //MODIFICADO!!!
     * @param vertice  vertice a agregar
     */
    public void AgregarVertice(int id){ 
            Vertice newVertex = new Vertice(id);
            if(vertices.getSize() < 20){
                if(!isVertex(id)){
                    this.vertices.insertarFinal(newVertex);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El vertice ya existe");
                }
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Ya no se pueden agregar más vertices");
            }
            
//            vertices.insertar(vertice);  BORRAR DESPUES - SE EDITÓ
//             String idVertice = Integer.toString(vertice.valor);
//            graph.addNode(idVertice);
//            graph.getNode(idVertice).setAttribute("ui.label", idVertice);
//            graph.getNode(idVertice).setAttribute("ui.style", "text-alignment: under;");
//        
            
    }
    
    public Vertice getVertice(int id){
        for (int i = 0; i < this.vertices.getSize(); i++) {
            Vertice auxVertex = (Vertice) this.vertices.get(i);
            if(auxVertex.getValor() == id){
                return auxVertex;
            }
         
            
        }
        return null;
    }
    
    
    /**
     * Metodo para agregar una arista al grafo //MODIFICADO!
     * @param arista arista a agregar 
     */
    public void AgregarArista(int idA, int idB, double distance){ 
        Vertice auxA = getVertice(idA);
        Vertice auxB = getVertice(idB);
        Arista newArista = new Arista(auxA, auxB, distance);
        if(isEdge(idA, idB, distance)){
            JOptionPane.showMessageDialog(null, "No se puede agregar la misma relación");
        }else{
            this.aristas.insertarFinal(newArista);
        }
        
        
//            aristas.insertar(arista);
//            String idArista = arista.getOrigen().valor+ "-" + arista.getDestino().valor; // Crear un ID para la arista
//        graph.addEdge(idArista, Integer.toString(arista.getOrigen().valor), Integer.toString(arista.getDestino().valor)); // Agrega la arista al grafo de GraphStream
//        graph.getEdge(idArista).setAttribute("ui.label", idArista + " (" + arista.getdistancia() + ")");


}
          
    /**
     * Metodo para graficar el grafo 
     */ 
    
    
    public void mostrarGrafo() {        
        
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new MultiGraph("Grafo");
        
        String styleSheet =  //En teoría esto es para el CSS del código
        "node {" +
        "   size: 20px;" +
        "   shape: circle;" +
        "   fill-color: white;" +
        "   stroke-mode: plain;" +
        "   stroke-color: black;" +
        "   stroke-width: 2px;" +
        "}" +
        "edge {" +
        "   shape: line;" +
        "   fill-color: black;" +
        "   size: 2px;" +
        "}";
        
        graph.setAttribute("ui.stylesheet", styleSheet);

        
        for (int i = 0; i < this.vertices.getSize(); i++) { //Para agregar los vertices
            Vertice vertice = (Vertice) this.vertices.get(i);
            int idVertice = vertice.getValor();
            graph.addNode(Integer.toString(idVertice));
            graph.getNode(Integer.toString(idVertice)).setAttribute("ui.label", Integer.toString(idVertice));
            
        }
        
        for (int i = 0; i < this.aristas.getSize(); i++) { //Para agregar las aristas
            Arista arista = (Arista) this.aristas.get(i);
            int idOrigen = arista.getOrigen().getValor();
            int idDestino = arista.getDestino().getValor();
            double distance = arista.getDistancia();
            System.out.println(idOrigen + "---" +  idDestino + "---" + distance);
            graph.addEdge(Integer.toString(i), Integer.toString(idOrigen), Integer.toString(idDestino));
            graph.getEdge(Integer.toString(i)).setAttribute("ui.label", Double.toString(distance));
        }
        
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
//        GrafoVisual frame = new GrafoVisual(null);  //PENDIENTE!
        
//
//        ViewPanel viewPanel = (ViewPanel) viewer.getDefaultView();
//        viewPanel.setPreferredSize(new java.awt.Dimension(800, 600));
//
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.pack();
//        viewer.enableAutoLayout();
       
            
        
            }
    
//    public void eliminarVertice(int id){
//        if(isVertex(id)){
//            for (int i = 0; i < this.aristas.getSize(); i++) {
//                Arista arista = this.aristas.get(i);
//                if(arista.getDestino().getValor() == id || arista.getOrigen().getValor() == id){
//                    this.aristas.pop(i);
//                }
//            }
//            for (int i = 0; i < this.vertices.getSize(); i++) {
//                Vertice vertex = this.vertices.get(i);
//                if(vertex.getValor() == id){
//                    this.vertices.pop(i);
//                }
//            }
//        }   
//     }
    public void eliminarVertice(int id){
        for (int i = 0; i < this.aristas.getSize();) {
            Arista auxEdge = this.aristas.get(i);
            
            int auxIdA = auxEdge.getOrigen().getValor();
            int auxIdB = auxEdge.getDestino().getValor();
            
            if(auxIdA == id){
                this.aristas.pop(i);
            }
            else if(auxIdB == id){
                this.aristas.pop(i);              
            }
            else{
                i++;
            }
        }
        
        for (int i = 0; i < this.vertices.getSize(); i++) {
            Vertice auxVertex = this.vertices.get(i);
            
            int auxId = auxVertex.getValor();
            
            if(auxId == id){
                this.vertices.pop(i);
                this.size--;
            }
        }
    }        
        
   
    
    public void eliminarArista(int idA, int idB, double distancia){
        if(isEdge(idA, idB, distancia)) { //Ambos deben ser verticews
            for (int i = 0; i < this.aristas.getSize(); i++) {
                Arista auxArista = (Arista) aristas.get(i);
                if((auxArista.getOrigen().getValor() == idA && auxArista.getDestino().getValor() == idB) || (auxArista.getOrigen().getValor() == idB && auxArista.getDestino().getValor() == idA)){
                    if(auxArista.getDistancia() == distancia){
                        this.aristas.pop(i);
                    }
            }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No existe una relación para eliminar");
        }
            
    }
    
    
//    // posiblemente comentar
//    public List adyVertex(int id){
//        
//        for (int i = 0; i < this.aristas.getSize(); i++) {
//            Arista auxEdge = (Arista) this.aristas.get(i);
//            
//            int auxIdA = auxEdge.getOrigen().getValor();
//            int auxIdB = auxEdge.getDestino().getValor();
//            
//            
//            
//            
//            
//        }
//        return null;
//    }
//    
//    
//    public void algoritmoRecorrido(int start, int end){
//        
//        List<Integer> visited = new List(100);
//        visited.insertarFinal(start);
//        
//        Tag startTag = new Tag(start, null, 0, 0);
//        List<Tag> tags = new List(100);
//        tags.insertar(startTag);
//        
//        //Nodo fijo
//        int current = start;
//        int counter = 0;
//        double currentDistance = 0;
//        
//        while(visited.getSize() != this.size){
//            for (int i = 0; i < tags.getSize(); i++) {
//                Tag auxTag = (Tag) tags.get(i);
//                int Node = auxTag.getNode();
//                if(Node == current){
//                    currentDistance = auxTag.getDistance();
//                }
//            }
//            
//            counter++;
//            List<Arista> adyVertex = adyVertex(current);
//            
//            //Hallar nodos adyacentes al fijo
//            List<Tag> adyTag = new List(100);
//            for (int i = 0; i < adyVertex.getSize(); i++) {
//                Arista auxEdge = (Arista) adyVertex.get(i);
//                
//                int auxIdA = auxEdge.getOrigen().getValor();
//                int auxIdB = auxEdge.getDestino().getValor();
//                double distance = auxEdge.getdistancia();
//                
//                if(auxIdA == current){
//                    if(!visited.contiene(auxIdB)){                       
//                        Tag newTag = new Tag(auxIdB, auxIdA, (currentDistance + distance), counter);
//                        tags.insertarFinal(newTag);
//                        adyTag.insertarFinal(newTag);                       
//                    }
//                }
//                else if(auxIdB == current){
//                    if(!visited.contiene(auxIdA)){
//                        Tag newTag = new Tag(auxIdA, auxIdB, (currentDistance + distance), counter);
//                        tags.insertarFinal(newTag);
//                        adyTag.insertarFinal(newTag);                        
//                    }
//                }           
//            }
//                                    
//            //Si el fijo no tiene nodos adyacentes
//            if(adyTag.isEmpty()){
//                
//                //Hallar tag de inicio que no este visitado
//                Tag currentTag = null;
//                for (int i = 0; i < tags.getSize(); i++) {
//                    Tag auxTag = (Tag) tags.get(i);                   
//                    if(!visited.contiene(auxTag.getNode())){
//                        currentTag = auxTag;
//                    }
//                }
//                
//                if(currentTag != null){
//                    //Hallar tag con menor distancia
//                    tags.print();
//                    for (int i = 0; i < tags.getSize(); i++) {
//                        Tag auxTag = (Tag) tags.get(i);
//                        if(!visited.contiene(auxTag.getNode())){
//                            if(auxTag.getDistance() < currentTag.getDistance()){
//                                currentTag = auxTag;
//                            }
//                        }
//                    }
//                    //System.out.println(currentTag.getNode());
//                    current = currentTag.getNode();
//                    visited.insertarFinal(current);                    
//                }
//                
//            }
//            //Si el fijo tiene nodos adyacentes
//            else{               
//                Tag currentTag = (Tag) adyTag.get(0);                
//
//                for (int i = 0; i < adyTag.getSize(); i++) {
//                    Tag auxTag = (Tag) adyTag.get(i);
//
//                    if(auxTag.getDistance() < currentTag.getDistance()){
//                        currentTag = auxTag;
//                    }
//                }
//                
//                current = currentTag.getNode();
//                visited.insertarFinal(current);
//            }          
//        }
//        
//        Tag endTag = null;
//        for (int i = 0; i < tags.getSize(); i++) {
//            Tag auxTag = (Tag) tags.get(i);
//            
//            if(end == auxTag.getNode()){
//                endTag = auxTag;
//            }                        
//        }
//       
//        Tag currentTag = endTag;
//        while(currentTag.getPrev() != null){
//            System.out.print(currentTag.getNode() + " ");
//            List prevTag = new List(100);
//            int prev = (int) currentTag.getPrev();
//            
//            for (int i = 0; i < tags.getSize(); i++) {
//                Tag auxTag = (Tag) tags.get(i);
//                if(auxTag.getNode() == prev){
//                    prevTag.insertarFinal(auxTag);
//                }
//            }
//            
//            if(prevTag.getSize() == 1){
//                currentTag = (Tag) prevTag.getLast();
//            }
//            else{
//                Tag minTag = (Tag) prevTag.getLast();
//                for (int i = 0; i < tags.getSize(); i++) {
//                    Tag auxTag = (Tag) tags.get(i);
//                    if(auxTag.getNode() == prev){
//                        if(auxTag.getDistance() < minTag.getDistance()){
//                            minTag = auxTag;
//                        }
//                    }
//                }
//                currentTag = minTag;
//            }
//        }
//        System.out.print(start);
//        tags.print();
//        
//    }
//    
//    
//    public void algoritmo(int start, int end){
//        List visited = new List(100);
//        visited.insertar(start);
//        Tag startTag = new Tag(start, null, 0, 0);
//        
//        List<Tag> tags = new List(100);
//        tags.insertar(startTag);
//        
//        //Nodo Fijo
//        int current = start; 
//        int counter = 0;
//        
//        while(visited.getSize() != this.size) {
//            List adyVertex = adyVertex(current);
//            counter ++;
//            
//            List<Tag> adyTag = new List(100);
//            for (int i = 0; i < adyVertex.getSize(); i++) {
//                Arista auxEdge = (Arista) adyVertex.get(i);
//                
//                int auxIdA = auxEdge.getOrigen().getValor();
//                int auxIdB = auxEdge.getDestino().getValor();
//                double distance = auxEdge.getdistancia();
//                
//                if(auxIdA == current){
//                    
//                    if(!visited.contiene(auxIdB)){
//                        Tag newTag = new Tag(auxIdB, auxIdA, distance, counter);
//                        tags.insertar(newTag);
//                        adyTag.insertar(newTag);
//                        
//                    }
//                    
//                }
//                else if(auxIdB == current){
//                    
//                    if(!visited.contiene(auxIdA)){
//                        Tag newTag = new Tag(auxIdA, auxIdB, distance, counter);
//                        tags.insertar(newTag);
//                        adyTag.insertar(newTag);
//                        
//                    }
//                    
//                }
//            }
//            
//            // Si el fijo no tiene nodos adyacentes. 
//            if(adyTag.isEmpty()) {
//                
//                //Hallar la etiqueta con menor distancia 
//                Tag currentTag = null;
//                for (int i = 0; i < tags.getSize(); i++) {
//                    Tag auxTag = (Tag) tags.get(i);
//                    
//                    if(!visited.contiene(auxTag.getNode())){
//                        currentTag = auxTag;
//                    }
//                }
//
//
//                if(currentTag != null){
//                    // Hallar tag con menor distancia
//                    for (int i = 0; i < tags.getSize(); i++) {
//                        Tag auxTag = (Tag) tags.get(i);
//                        
//                        if(auxTag.getDistance() < currentTag.getDistance()){
//                            currentTag = auxTag;
//                        }
//                            
//                    }
//                    current = currentTag.getNode();
//                    visited.insertar(current); 
//                }
//                
//            }
//
//            //Si el fijo tiene nodos adyacentes existen 
//            else{
//                    
//                Tag currentTag = (Tag) adyTag.get(0);
//                for (int i = 0; i < adyTag.getSize(); i++) {
//                    Tag auxTag = (Tag) adyTag.get(i);
//
//                    if(auxTag.getDistance() < currentTag.getDistance()){
//                        currentTag = auxTag;
//                    }
//                }
//                current = currentTag.getNode();
//                visited.insertar(current);
//            }// Cierra el else
//          
//        }// Cierra el while
//        
//        Tag endTag = null;
//        for (int i = 0; i < tags.getSize(); i++) {
//            Tag auxTag = (Tag) tags.get(i);
//            
//            if(end == auxTag.getNode()){
//                endTag = auxTag;
//                
//            }
//            
//        }
//        Tag currentTag = endTag;
//        while(currentTag.getPrev() != null){
//            int prev = (int) currentTag.getPrev();
//            for (int i = 0; i < tags.getSize(); i++) {
//                System.out.println(currentTag.getNode() + " ");
//                Tag auxTag = (Tag) tags.get(i);
//                
//                if(auxTag.getNode() == prev){
//                    currentTag = auxTag;
//                }
//                
//                
//            }
//            
//        }
//        System.out.print(start);
//        
        
// posiblemente comentar final
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}// Cierra la clase
