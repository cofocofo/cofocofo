#include <iostream>
#define endl "\n"
using namespace std;

int cut(int n) {
    int cnt = 1;
    while (n % 2 == 0) { // 종이를 모두 두 조각으로 자른다
        n /= 2;
        cnt *= 2;
    }
    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int w, h, n;
        cin >> w >> h >> n;
        int cnt = cut(w) * cut(h);
        cout << (cnt >= n ? "YES" : "NO") << endl;
    }
    return 0;
}
