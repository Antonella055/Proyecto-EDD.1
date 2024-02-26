/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Giuseppe Vaccaro
 */
public class Tag<T> {
    private int node;
    private T prev;
    private double distance;
    private int iteracion;

    public Tag(int node, T prev, double distance, int iteracion) {
        this.node = node;
        this.prev = prev;
        this.distance = distance;
        this.iteracion = iteracion;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public T getPrev() {
        return prev;
    }

    public void setPrev(T prev) {
        this.prev = prev;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }
    
    
}
