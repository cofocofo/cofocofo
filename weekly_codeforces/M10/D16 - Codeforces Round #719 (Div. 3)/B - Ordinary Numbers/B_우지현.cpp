#include <iostream>
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
		cin >> n;

		int answer = 0;
		int ordi = 1;
		int digit = 10;

		// 719
		// 1 ~ 9
		// 11 ~ 99
		// 111 ~ 666

		while (1) {
			if (n / digit == 0) {
				answer += n / ordi;
				break;
			}
			answer += 9;
			digit *= 10; // 10, 100, 1000, ...
			ordi = ordi * 10 + 1; // 1, 11, 111, ...
		}
		cout << answer << endl;
	}
	return 0;
}