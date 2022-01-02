#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
char arr[400][400];

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int n;
        cin >> n;
        int ar = 0, ac = 0, br = 0, bc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> arr[i][j];
                if (arr[i][j] == '*') {
                    br = ar;
                    bc = ac;
                    ar = i;
                    ac = j;
                }
            }
        }

        if (ar == br) {
            arr[(ar + 1) % n][ac] = '*';
            arr[(ar + 1) % n][bc] = '*';
        } else if (ac == bc) {
            arr[ar][(ac + 1) % n] = '*';
            arr[br][(ac + 1) % n] = '*';
        } else {
            arr[ar][bc] = '*';
            arr[br][ac] = '*';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cout << arr[i][j];
            }
            cout << endl;
        }
    }
}