#include <iostream>
#include <map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, n;
	cin >> T;

	string target = "haha";
	while (T--) {
		cin >> n;

		map<string, string> mp;
		for (int i = 0; i < n; i++) {
			string x, op, a, b;
			cin >> x >> op;

			if (op == ":=") {
				cin >> a;
				mp[x] = a;
			}
			else {
				cin >> a >> op >> b;
				mp[x] = mp[a] + mp[b];
			}

			if (i == n - 1) {
				long long answer = 0;

				string s = mp[x];
				int idx = s.find(target);
				while (idx != string::npos) {
					answer++;
					idx = s.find(target, idx + 2);
				}
				cout << answer << "\n";
			}
		}
	}
	return 0;
}