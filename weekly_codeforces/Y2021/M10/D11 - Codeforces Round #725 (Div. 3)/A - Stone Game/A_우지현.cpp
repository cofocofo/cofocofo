#include <iostream>
#define MAX 101
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

		int minIdx = 1;
		int maxIdx = 1;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			if (a[minIdx] > a[i])
				minIdx = i;
			if (a[maxIdx] < a[i])
				maxIdx = i;
		}

		int s = min(minIdx, maxIdx); // 왼쪽
		int e = max(minIdx, maxIdx); // 오른쪽

		// 1. 왼쪽 돌들만 부숴서 최소, 최대 파워 돌들을 부수는 경우
		// 2. 왼쪽과 오른쪽 양쪽 돌들을 부숴서 최소, 최대 파워 돌들을 부수는 경우
		// 3. 오른쪽 돌들만 부숴서 최소, 최대 파워 돌들을 부수는 경우
		cout << min(e, min(s + n - e + 1, n - s + 1)) << "\n";
	}
	return 0;
}