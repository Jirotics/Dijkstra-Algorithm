/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijspp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejiroghene
 */
public class Vertex {
    private final int name; 
    private int weight;
    private final List<Edge> edges = new ArrayList();
    
    public Vertex(int vertex){
        this.name = vertex; 
        if(name==0){
            weight = 0;
        }else
            weight = 99999999;
    }
    
    public void addEdge(int vertex, int weight){
        Edge e = new Edge(vertex, weight);
        edges.add(e);
    }
    
    public int getName(){
        return name;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    
    public void pEdges(){
        Edge e;
        for(int i=0; i<edges.size(); i++){
            e = edges.get(i);
            System.out.println(e.getVertex()+ " " + e.getWeight());
        }
    }
    
    public List getEdges(){
        return edges;
    }
    
    public  String toString(){
        return ""+getWeight();
    }
}
