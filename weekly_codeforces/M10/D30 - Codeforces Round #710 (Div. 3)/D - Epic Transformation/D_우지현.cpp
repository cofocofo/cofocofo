#include <iostream>
#include <queue>
#include <map>
#define endl "\n"
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

        map<int, int> mp;
        for (int i = 0, x; i < n; i++) {
            cin >> x;
            mp[x]++; // 숫자 개수
        }

        priority_queue<int> pq;
        for (auto [num, cnt] : mp) {
            pq.push(cnt);
        }

        int answer = n;

        // 쌍을 만들 수 있을 때까지 반복
        while (pq.size() > 1) {
            int now = pq.top(); pq.pop(); // a
            int next = pq.top(); pq.pop(); // b
            answer -= 2; // 하나씩 제거

            if (now - 1 > 0)
                pq.push(now - 1);
            if (next - 1 > 0)
                pq.push(next - 1);
        }
        cout << answer << endl;
    }
    return 0;
}
