package km;

import java.util.*;
import java.util.stream.Collectors;


class Solution2 {
    public int solution(int[] T, int[] A) {
        List<Integer> parents = Arrays.stream(T).boxed().collect(Collectors.toList());
        Integer n = parents.size();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int a : A) {
            dfs(parents, a, visited, 0);
        }

        int answer = 0;
        for (boolean b : visited) if (b) answer++;

        return answer + 1;
    }

    public void dfs(List<Integer> graph, int cur, boolean[] visited, int cnt) {
        if (cur == 0) {
            return;
        }
        visited[cur] = true;
        dfs(graph, graph.get(cur), visited, cnt + 1);
    }
}
