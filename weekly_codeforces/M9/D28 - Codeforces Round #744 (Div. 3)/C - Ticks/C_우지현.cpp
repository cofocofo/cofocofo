#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int n, m, k, d;
string paper[10];
vector<pair<int, int>> painted;
int maxd[10][19];

int dx[] = { -1, -1 };
int dy[] = { -1, 1 };


bool isWall(int x, int y)
{
	return x < 0 || x >= n || y < 0 || y >= m;
}

void go(int lx, int ly, int rx, int ry)
{
	// 범위를 벗어난 경우 tick의 크기가 더 이상 커질 수 없으므로 종료
	if (isWall(lx, ly) || isWall(rx, ry)) return;

	// 색칠되어 있지 않은 경우 종료
	if (paper[lx][ly] == '.' || paper[rx][ry] == '.') return;

	// 다음 왼쪽, 오른쪽 대각선 위치
	int lnx = lx + dx[0];
	int lny = ly + dy[0];
	int rnx = rx + dx[1];
	int rny = ry + dy[1];
	
	d++; // tick 크기 증가

	// 다음 대각선 위치에 색칠하기
	go(lnx, lny, rnx, rny);

	// 현재 위치에서의 tick의 최대 크기 갱신
	maxd[lx][ly] = max(maxd[lx][ly], d);
	maxd[rx][ry] = max(maxd[rx][ry], d);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		cin >> n >> m >> k;
		for (int i = 0; i < n; i++) {
			cin >> paper[i];
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == '*')
					painted.push_back({ i, j });
			}
		}

		memset(maxd, 0, sizeof(maxd));
		for (auto p : painted) {
			// 현재 위치
			int x = p.first;
			int y = p.second;

			// 왼쪽, 오른쪽 대각선 위치
			int lx = x + dx[0]; 
			int ly = y + dy[0];
			int rx = x + dx[1];
			int ry = y + dy[1];
			
			d = 0; // tick의 크기

			// 그릴 수 있는 tick의 최대 크기 찾기
			go(lx, ly, rx, ry); 

			// 현재 위치에서 그릴 수 있는 tick의 최대 크기 갱신
			maxd[p.first][p.second] = max(maxd[p.first][p.second], d);
		}


		bool possible = true;
		for (auto p : painted) {
			int x = p.first;
			int y = p.second;

			// tick의 크기가 k보다 작은 경우 k가 최소가 아니므로 종료
			if (maxd[x][y] < k) {
				possible = false;
				break;
			}
		}

		if (possible) cout << "YES\n";
		else cout << "NO\n";

		painted.clear();
	}
	return 0;
}