#include <iostream>
#define MAX 366
using namespace std;

int days[MAX]; // 일정

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, s, e;
	cin >> n;
	
	int start = MAX; // 전체 일정 시작일
	int end = 0; // 전체 일정 종료일
	for (int i = 0; i < n; i++) {
		cin >> s >> e;
		start = min(start, s);
		end = max(end, e);
		for (int j = s; j <= e; j++) {
			days[j]++;
		}
	}

	int answer = 0;
	for (int i = start; i <= end; i++) {
		if (days[i] > 0) { // 일정이 있을 경우 연속된 일정 확인
			int width = 1;
			int height = days[i];

			// 연속되는 기간 구하기
			while (i + 1 <= end && days[i + 1] > 0) {
				height = max(height, days[++i]); // 일정이 가장 많은 날
				width++;
			}
			// 직사각형의 면적을 더해준다
			answer += width * height;
		}
	}
	cout << answer;
	return 0;
}