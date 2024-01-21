package RandomTreeAlgos;

import Graph.Edge;
import Graph.Graph;

import java.util.ArrayList;
import java.util.Random;

public class AldousBroder {
    public void aldousBroder(Graph graph){
        Random random = new Random();

        //On fait une liste des sommets parcouru (vide pour l'instant) de notre graphe (memoire pour le while) et une
        // liste d'aretes qui correspondent a la premiere entree d'un nouveau sommet

        //        List<Integer> vertexCovered = IntStream.range(0,graph.upperBound)
        //                .boxed()
        //                .collect(Collectors.toList());

        //        List<Edge> firstEdge = Collections.nCopies(graph.upperBound, null);
        //        System.out.println(firstEdge);

        ArrayList<Integer> vertexCovered = new ArrayList<>();
        ArrayList<Edge> firstEdges = new ArrayList<>();

        for (int i=0 ; i<graph.upperBound ; i++){
            firstEdges.add(null);
        }

        // on selectionne le premier sommet pour commencer notre algo, que nous rajoutons a notre memoire
        int actualVertex = random.nextInt(graph.upperBound);
        vertexCovered.add(actualVertex);
        // On signifie que c est notre premier sommet (source) avec Edge(actualVertex,actualVertex,0)
        Edge defaultEdge = new Edge(actualVertex,actualVertex,0);
        firstEdges.set(actualVertex,defaultEdge);


         while (vertexCovered.size() != graph.upperBound){

             ArrayList<Integer> neighbours = new ArrayList<>();

             for (Edge edge : graph.incidency.get(actualVertex)){
                 // On selectionne les sommets voisins de notre graphe et non le sommet actuel
                 if (edge.source  != actualVertex){
                     neighbours.add(edge.source);
                 }else{
                     neighbours.add(edge.dest);
                 }
             }
             System.out.println(neighbours);

             // On selectionne ensuite un de ces sommets au hasard et on le definit comme actualVertex.
             int indexNewActualVertex = random.nextInt(neighbours.size());
             int exActualVertex = actualVertex;
             actualVertex = neighbours.get(indexNewActualVertex);
             System.out.println("new actualVertex : " + actualVertex);
             if (!vertexCovered.contains(actualVertex)) {
                 vertexCovered.add(actualVertex);

                 //On ajoute l arete correspondant a notre premier passage dans le sommet
                 Edge edgeFromSource = new Edge(exActualVertex,actualVertex,1);
                 if(firstEdges.get(actualVertex) == null){
                     //
                 }
             }

         }
        System.out.println(firstEdges);




    }
}
