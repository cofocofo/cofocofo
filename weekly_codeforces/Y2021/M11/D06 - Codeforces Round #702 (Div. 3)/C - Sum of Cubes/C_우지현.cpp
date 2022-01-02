#include <iostream>
#include <set>
#include <algorithm>
#define endl "\n"
using namespace std;
typedef long long ll;

set<ll> cube;

void findCube()
{
    // 세제곱수를 미리 구해둔다
    for (ll i = 1; i <= 10000; i++) {
        cube.insert(i * i * i);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    findCube();

    while (T--) {
        ll x;
        cin >> x;

        bool possible = false;

        if (x > 1) {
            for (auto c : cube) {
                if (c > x)
                    break;

                // c가 세제곱수일 때, x - c도 세제곱수라면 종료
                if (cube.find(x - c) != cube.end()) {
                    possible = true;
                    break;
                }
            }
        }
        cout << (possible ? "YES" : "NO") << endl;
    }
    return 0;
}
