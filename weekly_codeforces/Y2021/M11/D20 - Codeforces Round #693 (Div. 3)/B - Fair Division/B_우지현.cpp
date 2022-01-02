#include <iostream>
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

        int w[3] = { 0, };
        for (int i = 0, candy; i < n; i++) {
            cin >> candy;
            w[candy]++;
        }

        // 2가 짝수 개인 경우 1도 짝수 개여야 한다
        // 2가 홀수 개인 경우 1이 2개 이상 있어야 하고 1이 짝수 개여야 한다
        bool possible = (w[2] % 2 == 0 && w[1] % 2 == 0) || (w[2] % 2 == 1 && w[1] > 1 && w[1] % 2 == 0);
        cout << (possible ? "YES" : "NO") << endl;
    }
    return 0;
}