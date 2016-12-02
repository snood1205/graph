public class Edge {
    private int directionality;
    private Vertex left;
    private Vertex right;

    /**
     * This is the default constructor for Edge.
     * @param directionality if this parameter is -1 it is Right-to-Left,
     * if this parameter is 0 it is bidirectional and if it is 1, it is 
     * Left-to-Right.
     * @param left the left-hand vertex
     * @param right the right-hand vertex
     */
    public Edge(int directionality, Vertex left, Vertex right) {
        this.directionality = directionality;
        this.left = left;
        this.right = right;
    }

    /**
     * This is the convenience constructor for Edge.
     * It is bidirectional by default.
     * @param left the left-hand vertex
     * @param right the right-hand vertex
     */
    public Edge(Vertex left, Vertex right) {
        this.directionality = 0;
        this.left = left;
        this.right = right;
    }

    /**
     * Get directionality.
     *
     * @return directionality as int.
     */
    public int getDirectionality() {
        return directionality;
    }

    /**
     * Set directionality.
     *
     * @param directionality the value to set.
     */
    public void setDirectionality(int directionality) {
        this.directionality = directionality;
    }

    /**
     * Get left.
     *
     * @return left as Vertex.
     */
    public Vertex getLeft() {
        return left;
    }

    /**
     * Set left.
     *
     * @param left the value to set.
     */
    public void setLeft(Vertex left) {
        this.left = left;
    }

    /**
     * Get right.
     *
     * @return right as Vertex.
     */
    public Vertex getRight() {
        return right;
    }

    /**
     * Set right.
     *
     * @param right the value to set.
     */
    public void setRight(Vertex right) {
        this.right = right;
    }

    public boolean isUnidirectional() {
        return getDirectionality() != 0;
    }

    public Edge toUnidirectional(int directionality) 
                throws IllegalArgumentException, UnsupportedOperationException {
        if (directionality != -1 && directionality != 1)
            throw new IllegalArgumentException("Directionality must be -1 or 1");
        if (isUnidirectional())
            throw new UnsupportedOperationException(
                    "Cannot convert unidirectional edge to unidirectional edge");
        return new Edge(directionality, getLeft(), getRight());
    }

    public Edge toBidirectional() throws UnsupportedOperationException {
        if (!isUnidirectional())
            throw new UnsupportedOperationException(
                    "Cannot convert bidirectional edge to bidirectional edge");
        return new Edge(getLeft(), getRight());
    }

    public Edge toSwappedEdge() throws UnsupportedOperationException {
        if (!isUnidirectional())
            throw new UnsupportedOperationException(
                    "Cannot product swapped bidirectional edge");
        return new Edge(-getDirectionality(), getLeft(), getRight());
    }

    public boolean equivalent(Edge e) {
        if (equals(e))
            return true;
        if (e.getDirectionality() == -getDirectionality() &&
            e.getRight().equals(getLeft()) &&
            e.getLeft().equals(getRight()))
            return true;
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Edge))
            return false;
        Edge e = ((Edge) o);
        if (e.getDirectionality() == getDirectionality() &&
            e.getRight().equals(getRight()) &&
            e.getLeft().equals(getLeft()))
            return true;
        else
            return false;
    }


    @Override
    public int hashCode() {
        int result = getLeft().hashCode();
        result += getRight().hashCode();
        result += getDirectionality();
        return result;
    }
}

