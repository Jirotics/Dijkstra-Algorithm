/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijspp;

/**
 *
 * @author Ejiroghene
 */
public class Edge {
    private final int weight;
    private final int vertex;
    
    public Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
    
    public int getVertex(){
        return vertex;
    }
    
    public int getWeight(){
        return weight;
    }
}
