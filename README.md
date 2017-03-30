# Dijkstra-Algorithm
# This code implements Dijkstra's algorithm for single source shortest path. The code uses binary heap to implement the priority queue. 
  The program has 2 classes the vertex and the edge class. The vertex
can have 0 or more edges. All vertices put together in an arraylist form the graph. The program works for an undirected graph,
but will also work for a directed graph by modifying out lines 52, 81, and 83. The program has 2 main variables, an arraylist
used to represent the binary heap, and an array used to keep track of each vertex's location.

INPUT FORMAT: The first line of each file below contains the number of vertices and the number of edges in the graph 
(in the format "n=XXXX m=XXXXX"). The rest of the file is organized as follows: 
each vertex i appears on a line by itself, followed by a line for each neighbor j>i of i 
(containing j and the length of edge (i,j)). Each list of neighbors is ended by an empty line. 
Vertices i which do not have neighbors with an index greater than i are not represented. 
NOTE: Vertices are indexed from 0 to n-1. 
NOTE: each edge is mentioned only once with its smaller number endpoint 
