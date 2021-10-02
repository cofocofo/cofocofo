#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		string s;
		cin >> s;

		int bCnt = 0; // B 개수
		int acCnt = 0; // A, C 개수

		for (char ch : s) {
			if (ch == 'B') bCnt++;
			else acCnt++;
		}

		// B의 개수가 A, C 개수의 합과 같으면 empty string을 만들 수 있다
		if (bCnt == acCnt) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}