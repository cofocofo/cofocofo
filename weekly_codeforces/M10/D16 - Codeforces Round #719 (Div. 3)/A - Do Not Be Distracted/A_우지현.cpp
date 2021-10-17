#include <iostream>
#include <set>
#define endl "\n"
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		int n;
		string s;
		cin >> n >> s;

		bool suspicious = false;
		set<char> visited;

		for (int i = 0; i < s.size(); i++) {
			if (visited.count(s[i])) { // 이전에 했던 Task면 suspicious이므로 종료
				suspicious = true;
				break;
			}
			visited.insert(s[i]);
			
			// 새로운 Task가 나올 때까지 이동
			while (i + 1 < s.size() && s[i + 1] == s[i]) 
				i++;
		}
		cout << (suspicious ? "NO" : "YES") << endl;
	}
	return 0;
}