#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <iostream>
using namespace std;

int map[100][100];
vector<pair<int, int>> traverse;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int solution(vector<string> maps) {
    int answer = 0;
    
    pair<int, int> start, lever, exit;
    fill(map[0], map[0] + 10000, -1);
    queue<pair<int, int>> q;
    for(int i = 0; i < maps.size(); i++) {
        for(int j = 0; j < maps[i].size(); j++) {
            if(maps[i][j] == 'S') {
                start = {i, j};
                q.push({i, j});
                traverse.push_back({i, j});
                map[i][j] = 0;
            }
            else if(maps[i][j] == 'O') map[i][j] = 100000;
            else if(maps[i][j] == 'L') {
                map[i][j] = 100000;
                lever = {i, j};
            }
            else if(maps[i][j] == 'E') {
                map[i][j] = 100000;
                exit = {i, j};
            } 
            else map[i][j] = -1;
        }
    }
    
    bool leverSuccess = false;
    int tempAns = 0;
    while(!q.empty()) {
        int X = q.front().first;
        int Y = q.front().second;
        int dist = map[X][Y];
        q.pop();
        
        if(X == lever.first && Y == lever.second) {
            leverSuccess = true;
            tempAns = dist;
            break;
        } 
        
        for(int i = 0; i < 4; i++) {
            int newX = X + dx[i];
            int newY = Y + dy[i];
            
            if(newX < 0 || newY < 0 || newX > 99 || newY > 99) continue;
            if(map[newX][newY] == -1 || map[newX][newY] < 100000) continue;
            
            map[newX][newY] = dist + 1;
            q.push({newX, newY});
            traverse.push_back({newX, newY});
        }
    }
    if(!leverSuccess) return -1;
    else answer += tempAns;
    
    q = queue<pair<int, int>>();
    q.push(lever);
    
    for(int i = 0; i < traverse.size(); i++) map[traverse[i].first][traverse[i].second] = 100000;
    map[start.first][start.second] = 100000;
    map[exit.first][exit.second] = 100000;
    map[lever.first][lever.second] = 0;
    
    bool exitSuccess = false;
    tempAns = 0;
    while(!q.empty()) {
        int X = q.front().first;
        int Y = q.front().second;
        int dist = map[X][Y];
        q.pop();
        
        if(X == exit.first && Y == exit.second) {
            exitSuccess = true;
            tempAns = dist;
            break;
        } 
        
        for(int i = 0; i < 4; i++) {
            int newX = X + dx[i];
            int newY = Y + dy[i];
            
            if(newX < 0 || newY < 0 || newX > 99 || newY > 99) continue;
            if(map[newX][newY] == -1 || map[newX][newY] < 100000) continue;
            
            map[newX][newY] = dist + 1;
            q.push({newX, newY});
        }
    }
    if(!exitSuccess) return -1;
    else answer += tempAns;
    
    return answer;
}