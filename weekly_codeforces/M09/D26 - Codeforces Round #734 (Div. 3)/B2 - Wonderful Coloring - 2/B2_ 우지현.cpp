#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#define MAX 200000
using namespace std;

int n, k;
int arr[MAX];
int answer[MAX];

void coloring()
{
	map<int, vector<int>> idx;
	int cnt = 0;

	for (int i = 0; i < n; i++) {
		if (idx[arr[i]].size() < k) {
			idx[arr[i]].push_back(i);
			cnt++;
		}
	}

	cnt -= cnt % k;

	int color = 1;
	for (auto a : idx) {
		for (auto i : a.second) {
			answer[i] = color++;
			if (color > k) color = 1;
			if (--cnt == 0) return;
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		cin >> n >> k;
		
		int cnt = 0;
		for (int i = 0; i < n; i++) cin >> arr[i];
		
		fill_n(answer, MAX, 0);
		coloring();

		for (int i = 0; i < n; i++) {
			cout << answer[i] << " ";
		}
		cout << "\n";
	}

	return 0;
}