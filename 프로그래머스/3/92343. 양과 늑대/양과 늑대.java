import java.util.*;

class Solution {
    int answer, info[], edges[][];
    int sheep, wolf;
    Deque<Integer> deque = new ArrayDeque<>();
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        this.info = info;
        this.edges = edges;
        
        sheep = 0;
        wolf = 0;
        
        dfs(0);
        
        return answer;
    }
    
    void dfs(int cursor) {
        
        // 방문
        int value = info[cursor];
        if(value == 0) {
            sheep++;
            answer = Math.max(answer, sheep);
        }
        else {
            wolf++;
        }

        // 종료 조건
        if(wolf >= sheep) return;
        
        // 다음 갈 후보지 추가
        for(int[] edge : edges) {
            if(edge[0] == cursor) {
                if(info[edge[1]] == 0) deque.addFirst(edge[1]);
                else deque.addLast(edge[1]);
            }
        }
        
        if(deque.isEmpty()) return;
        
        // 양이면 앞에 노드로 이동
        if(info[deque.peekFirst()] == 0) {
            int next = deque.pollFirst();
            dfs(next);
            return;
        }
        
        //양이 없다면 모든 늑대로 이동해보기
        Integer[] candidates = deque.toArray(new Integer[0]);
        for(int next : candidates) {
            int prevSheep = sheep;
            int prevWolf = wolf;
            Deque<Integer> prevDeque = new ArrayDeque<>(deque);

            deque.remove(next);

            dfs(next);

            sheep = prevSheep;
            wolf = prevWolf;
            deque = prevDeque;
        }
    }
}