#include <iostream>
#include <vector>
#include <algorithm>
#define endl "\n"
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        vector<int> a(n);
        for (int i = 0; i < n; i++)
            cin >> a[i];

        sort(a.begin(), a.end());

        int answer = a[0];
        if (a.size() > 1) {
            for (int i = 1; i < n; i++) {
                answer = max(answer, abs(a[i] - a[i - 1]));
            }
        }
        cout << answer << endl;
    }
    return 0;
}
