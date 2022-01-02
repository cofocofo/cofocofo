#include <iostream>
#include <map>
#define MAX 200000
#define endl "\n"
using namespace std;
typedef long long ll;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		int n;
		cin >> n;

		map<int, int> a;
		ll answer = 0;

		int k = 0;
		for (int i = 0; i < n; i++) {
			cin >> k;
			
			// aj - ai = j - i
			// aj - j = ai - i
			k -= i;

			// 가능한 쌍의 개수를 더한다
			answer += a[k];
			a[k]++;
		}

		cout << answer << endl;
	}
	return 0;
}