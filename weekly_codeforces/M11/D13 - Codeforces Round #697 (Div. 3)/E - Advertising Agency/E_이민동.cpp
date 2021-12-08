#include <bits/stdc++.h>

#define endl '\n'
#define lint long long

using namespace std;

int nCr[1001][1001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int MOD = 1e9+7;
    for (int i = 1; i < 1001; i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0 || i == j) nCr[i][j] = 1;
            else nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j])%MOD;
        }
    }

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n, k;
        cin >> n >> k;
        vector<int> arr(n + 1);
        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;
            arr[a]++;
        }
        int ans = 1;
        for (int i = n; i > 0; i--) {
            if(arr[i]==0) continue;

            if(arr[i]>=k) {
                ans *= nCr[arr[i]][k];
                ans%=MOD;
            }
            k-=arr[i];
            if (k <= 0) break;
        }
        cout << ans << endl;
    }
}