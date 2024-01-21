package Graph;

import java.util.ArrayList;
import java.util.LinkedList;


public class Graph {
    // classe de graphe non orientés permettant de manipuler
    // en même temps des arcs (orientés)
    // pour pouvoir stocker un arbre couvrant, en plus du graphe

    public int order;
    // nombre de sommets dans le graphe

    public int upperBound;
    int edgeCardinality;
    // nombre d'arêtes

    public ArrayList<LinkedList<Edge>> incidency;
    //Liste[sommet] = [arête du sommets]
    ArrayList<LinkedList<Arc>> inIncidency;
    // Liste[sommet]= [arcs entrants]
    ArrayList<LinkedList<Arc>> outIncidency;
    // Liste[sommet]= [arcs sortants]

    public ArrayList<Edge> edgeNumber;

    public Boolean oriented;
    // Pour savoir si notre graphe est orienté ou non


    public Graph(int upperBound) {
        // Au début, upperBound==order
        // Ensuite, on pourrait retirer des sommets du graphe.
        // Ainsi, on pourrait avoir upperBound > order
        // Cette modification de la classe devient nécessaire
        // si vous implémentez la contraction d’arêtes
        // Autrement, on pourra asssumer que upperBound==order.

        this.incidency = new ArrayList<>();
        this.order = upperBound;
        this.upperBound = upperBound;
        this.outIncidency = new ArrayList<>();
        this.inIncidency = new ArrayList<>();
        this.edgeNumber = new ArrayList<>();
        this.edgeCardinality = 0;
        this.oriented = null;


        for (int i = 0; i < this.upperBound; i++) {
            incidency.add(new LinkedList<Edge>());
        }
    }

    public boolean isVertex(int vertex) {
        if ((vertex <= this.order) | (vertex < 0)) {
            return false;
        }
        return true;
    }

    public void addVertex(int vertex){
            this.incidency.add(new LinkedList<>());
            this.order ++;

    }

    public void deleteVertex(int vertex){
        LinkedList<Edge> deletedEdges = this.incidency.get(vertex);
        this.incidency.remove(vertex);
        for (Edge edge : deletedEdges){
            for (LinkedList list : this.incidency){
               if(list.contains(edge)){
                   list.remove(edge);
                   this.edgeNumber.remove(edge);

               }
            }
        }
        this.order = this.order - 1;


    }

    public void ensureVertex(int vertex) {
        if (isVertex(vertex)){
            // Cette fonction sert à obtenir un order égale au nombre de sommets de notre graphe
            while ( order <= vertex ) {
                addVertex(order);
            }
        }
    }

    public void addArc(Arc arc) {

        this.oriented = true;
        int source = arc.getSource();
        int destination = arc.getDest();

        ensureVertex(source);
        ensureVertex(destination);

        outIncidency.get(source).add(arc);
        inIncidency.get(source).add(arc);


    }

    public void addEdge(Edge edge) {

        this.oriented = false;

        int vertex1 = edge.source;
        int vertex2 = edge.dest;

        ensureVertex(vertex1);
        ensureVertex(vertex2);

        incidency.get(vertex1).add(edge);
        incidency.get(vertex2).add(edge);
        if (!edgeNumber.contains(edge)){
            edgeNumber.add(edge);
            edgeCardinality ++;
        }


    }

    public Arc[] outEdges(int vertex) {
        // à modifier, si nécessaire

        // Pour la prochaine ligne voir
        // https://www.baeldung.com/java-collection-toarray-methods
        return outIncidency.get(vertex).toArray(new Arc[0]);
   }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of Edges : ").append("\n");

        for (Edge edge : this.edgeNumber){
            stringBuilder.append(edge);
        }
        stringBuilder.append("\n");

        if (this.oriented == null){
            for (int i = 0; i < this.order; i++) {
                stringBuilder.append("Vertex ").append(i);
                stringBuilder.append("\n");
            }
        } else if (this.oriented == false) {


            for (int i = 0; i < this.order; i++) {
                stringBuilder.append("Vertex ").append(i).append(": ");
                for (Edge edge : this.incidency.get(i)) {
                    stringBuilder.append(edge.source).append("-").append(edge.dest).append(" ");
                    stringBuilder.append(" | Weight : " + edge.weight + " || ");
                }
                stringBuilder.append("\n");
            }
        }else{
            for (int i = 0; i < this.order; i++) {
                stringBuilder.append("Vertex ").append(i).append(": ");
                for (Arc arc : this.outIncidency.get(i)) {
                    stringBuilder.append("outIncidency ").append(arc.getSource()).append("-").append(arc.getDest()).append(" ");
                }
                stringBuilder.append("\n");
                for (Arc arc : this.inIncidency.get(i)){
                    stringBuilder.append("inIncidency ").append(arc.getSource()).append("-").append(arc.getDest()).append(" ");
                }
            }

        }
        return stringBuilder.toString();
    }
    }

