#include <iostream>
using namespace std;
typedef long long ll;

// 1부터 n까지 더했을 때 바뀐 digit의 수
ll digitsChanged(int n)
{
	ll cnt = 0;
	while (n) {
		cnt += n;
		n /= 10;
	}
	return cnt;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		int l, r;
		cin >> l >> r;
		
		// (1 ~ r) - (1 ~ l) = (l ~ r)
		ll answer = digitsChanged(r) - digitsChanged(l);
		cout << answer << "\n";
	}
	return 0;
}