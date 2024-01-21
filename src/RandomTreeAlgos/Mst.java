package RandomTreeAlgos;

import Graph.Edge;
import Graph.Graph;

import java.util.ArrayList;
import java.util.Random;

public class Mst {

    public ArrayList<Edge> mst(Graph graph) {
        System.out.println(graph);

        for (Edge edge : graph.edgeNumber) {
            Random random = new Random();
            double randomWeight = random.nextDouble();
            edge.weight = randomWeight;
        }

        System.out.println(graph);
        Kruskal kruskal = new Kruskal();

        return kruskal.treeGraph(graph);
    }
}
