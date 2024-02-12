/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Estructuras.Archivo;
import Estructuras.ListaArray;
import Interfaces.GrafoVisual;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.graph.Node;

/**
 *
 * @author Antonella
 * @param <E>
 */
public class Grafo<E> {
    private final ListaArray<Vertice> vertices;
    private final ListaArray<Arista> aristas;
    private final Graph graph;

    public Grafo() {
        this.vertices = new ListaArray<>(100);
        this.aristas = new ListaArray<>(100);
        this.graph = new SingleGraph("MiGrafo");
    }
    
    public void construir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            Vertice vertice = new Vertice(i + 1);
            AgregarVertice(vertice);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    int distancia =new Archivo().obtenerDistancia(Integer.toString(i + 1), Integer.toString(j + 1));
                    Arista arista = new Arista(vertices.get(i), vertices.get(j),distancia);
                    AgregarArista(arista);
                }
            }
        }
          mostrarGrafo();
    }
    
    
    public void AgregarVertice(Vertice vertice){
      
            vertices.insertar(vertice);
             String idVertice = Integer.toString(vertice.valor);
            graph.addNode(idVertice);
            graph.getNode(idVertice).setAttribute("ui.label", idVertice);
            graph.getNode(idVertice).setAttribute("ui.style", "text-alignment: under;");
        
            
    }
    public void AgregarArista(Arista arista){
            aristas.insertar(arista);
            String idArista = arista.getOrigen().valor+ "-" + arista.getDestino().valor; // Crear un ID para la arista
        graph.addEdge(idArista, Integer.toString(arista.getOrigen().valor), Integer.toString(arista.getDestino().valor),true); // Agrega la arista al grafo de GraphStream
        graph.getEdge(idArista).setAttribute("ui.label", idArista + " (" + arista.getdistancia() + ")");
}
          
            
    public void mostrarGrafo() {
        // Crea un visor de Swing para el grafo
        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer = graph.display();
        
        GrafoVisual frame=new GrafoVisual();
        JPanel Panel= frame.getPanel();
        Panel.setLayout(new BorderLayout());

        ViewPanel viewPanel = (ViewPanel) viewer.getDefaultView();
        viewPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        viewer.enableAutoLayout();
        
            }
    
}


