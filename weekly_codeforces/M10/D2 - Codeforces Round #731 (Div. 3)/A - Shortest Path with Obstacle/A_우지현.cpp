#include <iostream>
using namespace std;

pair<int, int> A, B, F;

int shortestPath()
{
	int moves = abs(A.first - B.first) + abs(A.second - B.second); // A와 B 사이의 거리
	if (A.first == B.first && B.first == F.first) { // A, B, F가 세로로 일직선상에 있을 때
		if (F.second > min(A.second, B.second) && F.second < max(A.second, B.second)) // F가 A와 B 사이에 있으면
			moves += 2; // 돌아가야함
	}
	else if (A.second == B.second && B.second == F.second) { // A, B, F가 가로로 일직선상에 있을 때
		if (F.first > min(A.first, B.first) && F.first < max(A.first, B.first)) // F가 A와 B 사이에 있을 때
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
		cin >> A.first >> A.second;
		cin >> B.first >> B.second;
		cin >> F.first >> F.second;
		cout << shortestPath() << "\n";
	}
	return 0;
}