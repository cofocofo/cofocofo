#include <iostream>
#include <algorithm>
#define endl "\n"
#define MAX 200000
using namespace std;

int a[MAX];
int dp[MAX];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) {
            cin >> a[i];
            dp[i] = a[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            int idx = i + a[i]; // 다음 인덱스
            if (idx < n) { // 다음 인덱스로 이동할 수 있다면
                dp[i] += dp[idx]; // 현재 인덱스에 다음 인덱스의 값을 추가해준다
            }
        }
        cout << *max_element(dp, dp + n) << endl;
    }
    return 0;
}