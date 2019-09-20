public class BloodTypeMatch {

    public static void main(String[] args) {
        int n = 10;
        int[][] relations = {{1,2}, {4,2}, {6,9}, {6,10}, {8,10}};
        int m = 3;
        int[][] queries = {{1,4}, {6,8}, {3,7}};

        DisjointSetUnion dsu = new DisjointSetUnion(n);
        for (int i = 0; i < relations.length; i++) {
            dsu.union(relations[i][0], relations[i][1]);
        }
        for (int i = 0; i < m; i++) {
            boolean answer = dsu.find(queries[i][0]) == dsu.find(queries[i][1]);
            System.out.println(answer);
        }
    }
}
