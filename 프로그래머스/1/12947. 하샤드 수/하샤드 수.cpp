#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int dividend = x;
    int divisor = 0;
    
    while(dividend != 0) {
        divisor += dividend % 10;
        dividend /= 10;
    }
    
    if(x % divisor == 0) return true;
    else return false;
}