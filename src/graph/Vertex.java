
package graph;

/**
 * Vertex
 * 
 * @author Eli Sadoff
 *
 */
public class Vertex {

    private int    degree;
    private Edge[] edges;
    private String name;

    /**
     * @param name
     * @param edges
     */
    public Vertex (String name, Edge... edges) {
        this.name = name;
        this.edges = edges;
        this.degree = edges.length;
    }

    /**
     * @param name
     */
    public Vertex (String name) {
        this.name = name;
        this.edges = new Edge[0];
        this.degree = 0;
    }

    /**
     * Get degree.
     *
     * @return degree as int.
     */
    public int getDegree () {
        return this.degree;
    }

    /**
     * Set degree.
     *
     * @param degree
     *            the value to set.
     */
    public void setDegree (int degree) {
        this.degree = degree;
    }

    /**
     * Get edges.
     *
     * @return edges as Edge[].
     */
    public Edge[] getEdges () {
        return this.edges;
    }

    /**
     * Get edges element at specified index.
     *
     * @param index
     *            the index.
     * @return edges at index as Edge.
     */
    public Edge getEdges (int index) {
        return this.edges[index];
    }

    /**
     * Set edges.
     *
     * @param edges
     *            the value to set.
     */
    public void setEdges (Edge[] edges) {
        this.edges = edges;
    }

    /**
     * Set edges at the specified index.
     *
     * @param edges
     *            the value to set.
     * @param index
     *            the index.
     */
    public void setEdges (Edge edges, int index) {
        this.edges[index] = edges;
    }

    /**
     * Get name.
     *
     * @return name as String.
     */
    public String getName () {
        return this.name;
    }

    /**
     * Set name.
     *
     * @param name
     *            the value to set.
     */
    public void setName (String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vertex))
            return false;
        Vertex v = ((Vertex) o);
        return v.getDegree() == getDegree() && v.getName().equals(getName());
    }

    @Override
    public int hashCode () {
        int result = getName().hashCode();
        result += getDegree();
        return result;
    }
}
