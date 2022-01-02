#include <bits/stdc++.h>

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

        // n = 2020*i + 2021*j
        // n = 2020*(i+j) + j
        // (n-j)/2020 = i+j
        // i = (n-j)/2020 - j
        int j = n % 2020;
        int i = (n - j) / 2020 - j;

        cout << ((i >= 0 && 2020 * i + 2021 * j == n) ? "YES" : "NO") << endl;
    }
}