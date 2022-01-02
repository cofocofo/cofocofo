#include <iostream>
#include <algorithm>
#include <map>
#define MAX 200001
#define endl "\n"
using namespace std;

int a[MAX];

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
        for (int i = 1; i <= n; i++) {
            cin >> a[i];
            mp[a[i]]++; // 개수
        }

        int answer = -1;
        for (auto [num, cnt] : mp) {
            if (cnt == 1) { // 개수가 1개인 경우
                answer = find(a + 1, a + n + 1, num) - a; // 인덱스 찾기
                break; // 정렬이 되어있으므로 이미 최소를 구한 것
            }
        }
        cout << answer << endl;
    }
    return 0;
}