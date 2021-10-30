#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        if (arr[0] != arr[1] && arr[1] == arr[2])
            cout << 1 << endl;
        if (arr[n - 3] == arr[n - 2] && arr[n - 2] != arr[n - 1])
            cout << n << endl;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] != arr[i] && arr[i] != arr[i + 1])
                cout << i + 1 << endl;
        }
    }
}