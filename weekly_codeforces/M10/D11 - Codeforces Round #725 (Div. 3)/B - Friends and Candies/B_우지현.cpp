#include <iostream>
#define MAX 200000
using namespace std;

int n;
int a[MAX];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		cin >> n;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			cin >> a[i];
			sum += a[i];
		}

		// sum이 n으로 나누어 떨어지지 않는 경우 똑같이 분배할 수 없음
		if (sum % n != 0) {
			cout << -1 << "\n";
			continue;
		}

		int avg = sum / n;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			// 평균보다 많은 캔디를 가지고 있으면 다른 사람에게 줘야한다
			if (a[i] > avg) { 
				answer++;
			}
		}
		cout << answer << "\n";
	}
	return 0;
}