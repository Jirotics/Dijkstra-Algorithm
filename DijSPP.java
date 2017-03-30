/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijspp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Ejiroghene
 */
public class DijSPP {

    /**
     * @param args the command line arguments
     */
    private static List<Vertex> vert;// arraylist of all vertices
    private static int[] pos; // array to keep track of position in binary heap
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        String txt = sc.nextLine();
        File file = new File(txt);//file path here
        
          try{
            Scanner in = new Scanner(file);
            
            createGraph(in);
            dijAlgo();
            
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    public static void createGraph(Scanner in){
        String x;
        Vertex v = new Vertex(-1);
        Vertex v2 = new Vertex(-1);
        int name, vertex, weight;
        x = in.nextLine();
        int i = x.indexOf("m");
        int j = x.indexOf("=");
        x = x.substring(j+1, i);
        x = x.trim();
        int num = Integer.parseInt(x);// number of vertices
        vert = new ArrayList(num);
        pos = new int[num];
        String[] parts = new String[2];
        int t;
        
        for(int z=0; z<num; z++){//create vertices
            pos[z] = z;
            v = new Vertex(z);
            vert.add(v);
        }
        while(in.hasNextLine()){//add edges
            x = in.nextLine(); 
            
            if(Pattern.matches(" +\\d+ +\\d+", x)){//regex to find edges pattern
                t = x.lastIndexOf(" ");
                parts[0] = x.substring(0, t);
                parts[1] = x.substring(t);    
                parts[0] = parts[0].trim();
                parts[1] = parts[1].trim();
                vertex = Integer.parseInt(parts[0]);
                weight = Integer.parseInt(parts[1]);
                v2 = vert.get(vertex);
                v.addEdge(vertex, weight);
                v2.addEdge(v.getName(), weight);
            }
            else if(Pattern.matches("\\d+", x)){//regex to find vertex pattern
                x = x.trim();
                name = Integer.parseInt(x);
                v = vert.get(name);
            }
            
        }
        

    }
    
    public static void dijAlgo(){
        Vertex v;
        int tot = 0;
        int siz, curW, chVert, chWeigh;
        List<Edge> edges;
       while(vert.size()>0){
            siz = vert.size()-1;
            v = vert.get(0);   
            swap(0, siz);
            edges = v.getEdges();
            curW = v.getWeight();
            tot += curW;
            vert.remove(siz);
            binDelete();
            pos[v.getName()] = -1;
           for(Edge e: edges){
               chVert = e.getVertex();
               chWeigh = e.getWeight();
               if(pos[chVert]!=-1){
                   v = vert.get(pos[chVert]);
                   chWeigh = curW + e.getWeight();
                   if(chWeigh<v.getWeight()){
                       v.setWeight(chWeigh);
                       modWeight(pos[chVert]);
                   }
               }
           }

        }
     System.out.println(tot);
    }
    
    public static void binDelete(){//sorts binary heap on min extraction
        int min;
        int p = 0;
        int x, y;
        while(true){
           min = minChild(p);
           if(min==-1){
               break;
           }           
           else if(vert.get(p).getWeight()>vert.get(min).getWeight()){
               swap(p, min);
               p = min;
           }else{
               break;
           }
            
        }
        
    }
    
    public static void swap(int i, int j){
        int sw, name1, name2;
        name1 = vert.get(i).getName();
        name2 = vert.get(j).getName();
        Collections.swap(vert, i, j);
        sw = pos[name1];
        pos[name1] = pos[name2];
        pos[name2] = sw;
    }
    
    public static int minChild(int pos){//finds the minimum of the parent children
        Vertex leftV, rightV;
        int right = pos*2 +2;
        int left = pos*2 +1;
        if(left>vert.size()-1){
            return -1;
        }
        else if(right>vert.size()-1){
            return left;
        }
        
        leftV = vert.get(left);
        rightV = vert.get(right);
        if(leftV.getWeight()<rightV.getWeight()){
            return left;
        }else{
            return right;
        }
    }
    
    public static void modWeight(int p){//sorts binary tree when weight changes
        int up;
        while(true){
            if(p%2==0){
                up = (p-1)/2;
            }else{
                up = (p)/2;
            }
            
            if(vert.get(p).getWeight()<vert.get(up).getWeight()){
                swap(p, up);
                p = up;
            }else{
                break;
            }
        }
    }
            
    
}
