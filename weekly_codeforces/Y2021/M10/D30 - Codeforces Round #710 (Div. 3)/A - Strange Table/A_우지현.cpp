#include <iostream>
#include <cmath>
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
        ll n, m, x;
        cin >> n >> m >> x;

        ll nx = x % n;
        if (nx == 0) nx = n;
        ll ny = ceil((double)x / n);
        cout << (nx - 1) * m + ny << endl;
    }
    return 0;
}
