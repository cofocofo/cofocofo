#include <iostream>
#include <algorithm>
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
		int a, b;
		string s;
		cin >> a >> b >> s;

		int n = s.size();
		bool invalid = false;

		// 01?????0
		// 팰린드롬인지 검사를 하는 동시에 한쪽만 ?인 경우 같은 수로 채운다
		for (int i = 0; i < n; i++) {
			int k = n - i - 1;
			if (s[i] != '?') {
				if (s[k] == '?') // 한쪽만 ?인 경우 같은 수로 채워준다
					s[k] = s[i];
				else if (s[i] != s[k]) { // 팰린드롬인지 검사
					invalid = true;
					break;
				}
			}
		}

		if (invalid) { // 팰린드롬이 아닌 경우
			cout << -1 << endl;
			continue;
		}

		// 남은 0, 1 개수 갱신
		a -= count(s.begin(), s.end(), '0');
		b -= count(s.begin(), s.end(), '1');

		// 남은 ? 개수
		int qs = count(s.begin(), s.end(), '?');

		// 문자열이 홀수인 경우 정가운데가 ?인지 확인
		bool emptyMid = n % 2 == 1 && s[n / 2] == '?';

		// a, b 개수가 맞지 않거나 정가운데를 채우지 못하는 경우
		if (a < 0 || b < 0 || a + b != qs || (emptyMid && a % 2 == 0 && b % 2 == 0)) {
			cout << -1 << endl;
			continue;
		}

		// 정가운데를 홀수개 남은 수로 채워준다
		if (emptyMid) {
			if (a % 2 == 1) {
				s[n / 2] = '0';
				a--;
			}
			else if (b % 2 == 1) {
				s[n / 2] = '1';
				b--;
			}
			else { // 0, 1 남은 개수가 홀수가 아니라면 채우지 못하므로 -1
				cout << -1 << endl;
				continue;
			}
		}

		// ? 쌍들만 남았으므로 a, b가 짝수여야 함
		if (a % 2 == 1 || b % 2 == 1) {
			cout << -1 << endl;
			continue;
		}

		for (int i = 0; i < n / 2; i++) {
			if (s[i] == '?') {
				int k = n - i - 1;
				
				// 남은 0, 1로 팰린드롬을 만든다
				if (a > 0) {
					s[i] = s[k] = '0';
					a -= 2;
				}
				else {
					s[i] = s[k] = '1';
					b -= 2;
				}
			}
		}
		cout << s << endl;
	}
	return 0;
}