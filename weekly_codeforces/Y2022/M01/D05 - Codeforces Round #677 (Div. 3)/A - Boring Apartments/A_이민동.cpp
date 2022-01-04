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
        int x;
        cin >> x;

        string ret = "";
        for (int i = 1; i <= 9; i++) {
            string s = "";
            for (int j = 0; j < 4; j++) {
                s += to_string(i);
                ret += s;

                if (stoi(s) == x) {
                    cout << ret.length() << endl;
                }
            }
        }
    }
}