#include <iostream>
#define fi first
#define se second
using namespace std;
typedef pair<int, int> pii;

pii A, B, F;


int shortestPath()
{
	int moves = abs(A.fi - B.fi) + abs(A.se - B.se); // A와 B 사이의 거리
	if (A.fi == B.fi && B.fi == F.fi) { // A, B, F가 세로로 일직선상에 있을 때
		if (F.se > min(A.se, B.se) && F.se < max(A.se, B.se)) // F가 A와 B 사이에 있으면
			moves += 2; // 돌아가야함
	}
	else if (A.se == B.se && B.se == F.se) { // A, B, F가 가로로 일직선상에 있을 때
		if (F.fi > min(A.fi, B.fi) && F.fi < max(A.fi, B.fi)) // F가 A와 B 사이에 있을 때
			moves += 2; // 돌아가야함
	}
	return moves;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		cin >> A.fi >> A.se;
		cin >> B.fi >> B.se;
		cin >> F.fi >> F.se;
		cout << shortestPath() << "\n";
	}
	return 0;
}