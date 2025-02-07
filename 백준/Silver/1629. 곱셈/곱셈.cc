#include <iostream>
using namespace std;

int power(long long a, long long b, long long c);

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	long long A, B, C;
	cin >> A >> B >> C;

	cout << power(A, B, C) << endl;
}

int power(long long A, long long B, long long C) {
	if (B == 1) return A % C;
	long long val = power(A, B / 2, C);
	val = val * val % C;
	
	if (B % 2 == 0) return val;
	return val * A % C;
}