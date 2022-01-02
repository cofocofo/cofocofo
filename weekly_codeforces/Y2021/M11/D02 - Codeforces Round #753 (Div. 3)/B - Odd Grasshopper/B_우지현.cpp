#include <iostream>
#define endl "\n"
using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        ll x, n;
        cin >> x >> n;

        int mod = n % 8;
        if (mod > 0) {
            ll start = n / 8 * 8 + 1;
            int move[] = {-1, 1, 1, -1};
            int d = x % 2 == 0 ? 0 : 2;
            for (int i = 0; i < mod; i++, start++) {
                x += move[d] * start;
                d = (d + 1) % 4;
            }
        }
        cout << x << endl;
    }
    return 0;
}
