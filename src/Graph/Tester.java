package Graph;

import RandomTreeAlgos.AldousBroder;
import RandomTreeAlgos.Kruskal;
import RandomTreeAlgos.Mst;
import org.junit.jupiter.api.Test;

public class Tester {
    Graph graph1 = new Graph(4);
    Edge edge1 = new Edge(1,2,3);
    Edge edge2 = new Edge(2,3,0.8);
    Edge edge3 = new Edge(3,1,4);
    Edge edge4 = new Edge(0,1,12);

    @Test
    public void Graphtest(){
        graph1.addEdge(edge1);
        graph1.addEdge(edge2);
        System.out.println(graph1.order);
        System.out.println(graph1);
        graph1.deleteVertex(2);
        System.out.println(graph1);
        graph1.addVertex(3);
        System.out.println(graph1);

    }

    @Test
    public void KruskalTest(){
        graph1.addEdge(edge1);
        graph1.addEdge(edge2);
        graph1.addEdge(edge3);
        Kruskal kruskal = new Kruskal();
        System.out.println(kruskal.treeGraph(graph1));
    }

    @Test
    public void MstTest(){
        graph1.addEdge(edge1);
        graph1.addEdge(edge2);
        graph1.addEdge(edge3);
        Mst mstTest = new Mst();
        System.out.println(mstTest.mst(graph1));
    }

    @Test
    public void AldousBroder(){
        graph1.addEdge(edge1);
        graph1.addEdge(edge2);
        graph1.addEdge(edge3);
        graph1.addEdge(edge4);
        AldousBroder aldousBroder = new AldousBroder();
        aldousBroder.aldousBroder(graph1);


    }


}
