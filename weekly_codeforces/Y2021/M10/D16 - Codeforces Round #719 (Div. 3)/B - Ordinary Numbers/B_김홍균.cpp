//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <queue>

using namespace std;

#define endl '\n'
typedef long long ll;

// Set up : Global Variables
/* None */

// Set up : Functions Declaration
/* None */


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    for (int tc=1; tc<=TC; tc++) {
        int N; cin >> N;

        // Process
        queue<ll> que;
        for (int i=1; i<=9; i++) {
            if (i <= N) {
                que.push(i);
            }
        }

        int ans = 0;
        while (not(que.empty())) {
            ll c = que.front(); que.pop();  // ordinary number <- len x
            ans++;

            ll n = c*10 + c%10;  // ordinary number <- len (x+1)
            if (n <= N) {
                que.push(n);
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */