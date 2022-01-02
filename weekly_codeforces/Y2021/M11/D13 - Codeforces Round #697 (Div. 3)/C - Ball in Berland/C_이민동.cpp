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
        int a, b, k;
        cin >> a >> b >> k;
        vector<int> boyCount(a + 1);
        vector<int> girlCount(b + 1);

        vector<int> boys(k);
        for (int i = 0; i < k; i++) {
            cin >> boys[i];
            boyCount[boys[i]]++;
        }
        vector<int> girls(k);
        for (int i = 0; i < k; i++) {
            cin >> girls[i];
            girlCount[girls[i]]++;
        }

        lint ans = 0;
        for (int i = 0; i < k; i++) {
            ans += k - boyCount[boys[i]] - girlCount[girls[i]] + 1;
        }

        cout << ans / 2 << endl;
    }
}