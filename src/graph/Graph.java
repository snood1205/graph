
package graph;

import java.util.Arrays;


/**
 * Graph
 * 
 * @author Eli Sadoff
 *
 */
public class Graph {

    private Edge[]   edges;
    private Vertex[] vertices;

    /**
     * This is the constructor for the class Graph
     * 
     * @param vertices
     *            the vertices to set
     */
    public Graph (Vertex... vertices) {
        this.vertices = vertices;
        int size = Arrays.asList(vertices).stream().mapToInt(i -> i.getDegree())
                .sum();
        this.edges = new Edge[size];
        int i = 0;
        for (Vertex v : vertices)
            for (Edge e : v.getEdges())
                this.edges[i++] = e;
    }

    /**
     * Gets edges
     *
     * @return the edges as Edge[]
     */
    public Edge[] getEdges () {
        return this.edges;
    }

    /**
     * Sets edges.
     * 
     * @param edges
     *            the edges to set
     */
    public void setEdges (Edge[] edges) {
        this.edges = edges;
    }

    /**
     * Gets vertices
     *
     * @return the vertices as Vertex[]
     */
    public Vertex[] getVertices () {
        return this.vertices;
    }

    /**
     * Sets vertices.
     * 
     * @param vertices
     *            the vertices to set
     */
    public void setVertices (Vertex[] vertices) {
        this.vertices = vertices;
    }
}
