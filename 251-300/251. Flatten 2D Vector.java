public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> result = new ArrayList();
    int row;
    int column;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        result = vec2d;
        row = 0;
        column = 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;

        return result.get(row).get(column++);
        
    }

    @Override
    public boolean hasNext() {
        // Write your code here

        if (row < result.size() && column == result.get(row).size()){
            row++;
            column=0;
        }

        return row< result.size();

    }

    @Override
    public void remove() {

    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
