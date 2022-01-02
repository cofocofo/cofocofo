#include <iostream>
#define endl "\n"
#define fi first
#define se second
using namespace std;
typedef pair<int, int> pii;

int n;
string map[400];
pii points[2];

void makeRectangle() 
{
	int x1 = points[0].fi;
	int y1 = points[0].se;
	int x2 = points[1].fi;
	int y2 = points[1].se;

	if (x1 == x2) { // x가 같은 경우
		map[(x1 + 1) % n][y1] = '*';
		map[(x2 + 1) % n][y2] = '*';
	}
	else if (y1 == y2) { // y가 같은 경우
		map[x1][(y1 + 1) % n] = '*';
		map[x2][(y2 + 1) % n] = '*';
	}
	else { // x, y가 모두 다른 경우
		map[x1][y2] = '*';
		map[x2][y1] = '*';
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

		int idx = 0;
		for (int i = 0; i < n; i++) {
			cin >> map[i];
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '*') {
					points[idx++] = { i, j };
				}
			}
		}

		makeRectangle();

		for (int i = 0; i < n; i++) {
			cout << map[i] << endl;
		}
	}
	return 0;
}