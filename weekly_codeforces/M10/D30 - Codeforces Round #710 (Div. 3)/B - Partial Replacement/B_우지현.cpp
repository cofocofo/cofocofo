#include <iostream>
#include <vector>
#include <algorithm>
#define endl "\n"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n, k;
        string s;
        cin >> n >> k >> s;

        vector<int> pos;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*') // * 위치 저장
                pos.push_back(i);
        }

        int answer = 0;
        if (pos.size() <= 2) // *이 2개 이하인 경우
            answer += pos.size();
        else { // *이 3개 이상인 경우
            answer += 2; // 처음, 마지막 X 개수

            int start = 0;
            int end = pos.size() - 1;

            // 현재 X과 마지막 X의 거리가 k보다 클 경우 새로운 X 추가
            while (pos[end] - pos[start] > k) {
                int now = start;

                // 새로 추가할 X의 위치를 찾는다
                while (now + 1 < end && pos[now + 1] - pos[start] <= k) now++;

                // X 추가
                answer++;

                // start를 추가한 X의 위치로 갱신
                start = now;
            }
        }
        cout << answer << endl;
    }
    return 0;
}
