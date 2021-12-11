#include <iostream>
#include <vector>
#include <map>
#define endl "\n"
#define INF 987654321
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        map<int, vector<int>> pos;
        for (int i = 1; i <= n; i++) {
            int a;
            cin >> a;
            pos[a].push_back(i); // 위치 저장
        }

        int answer = INF;
        for (auto [num, p] : pos) {
            int cnt = 0;
            if (p.front() != 1) cnt++; // 처음 위치가 1이 아닌 경우 지울 구간 추가
            if (p.back() != n) cnt++; // 마지막 위치가 n이 아닌 경우 지울 구간 추가
            for (int i = 1; i < p.size(); i++) {
                if (p[i] - p[i - 1] > 1) { // 두 위치의 차가 1보다 큰 경우
                    cnt++;  // 지울 구간 추가
                }
            }
            answer = min(answer, cnt);
        }
        cout << answer << endl;
    }
    return 0;
}