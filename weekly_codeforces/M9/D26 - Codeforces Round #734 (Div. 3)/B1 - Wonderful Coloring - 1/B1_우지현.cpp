#include <iostream>
#include <algorithm>
using namespace std;

string s;
int alpha[26];

int coloring() 
{
	for (char ch : s) {
		alpha[ch - 'a']++;
	}

	int answer = 0;
	int cnt = 0;
	for (int i = 0; i < 26; i++) {
		if (alpha[i] > 1) answer++;
		else if (alpha[i] == 1) cnt++;
	}
	answer += cnt / 2;
	return answer;
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
		fill_n(alpha, 26, 0);
		cout << coloring() << "\n";
	}

	return 0;
}