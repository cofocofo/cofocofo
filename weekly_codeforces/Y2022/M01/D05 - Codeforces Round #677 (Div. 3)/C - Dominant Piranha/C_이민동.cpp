#include <bits/stdc++.h>

#define lint long long
#define endl '\n'

using namespace std;

int arr[300000];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) cin >> arr[i];

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = max(arr[i], mx);
        }

        int ret = 0;
        bool flag = false;

        if (arr[0] > arr[1] && arr[0] + 1 > mx) {
            flag = true;
            ret = 1;
        } else if (arr[n - 1] > arr[n - 2] && arr[n - 1] + 1 > mx) {
            flag = true;
            ret = n;
        } else {
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] + 1 > mx) {
                    flag = true;
                    ret = i + 1;
                    break;
                } else if (arr[i] > arr[i + 1] && arr[i] + 1 > mx) {
                    flag = true;
                    ret = i + 1;
                    break;
                }
            }
        }
        if (flag) cout << ret << endl;
        else cout << -1 << endl;
    }
}