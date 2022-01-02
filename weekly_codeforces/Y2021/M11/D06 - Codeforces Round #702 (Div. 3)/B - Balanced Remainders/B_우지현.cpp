#include <iostream>
#include <algorithm>
#define endl "\n"
using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;

        cin >> n;

        int c[3] = { 0, };
        for (int i = 0, a; i < n; i++) {
            cin >> a;
            c[a % 3]++;
        }

        int avg = n / 3;
        int answer = 0;

        // 모두 같은 수가 될 때까지 반복
        while (*min_element(c, c + 3) != avg) {
            for (int i = 0; i < 3; i++) {
                if (c[i] > avg) { // 평균보다 클 경우 1 증가시킴
                    answer++;
                    c[i]--;
                    c[(i + 1) % 3]++;
                }
            }
        }

        cout << answer << endl;
    }
    return 0;
}
