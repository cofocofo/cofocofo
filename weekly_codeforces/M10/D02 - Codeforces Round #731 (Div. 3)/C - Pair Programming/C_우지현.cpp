#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		int k, n, m;
		cin >> k >> n >> m;

		vector<int> a(n);
		vector<int> b(m);
		for (int i = 0; i < n; i++) cin >> a[i];
		for (int i = 0; i < m; i++) cin >> b[i];

		vector<int> answer;
		bool possible = true;
		int aIdx = 0; 
		int bIdx = 0;

		for (int i = 0; i < n + m; i++) {
			// a배열에 남은 sequence가 없으면 b배열 확인
			// a배열에 남은 sequence가 있을 때 k보다 크면 answer에 추가할 수 없음
			// b배열에 남은 sequence가 없으면 그대로 종료
			// b배열에 남은 sequence가 있을 때 k보다 크면 answer에 더 이상 추가할 수 없으므로 종료

			if ((aIdx >= n || a[aIdx] > k) && (bIdx >= m || b[bIdx] > k)) {
				possible = false;
				break;
			}

			// a 배열에 남은 sequence가 k 이하라면 answer에 추가
			if (aIdx < n && a[aIdx] <= k) 
				answer.push_back(a[aIdx++]);
			// a에 없다면 b 배열에서 sequence 추가
			else 
				answer.push_back(b[bIdx++]); 

			// 새로운 줄을 추가한 경우 전체 라인 수 증가
			if (answer.back() == 0) k++;
		}

		if (!possible) cout << -1 << "\n";
		else {
			for (int num : answer) {
				cout << num << " ";
			}
			cout << "\n";
		}
	}
	return 0;
}