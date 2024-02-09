/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Estructuras.HashMap.Entry;


/**
 *
 * @author Antonella
 */
public class Matriz extends Archivo {
    private static int [][]matriz;
   

    public Matriz() {
        this.matriz = null;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    public int[][] Crear(HashMap<String, ListaArray> relaciones,ListaArray<String> ciudades) {
    int n = ciudades.getSize(); // Obtener el tamaño del HashMap
    matriz = new int[n][n];

    //Inicializar Matriz
    for (int i = 0; i < n; i++) { 
        for (int j = 0; j < n; j++) {
            matriz[i][j] = 0;
        }
    }
    //Uso del hash para las Aristas
    
    for(Entry<String, ListaArray> entrada : relaciones.tabla){
        if(entrada!=null){
            String origen= entrada.clave;
            int IndiceOrigen=ciudades.indiceDe(origen);
            ListaArray<String> destinos=entrada.valor;
            
            for (int i = 0; i < destinos.getSize(); i++) {
                String destino = (String) destinos.get(i);
                int IndiceDestino=ciudades.indiceDe(destino);
                 if (IndiceOrigen != -1 && IndiceDestino != -1) {
                     //revisar si hay distancia entre las ciudades
                     matriz[IndiceOrigen][IndiceDestino]=1;
                 }
                
                
            }
        }
    }

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] == 1) {
                System.out.println("Hay conexion entre la ciudad " + ciudades.get(i) + " y la ciudad " + ciudades.get(j));
            
            }
        }
    }


    return matriz;
}

    public void imprimirMatriz(int[][] matriz) {
        
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println(); // Salto de línea al final de cada fila
    }
}
    public int size(){
        return matriz.length;
    }
   
}
    
    
