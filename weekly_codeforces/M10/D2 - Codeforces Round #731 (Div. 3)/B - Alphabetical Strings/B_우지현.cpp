#include <iostream>
#include <string>
#include <map>
using namespace std;

string s;
map<char, int> idx;

bool alphabetical()
{
	char now = 'a';
	if (!idx.count(now)) return false; // a가 없는 경우 종료

	// 현재 문자열의 첫 인덱스와 마지막 인덱스
	int start = idx[now];
	int end = idx[now];

	for (int i = 0; i < s.size() - 1; i++) {
		char next = now + 1;

		// 다음 문자가 없거나 왼쪽, 오른쪽에 없으면 not alphabetical이므로 종료
		if (!idx.count(next) || (idx[next] != start - 1 && idx[next] != end + 1))
			return false;

		// 문자열의 시작과 끝 인덱스 갱신
		start = min(start, idx[next]);
		end = max(end, idx[next]);
		now = next;
	}
	return true;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		cin >> s;

		bool valid = true;

		// 중복 확인 및 위치 저장
		for (int i = 0; i < s.size(); i++) {
			if (idx.count(s[i])) { // 중복이 있는 경우 not alphabetical
				valid = false;
				break;
			}
			idx[s[i]] = i; // 각 문자에 대한 인덱스 저장
		}

		cout << ((valid && alphabetical()) ? "YES" : "NO") << "\n";
		idx.clear();
	}
	return 0;
}