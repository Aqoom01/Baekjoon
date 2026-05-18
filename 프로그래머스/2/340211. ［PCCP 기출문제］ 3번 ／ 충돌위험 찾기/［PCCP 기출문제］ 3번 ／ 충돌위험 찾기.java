import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] points, int[][] routes) {
        Robot[] robots = new Robot[routes.length];
        int pointLength = routes[0].length;
        
        for(int i = 0; i < routes.length; i++) robots[i] = new Robot(i, points[routes[i][0] - 1][0], points[routes[i][0] - 1][1], 0);
        
        int answer = 0;
        Map<Pos, Integer> positions = new HashMap<>();
        for (Robot robot : robots) {
            Pos pos = new Pos(robot.x, robot.y);
            positions.put(pos, positions.getOrDefault(pos, 0) + 1);
        }
        for (int count : positions.values()) if (count > 1) answer++;
        
        while(!isFinish(robots)) {
            positions = new HashMap<>();
            for(Robot robot : robots) {
                if(robot.isOut) continue;
                
                int next = routes[robot.index][robot.curIdx + 1];
                int[] nextPos = points[next - 1];
                
                int dist = Integer.MAX_VALUE;
                int moveDir = -1;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = robot.x + dx[dir];
                    int ny = robot.y + dy[dir];
                    
                    int tempDist = Math.abs(nextPos[0] - nx) + Math.abs(nextPos[1] - ny);
                    if(dist > tempDist) {
                        dist = tempDist;
                        moveDir = dir;
                    }
                }
                
                robot.x += dx[moveDir];
                robot.y += dy[moveDir];
                positions.put(new Pos(robot.x, robot.y), positions.getOrDefault(new Pos(robot.x, robot.y), 0) + 1);
                
                if(dist == 0) {
                    robot.curIdx++;
                    if(robot.curIdx + 1 == pointLength) robot.isOut = true;
                }
            }
            
            for (int count : positions.values()) if (count > 1) answer++;
        }
        
        return answer;
    }
    
    private boolean isFinish(Robot[] robots) {
        for(Robot robot : robots) if(!robot.isOut) return false;
        return true;
    }
}

class Robot {
    int index, x, y, curIdx;
    boolean isOut;
    
    Robot(int index, int x, int y, int curIdx) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.curIdx = curIdx;
        this.isOut = false;
    }
}

class Pos {
    int x, y;
    
    Pos(int x, int y) { this.x = x; this.y = y; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}