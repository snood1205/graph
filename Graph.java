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

    /**
     * Get edges.
     *
     * @return edges as Edge[].
     */
    public Edge[] getEdges() {
        return edges;
    }

    /**
     * Get edges element at specified index.
     *
     * @param index the index.
     * @return edges at index as Edge.
     */
    public Edge getEdges(int index) {
        return edges[index];
    }

    /**
     * Set edges.
     *
     * @param edges the value to set.
     */
    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    /**
     * Set edges at the specified index.
     *
     * @param edges the value to set.
     * @param index the index.
     */
    public void setEdges(Edge edges, int index) {
        this.edges[index] = edges;
    }

    /**
     * Get vertices.
     *
     * @return vertices as Vertex[].
     */
    public Vertex[] getVertices() {
        return vertices;
    }

    /**
     * Get vertices element at specified index.
     *
     * @param index the index.
     * @return vertices at index as Vertex.
     */
    public Vertex getVertices(int index) {
        return vertices[index];
    }

    /**
     * Set vertices.
     *
     * @param vertices the value to set.
     */
    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    /**
     * Set vertices at the specified index.
     *
     * @param vertices the value to set.
     * @param index the index.
     */
    public void setVertices(Vertex vertices, int index) {
        this.vertices[index] = vertices;
    }

    public int[] distance(Vertex source) {
        int[] distances = new int[getVertices().length];
        Vertex[] predecessor = new Vertex[distances.length];
        for (int i = 0; i < distances.length; i++) {
            if (getVertices(i).equals(source))
                distances[i] = 0;
            else
                distances[i] = -1;
            predecessor[i] = null;
        }
        for (int i = 0; i < distance.length - 1; i++) {
            for (Edge e : getEdges())
        return distances;
    }

}
