#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
#define INF 987654321
using namespace std;

struct Info {
	int l, r, d;
	Info(int l, int r, int d) : l(l), r(r), d(d) { }
};

vector<int> a;

void shiftingSort(int start, int end)
{
	deque<int> dq;
	for (int i = start; i <= end; i++) {
		dq.push_back(a[i]);
	}

	for (int i = 0; i < end - start; i++) {
		dq.push_back(dq.front());
		dq.pop_front();
	}

	for (int i = 0; i < dq.size(); i++) {
		a[start + i] = dq[i];
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
		int n;
		cin >> n;

		a.resize(n);
		for (int i = 0; i < n; i++) cin >> a[i];

		vector<int> b = a;
		sort(b.begin(), b.end());

		vector<Info> infos;
		for (int i = 0; i < n; i++) {
			int idx = find(a.begin() + i, a.end(), b[i]) - a.begin(); // i부터 n까지의 원소 중 최솟값 찾아서
			if (idx > i) { // 최솟값이 현재 위치(i)보다 뒤에 있다면 shirtingSort
				shiftingSort(i, idx);
				infos.push_back(Info(i + 1, idx + 1, idx - i));
			}
		}

		cout << infos.size() << "\n";
		for (auto& info : infos) {
			cout << info.l << " " << info.r << " " << info.d << "\n";
		}
	}
	return 0;
}