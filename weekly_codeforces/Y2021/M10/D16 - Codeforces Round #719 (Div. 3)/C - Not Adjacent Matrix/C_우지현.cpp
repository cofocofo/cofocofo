#include <iostream>
#include <algorithm>
#define endl "\n"
using namespace std;

int n, num;
int a[100][100];

int dx[] = { 1, 0 };
int dy[] = { 0, 1 };

bool isWall(int x, int y)
{
	return x < 0 || x >= n || y < 0 || y >= n; 
}

void fillDiag(int x, int y)
{
	// 시작 위치부터 범위가 벗어나지 않을 때까지 대각선으로 이동
	while (!isWall(x, y)) {
		a[x][y] = num++;
		x += 1;
		y += 1;
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
		cin >> n;

		if (n == 2) {
			cout << -1 << endl;
			continue;
		}

		// 1 4 8
		// 6 2 5
		// 9 7 3

		num = 1;

		// 중앙 대각선 먼저 채운다
		// 1 0 0
		// 0 2 0
		// 0 0 3
		fillDiag(0, 0);


		// (0, 1), (1, 0) -> (0, 2), (2, 0) -> ...
		// 1 4 0   1 4 0     1 4 8   1 4 8
		// 0 2 5   6 2 5     6 2 5   6 2 5 
		// 0 0 3   0 7 3     0 7 3   9 7 3

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				fillDiag(dx[j] * i, dy[j] * i);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cout << a[i][j] << " ";
			}
			cout << endl;
		}
	}
	return 0;
}