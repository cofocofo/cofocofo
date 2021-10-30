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
        int xa, ya;
        cin >> xa >> ya;
        int xb, yb;
        cin >> xb >> yb;
        int xf, yf;
        cin >> xf >> yf;

        // Process
        int ans = abs(xa-xb) + abs(ya-yb); /* Manhattan Distance */
        if (xa == xb && xb == xf) {
            if (min(ya, yb) < yf && yf < max(ya, yb)) {
                /* F is between A and B (same x coordinate)
                 * A
                 * |
                 * F
                 * |
                 * B */
                ans += 2; /* Detour F (-> <-) */
            }
        }
        if (ya == yb && yb == yf) {
            if (min(xa, xb) < xf && xf < max(xa, xb)) {
                /* F is between A and B (same y coordinate)
                 * A --- F --- B */
                ans += 2; /* Detour F (↑ ↓) */
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */