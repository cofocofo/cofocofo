#include <iostream>
#define endl "\n"
using namespace std;

int a[101];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        cout << n << " ";
        for (int i = 1; i < n; i++) {
            cout << i << " ";
        }
        cout << endl;
    }
    return 0;
}
