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
    while (T--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        lint ans = 0;
        for (int i = 0; i < n; i++) cin >> arr[i];
        sort(arr.begin(), arr.end());

        lint z = 0;
        for (int i = 0; i < n - 2; i++) {
            while (z < n && arr[z] - arr[i] <= 2) z++;
            ans += (z - i - 2) * (z - i - 1) / 2;
        }

        cout << ans << endl;
    }
}