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
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        int answer = -1;
        int maxi = *max_element(a.begin(), a.end());

        for (int i = 0; i < a.size(); i++) {
            if (a[i] != maxi) continue;
            // 최댓값이면서 왼쪽이나 오른쪽에 작은 값이 있으면 dominant
            if ((i - 1 >= 0 && a[i - 1] < a[i]) || (i + 1 < a.size() && a[i + 1] < a[i])) {
                answer = i + 1;
                break;
            }
        }
        cout << answer << endl;
    }
    return 0;
}