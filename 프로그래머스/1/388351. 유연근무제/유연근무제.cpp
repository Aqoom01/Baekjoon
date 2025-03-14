#include <string>
#include <vector>

using namespace std;

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int answer = schedules.size();
    int except1, except2;
    if(startday == 7) {
        except1 = 6;
        except2 = 0;
    }
    else {
        except1 = 6 - startday;
    except2 = 7 - startday;    
    }
    
    for(int i = 0; i < schedules.size(); i++) {
        int setting = schedules[i];
        int most;
        if(setting % 100 >= 50) {
            most = setting + 50;
        }
        else {
            most = setting + 10;
        }
        
        for(int j = 0; j < timelogs[i].size(); j++) {
            if(j == except1 || j == except2) continue;
            else if(timelogs[i][j] > most) {
                answer--;
                break;
            }
        }
    }
    
    return answer;
}