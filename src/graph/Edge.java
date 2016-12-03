
package graph;

/**
 * 
 * Edge
 * 
 * @author Eli Sadoff
 *
 */
public class Edge {

    private int    directionality;
    private Vertex left;
    private Vertex right;

    /**
     * This is the default constructor for Edge.
     * 
     * @param directionality
     *            if this parameter is -1 it is Right-to-Left, if this parameter
     *            is 0 it is bidirectional and if it is 1, it is Left-to-Right.
     * @param left
     *            the left-hand vertex
     * @param right
     *            the right-hand vertex
     */
    public Edge (int directionality, Vertex left, Vertex right) {
        this.directionality = directionality;
        this.left = left;
        this.right = right;
    }

    /**
     * This is the convenience constructor for Edge. It is bidirectional by
     * default.
     * 
     * @param left
     *            the left-hand vertex
     * @param right
     *            the right-hand vertex
     */
    public Edge (Vertex left, Vertex right) {
        this.directionality = 0;
        this.left = left;
        this.right = right;
    }

    /**
     * Get directionality.
     *
     * @return directionality as int.
     */
    public int getDirectionality () {
        return this.directionality;
    }

    /**
     * Set directionality.
     *
     * @param directionality
     *            the value to set.
     */
    public void setDirectionality (int directionality) {
        this.directionality = directionality;
    }

    /**
     * Get left.
     *
     * @return left as Vertex.
     */
    public Vertex getLeft () {
        return this.left;
    }

    /**
     * Set left.
     *
     * @param left
     *            the value to set.
     */
    public void setLeft (Vertex left) {
        this.left = left;
    }

    /**
     * Get right.
     *
     * @return right as Vertex.
     */
    public Vertex getRight () {
        return this.right;
    }

    /**
     * Set right.
     *
     * @param right
     *            the value to set.
     */
    public void setRight (Vertex right) {
        this.right = right;
    }

    /**
     * @return if this Edge is unidirectional
     */
    public boolean isUnidirectional () {
        return getDirectionality() != 0;
    }

    /**
     * This method returns a unidirectional edge if the edge is bidirectional
     * 
     * @param directionality
     *            the directionality to set
     * @return a unidirectional edge with the directionality as specified
     * @throws IllegalArgumentException
     *             if the directionality is invalid
     * @throws UnsupportedOperationException
     *             if the current edge is unidirectional
     */
    public Edge toUnidirectional (int directionality)
            throws IllegalArgumentException, UnsupportedOperationException {
        if (directionality != -1 && directionality != 1)
            throw new IllegalArgumentException(
                    "Directionality must be -1 or 1");
        if (isUnidirectional())
            throw new UnsupportedOperationException(
                    "Cannot convert unidirectional edge to unidirectional edge");
        return new Edge(directionality, getLeft(), getRight());
    }

    /**
     * This method returns a bidirectional edge from a unidirectional edge.
     * 
     * @return a bidirectional edge
     * @throws UnsupportedOperationException
     *             if the current edge is bidirectional
     */
    public Edge toBidirectional () throws UnsupportedOperationException {
        if (!isUnidirectional())
            throw new UnsupportedOperationException(
                    "Cannot convert bidirectional edge to bidirectional edge");
        return new Edge(getLeft(), getRight());
    }

    /**
     * This method returns a unidirectional edge in the opposite direction of
     * the current unidirectional edge.
     * 
     * @return a swapped unidirectional edge.
     * @throws UnsupportedOperationException
     *             if the current edge is bidirectional it cannot be made
     *             unidirectional
     */
    public Edge toSwappedEdge () throws UnsupportedOperationException {
        if (!isUnidirectional())
            throw new UnsupportedOperationException(
                    "Cannot product swapped bidirectional edge");
        return new Edge(-getDirectionality(), getLeft(), getRight());
    }

    /**
     * This method is a weaker form of the equals method. While the equals
     * method checks for strict equality of directionality, left, and right
     * nodes, this method says that two edges are equivalent if they fulfill one
     * of two of the following parameters:
     * <ul>
     * <li>the two are considered strictly equal</li>
     * <li>the two are mirrors of each other</li>
     * </ul>
     * This second condition is saying that the edge A &larr; B is equivalent to
     * the edge B &rarr; A.
     * 
     * @param e
     *            the edge to check against for equivalence
     * @return if the edges are equivalent as described above
     */
    public boolean equivalent (Edge e) {
        if (equals(e))
            return true;
        return e.getDirectionality() == -getDirectionality()
                && e.getRight().equals(getLeft())
                && e.getLeft().equals(getRight());
    }

    /*
     * (non-Javadoc) This overrides the standard equals method.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Edge))
            return false;
        Edge e = ((Edge) o);
        return e.getDirectionality() == getDirectionality()
                && e.getRight().equals(getRight())
                && e.getLeft().equals(getLeft());
    }

    /*
     * (non-Javadoc) This overrides the standard hashCode method
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        int result = getLeft().hashCode();
        result += getRight().hashCode();
        result += getDirectionality();
        return result;
    }
}
