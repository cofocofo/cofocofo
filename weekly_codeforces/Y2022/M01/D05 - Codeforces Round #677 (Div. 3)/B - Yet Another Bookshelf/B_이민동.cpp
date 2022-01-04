#include <bits/stdc++.h>

#define lint long long
#define endl '\n'

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n;
        cin >> n;
        bool flag = false;
        int ret = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;

            if (!flag && a == 1) {
                flag = true;
            } else if (flag && a == 0) {
                cnt++;
            } else if (a == 1) {
                ret += cnt;
                cnt = 0;
            }
        }

        cout << ret << endl;
    }
}