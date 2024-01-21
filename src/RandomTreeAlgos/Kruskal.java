package RandomTreeAlgos;

import Graph.Edge;
import Graph.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    public Graph graph;

    public ArrayList<Edge> treeGraph(Graph graph){
        this.graph = graph;
        ArrayList<Integer> vertexMemory = new ArrayList<>();
        // Tri de la liste des arêtes
        Collections.sort(graph.edgeNumber);

        // Nouvel arbre
        Graph spanningTree = new Graph(graph.upperBound);


        // On regarde avant chaque ajout s'il n'y a pas de cycle
        // donc si |E|<=|V|+1


        for (int i = 0 ; i<= graph.edgeNumber.size()-1; i ++){

            Edge edge = graph.edgeNumber.get(i);

            if (!vertexMemory.contains(edge.dest)){
                vertexMemory.add(edge.dest);
            }
            if (!vertexMemory.contains(edge.source)){
                vertexMemory.add(edge.source);
            }
            int n = vertexMemory.size() ;

            // On vérifie que nous avons bien un arbre connexe
            if ((spanningTree.edgeNumber.size() + 1 == n-1 ) && (!spanningTree.edgeNumber.contains(edge))){
                spanningTree.addEdge(edge);

            }
        }
        return spanningTree.edgeNumber;

        }
    }


