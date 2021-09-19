//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>

using namespace std;

#define endl '\n'

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

    while (TC--) {
        int a, b, c;
        cin >> a >> b >> c;

        // Process
        int mn = min(a, b);
        int mx = max(a, b);
        int n = (mx-mn)*2;

        bool isPossible = (mx <= n && c <= n);
        int ans;
        if (isPossible) {
            ans = (c <= n/2) ? c+n/2 : c-n/2;
        } else {
            ans = -1;
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */