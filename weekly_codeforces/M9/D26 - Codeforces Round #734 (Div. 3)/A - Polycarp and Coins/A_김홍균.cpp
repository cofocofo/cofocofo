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
        int N; cin >> N;

        // Process
        int cnt_1 = N/3 + ((N%3 == 1) ? 1 : 0);
        int cnt_2 = N/3 + ((N%3 == 2) ? 1 : 0);

        // Control : Output
        cout << cnt_1 << ' ' << cnt_2 << endl;
    }
}

// Helper Functions
/* None */