#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {  
    vector<string> answer;
    map<string, int> rankingByName;
    map<int, string> rankingByRank;
    for(int i = 0; i < players.size(); i++) {
        rankingByName.insert({players[i], i+1});
        rankingByRank.insert({i+1, players[i]});
    }
    
    for(int i = 0; i < callings.size(); i++) {
        int cur = rankingByName[callings[i]];
        string victim = rankingByRank[cur - 1];
        
        rankingByName[callings[i]] -= 1;
        rankingByName[victim] += 1;
        
        rankingByRank[cur] = victim;
        rankingByRank[cur - 1] = callings[i];
    }
    
    for(auto x : rankingByRank) {
        answer.push_back(x.second);
    }
    
    return answer;
}