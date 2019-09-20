import java.util.HashMap;
import java.util.Map;

public class DisjointSetUnion {
    Map<Integer, Integer> disjointSetsLeader;
    Map<Integer, Integer> disjointSetsRank;
    int totalSets;

    public DisjointSetUnion(int totalSets) {
        this.totalSets = totalSets;
        disjointSetsLeader = new HashMap<>();
        disjointSetsRank = new HashMap<>();
        createSets(totalSets);
    }

    private void createSets(int totalSets) {
        for (int i = 1; i <= totalSets; i++) {
            disjointSetsLeader.put(i, i);
            disjointSetsRank.put(i, 1);
        }
    }

    public boolean union(int x, int y) {
        int leaderOfX = find(x);
        int leaderOfY = find(y);

        if (leaderOfX == leaderOfY) {
            return true;
        }

        if (disjointSetsRank.get(leaderOfY) > disjointSetsRank.get(leaderOfX)) {
            int temp = leaderOfY;
            leaderOfY = leaderOfX;
            leaderOfX = temp;
        }
        disjointSetsLeader.put(leaderOfY, leaderOfX);
        int updatedRankOfX = disjointSetsRank.get(leaderOfX) + disjointSetsRank.get(leaderOfY);
        disjointSetsRank.put(leaderOfX, updatedRankOfX);
        totalSets--;

        return false;
    }

    public int find(int x) {
        if (disjointSetsLeader.get(x) != x) {
            int rootLeader = find(disjointSetsLeader.get(x));
            disjointSetsLeader.put(x, rootLeader);
            return rootLeader;
        }
        return x;
    }
}
