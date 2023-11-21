package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Graph {
    // classe de graphe non orientés permettant de manipuler
    // en même temps des arcs (orientés)
    // pour pouvoir stocker un arbre couvrant, en plus du graphe

    public int order;
    public int upperBound;
    int edgeCardinality;
    public boolean[] vertecies;

    ArrayList<LinkedList<Edge>> incidency;
    ArrayList<LinkedList<Arc>> inIncidency;
    ArrayList<LinkedList<Arc>> outIncidency;

    public Graph(int upperBound) {
        this.order = upperBound;
        this.upperBound = upperBound;
        
        // Au début, upperBound==order
        // Ensuite, on pourrait retirer des sommets du graphe.
        // Ainsi, on pourrait avoir upperBound > order
        // Cette modification de la classe devient nécessaire
        // si vous implémentez la contraction d’arêtes
        // Autrement, on pourra asssumer que upperBound==order.

        // à compléter
    }

    public boolean isVertex(int vertex) {
        return vertecies[vertex];
    }

    public void addVertex(int vertex) {
        try {
            vertecies[vertex] = true;
        }
        catch (Exception e){
            System.out.print("Your vertex surpasses the upperbound!");
            throw new IndexOutOfBoundsException();
        }

    }

    public void deleteVertex(int vertex){
        try {
            vertecies[vertex] = false;
        }
        catch (Exception e){
            System.out.print("Your vertex surpasses the upperbound!");
            throw new IndexOutOfBoundsException();
        }
    }

/*    public void ensureVertex(int vertex) {

    }*/

    public void addArc(Arc arc) {/*
        try {
            this.inIncidency.add(new LinkedList<>(List.of(arc)));
        }catch (Exception e){
            System.out.print("Arc couldn't be added");
        }*/
    }

    public void addEdge(Edge edge) {
        try {
            this.incidency.add(new LinkedList<>(List.of(edge)));
        }catch (Exception e){
            System.out.print("Edge couldn't be added");
        }
    }

    public Arc[] outEdges(int vertex) {
        // à modifier, si nécessaire

        // Pour la prochaine ligne voir
        // https://www.baeldung.com/java-collection-toarray-methods
        return outIncidency.get(vertex).toArray(new Arc[0]);
   }

}
