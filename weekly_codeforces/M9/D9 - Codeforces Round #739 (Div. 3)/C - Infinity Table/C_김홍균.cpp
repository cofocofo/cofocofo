//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cmath>

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
        int k; cin >> k;

        // Process
        int sr = (int)sqrt(k);

        int r, c;
        if (sr*sr == k) {
            r = sr, c = 1;
        } else {
            sr++;
            int std = sr*sr - (sr-1);
            if (std >= k) {
                c = sr, r = sr-(std-k);
            } else {
                r = sr, c = sr-(k-std);
            }
        }

        // Control : Output
        cout << r << ' ' << c << endl;
    }
}

// Helper Functions
/* None */