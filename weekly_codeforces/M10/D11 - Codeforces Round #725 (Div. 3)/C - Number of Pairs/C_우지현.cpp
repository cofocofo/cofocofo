#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, n, l, r;
	cin >> T;

	while (T--) {
		cin >> n >> l >> r;
		vector<int> a(n);
		for (int i = 0; i < n; i++)
			cin >> a[i];

		// 오름차순으로 정렬
		sort(a.begin(), a.end());

		long long answer = 0;
		for (int i = 0; i < n - 1; i++) {
			// a[i]와 더했을 때 l 이상이 될 수 있는 값의 위치
			auto start = lower_bound(a.begin() + i + 1, a.end(), l - a[i]);
			// a[i]와 더했을 때 r보다 커지는 값의 위치
			auto end = upper_bound(a.begin() + i + 1, a.end(), r - a[i]);
			
			// i와 쌍이 될 수 있는 값들의 수만큼 더해준다 
			answer += end - start;
		}
		cout << answer << "\n";
	}
	return 0;
}