#include <bits/stdc++.h>

#define lint long long
#define endl '\n'

using namespace std;

void print(vector<int> &arr, int n) {
    sort(arr.begin(), arr.end() - 2);
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n;
        cin >> n;
        vector<int> arr(n + 2);
        for (int i = 0; i < n + 2; i++) {
            cin >> arr[i];
        }
        sort(arr.begin(), arr.end());

        lint sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        bool flag = false;

        if (sum == arr[n] || sum == arr[n + 1]) {
            print(arr, n);
            flag = true;
        } else {
            sum += arr[n];
            for (int i = 0; i < n; i++) {
                if (sum - arr[i] == arr[n + 1]) {
                    swap(arr[i], arr[n]);
                    print(arr, n);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) cout << -1 << endl;
    }
}