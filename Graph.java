import java.util.stream.*;
import java.util.Arrays;

public class Graph {
    public Edge[] edges;
    public Vertex[] vertices;

    public Graph(Vertex... vertices) {
        this.vertices = vertices;
        int size = Arrays.asList(vertices)
                         .stream()
                         .mapToInt(i -> i.getDegree())
                         .sum();
        this.edges = new Edge[size];
        int i = 0;
        for (Vertex v : vertices) 
            for (Edge e : v.getEdges())
                this.edges[i++] = e;
    }
}


