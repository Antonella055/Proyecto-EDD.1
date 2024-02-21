/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hormigas;

import Estructuras.Archivo;
import Estructuras.HashMap;
import Estructuras.ListaArray;
import Grafo.Grafo;
import Grafo.Vertice;
import Interfaces.MenuSimulacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Antonella
 */
public class Colonia {
    private ListaArray<Integer> caminoMasCorto;
    private ListaArray<Hormiga> Hormigas;
    private double[][] feromonas;
    private double[][] distancias;
    
    
    // Asignados por el usuario
    private double α;
    private double β;
    private double ρ;
    private int ciudad_inicio;
    private int ciudad_destino;
    private int nro_ciclos;
    private int nro_hormigas;

    public Colonia() {
        
        MenuSimulacion datos = new MenuSimulacion();
        try {
        BufferedReader reader = new BufferedReader(new FileReader("informacionSimulacion.txt"));
        String linea;
        String[] valores = new String[3]; // Suponiendo que hay 3 líneas en el archivo

        for (int i = 0; i < 3; i++) {
            linea = reader.readLine();
            valores[i] = linea.trim();
        }

        String[] inicioDestino = valores[0].split(",");
        String[] hormigasCiclos = valores[1].split(",");
        String[] feromonasVisibilidadEvaporacion = valores[2].split(",");

        
        this.ciudad_inicio =  Integer.parseInt(inicioDestino[0]);
        this.ciudad_destino = Integer.parseInt(inicioDestino[1]);
        
        this.nro_hormigas =Integer.parseInt(hormigasCiclos[0].trim());
        this.nro_ciclos =Integer.parseInt(hormigasCiclos[1].trim());
        
        this.α = Double.parseDouble(feromonasVisibilidadEvaporacion[0].trim());
        this.β = Double.parseDouble(feromonasVisibilidadEvaporacion[1].trim());
         this.ρ =Double.parseDouble (feromonasVisibilidadEvaporacion[2].trim());

        reader.close(); // Cerrar el BufferedReader 
    } catch (IOException e) {
        System.out.println("Ocurrió un error al leer el archivo.");
        e.printStackTrace();
    }
       
        
        Inicializar();
        Hormigas= new ListaArray<>(nro_hormigas);

        for (int i = 0; i < nro_hormigas; i++) {
            Hormiga hormiga=new Hormiga(this.ciudad_inicio, this.feromonas, this.distancias,this.ciudad_destino,this.α,this.β);
            this.Hormigas.insertar(hormiga);
        }
        
    }

    public int getCiudad_inicio() {
        return ciudad_inicio;
    }

    public int getCiudad_destino() {
        return ciudad_destino;
    }

    
    
    
    public void Inicializar(){
        Archivo data= new Archivo();
        
         HashMap<String, ListaArray> relaciones = data.leerRelaciones();
         ListaArray<String> ciudades=data.obtCiudades(relaciones);
        
        distancias=new double[ciudades.getSize()][ciudades.getSize()];
        feromonas=new double[ciudades.getSize()][ciudades.getSize()];
        
        for (int i = 0; i < ciudades.getSize(); i++) {
            for (int j = 0; j < ciudades.getSize(); j++) {
                distancias[i][j]= data.obtenerDistancia(ciudades.get(i).toString(), ciudades.get(j).toString());
                feromonas[i][j]= 1.0/ ciudades.getSize();
            }
        }
    }
    
        public void ejecutarAntSystem(Grafo grafo) {
           for (int ciclo = 0; ciclo < nro_ciclos; ciclo++) {
               for (int h = 0; h < nro_hormigas; h++) {
                   Hormiga hormiga = (Hormiga) Hormigas.get(h);
                   hormiga.ConstruirSolucion(grafo);
                   
                   
               }
               actualizarFeromonas();
               reiniciarHormigas();
           }
       
}
        private void actualizarFeromonas(){
            for (int i = 0; i < feromonas.length; i++) {
                for (int j = 0; j < feromonas[i].length; j++) {
                    feromonas[i][j] *= (1 - ρ); // Evaporación
                    for (int k = 0; k < Hormigas.getSize(); k++) {
                        Hormiga hormiga= (Hormiga) Hormigas.get(k);
                        feromonas[i][j] += hormiga.depositarFeromonas(i, j);
                    }
            }
                
            }
        }
        
    private void reiniciarHormigas(){
        for (int i = 0; i < 10; i++) {
            Hormiga hormiga =(Hormiga) Hormigas.get(i);
            hormiga.reiniciar(ciudad_inicio);
        }
    }
        
        

   public int getNro_hormigas() {
        return nro_hormigas;
    }
   public ListaArray<Integer> dijkstra(Grafo grafo) {
        // Asume que la hormiga 0 es la que va a realizar el camino
        Hormiga hormiga = (Hormiga) Hormigas.get(0);
        return grafo.dijkstra(hormiga.ciudadActual, hormiga.ciudad_destino);
    }
   

}
