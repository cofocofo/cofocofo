#include <bits/stdc++.h>

#define endl '\n'
#define lint long long

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;
    for (int t = 0; t < T; t++) {
        bool flag = false;
        lint n;
        cin >> n;
        if (n % 2) {
            flag = true;
        } else {
            while (n % 2 == 0) {
                n /= 2;
            }
            if (n > 1) {
                flag = true;
            }
        }

        cout << ((flag) ? "YES" : "NO") << endl;
    }
}