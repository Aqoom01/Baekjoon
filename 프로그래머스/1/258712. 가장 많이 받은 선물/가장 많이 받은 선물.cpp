#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    map<string, int> answer_map;
    for(int i = 0; i < friends.size(); i++) {
        answer_map.insert({friends[i], 0});
    }
    
    vector<pair<string, string>> gifted;
    for(int i = 0; i < gifts.size(); i++) {
        int position = gifts[i].find(' ');
        string sender, receiver;
        sender = gifts[i].substr(0, position);
        receiver = gifts[i].substr(position+1, gifts[i].size());
        gifted.push_back({sender, receiver});
    }
    
    vector<pair<string, string>> same;
    for(int i = 0; i < friends.size() - 1; i++) {
        for(int j = i + 1; j < friends.size(); j++) {
            int a = 0;
            int b = 0;
            for(int k = 0; k < gifted.size(); k++) {
                if(gifted[k] == make_pair(friends[i], friends[j])) {
                    a++;
                }
                else if(gifted[k] == make_pair(friends[j], friends[i])) {
                    b++;
                }
                else continue;
            }
            
            if(a > b) answer_map[friends[i]]++;
            else if (a < b) answer_map[friends[j]]++;
            else same.push_back({friends[i], friends[j]});
        }
    }
    
    for(int i = 0; i < same.size(); i++) {
        string a = same[i].first;
        int a_count = 0;
        string b = same[i].second;
        int b_count = 0;
        
        for(int j = 0; j < gifted.size(); j++) {
            if(gifted[j].first == a) a_count++;
            if(gifted[j].first == b) b_count++;
            if(gifted[j].second == a) a_count--;
            if(gifted[j].second == b) b_count--;
        }
        if(a_count > b_count) answer_map[a]++;
        else if(a_count < b_count) answer_map[b]++;
    }
    
    int max = -1;
    for(auto iter: answer_map) {
        if(iter.second > max) {
            max = iter.second;
        }
    }
    
    return max;
}