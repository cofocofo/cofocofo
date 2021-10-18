#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
#define MAX 100001
using namespace std;

bool isPrime[MAX];
vector<int> primes;

void eratosthenes()
{
	fill_n(isPrime, MAX, true);
	isPrime[0] = isPrime[1] = false;
	for (int i = 2; i < MAX; i++) {
		if (isPrime[i]) {
			primes.push_back(i);
			for (int j = i * 2; j < MAX; j += i) {
				isPrime[i] = false;
			}
		}
	}
}

int primeFactor(int n)
{
	int cnt = 0;
	for (int i = 0; n > 1 && i < primes.size(); i++) {
		while (n % primes[i] == 0) {
			cnt++;
			n /= primes[i];
		}
	}
	return cnt;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, a, b, k;
	cin >> T;

	eratosthenes();

	while (T--) {
		cin >> a >> b >> k;

		int maxMoves = primeFactor(a) + primeFactor(b);

		int g = gcd(a, b);
		int minMoves;

		if (a == b) minMoves = 0;
		else if (g == a || g == b) minMoves = 1;
		else minMoves = 2;

		bool possible = false;
		if ((k == 1 && minMoves == 1 && minMoves <= k && k <= maxMoves)
			|| (k != 1 && minMoves <= k && k <= maxMoves))
			possible = true;

		cout << (possible ? "YES" : "NO") << "\n";
	}
	return 0;
}