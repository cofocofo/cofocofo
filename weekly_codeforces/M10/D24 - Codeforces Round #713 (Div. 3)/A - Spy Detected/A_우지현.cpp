#include <iostream>
#include <map>
#define endl "\n"
#define fi first
#define se second
using namespace std;
typedef pair<int, int> pii;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		int n, x;
		cin >> n;

		map<int, pii> mp; // first : 개수, second : 인덱스
		for (int i = 1; i <= n; i++) {
			cin >> x;
			mp[x] = { mp[x].se + 1, i };
		}

		for (const auto& [key, p] : mp) {
			if (p.fi == 1) {
				cout << p.se << endl;
				break;
			}
		}
	}
	return 0;
}