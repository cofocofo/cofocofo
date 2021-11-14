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
        /* N = 3x   -> ones = x,   twos = x
         * N = 3x+1 -> ones = x+1, twos = x
         * N = 3x+2 -> ones = x,   twos = x+1
         */
        int ones = N/3 + ((N%3 == 1) ? 1 : 0);
        int twos = N/3 + ((N%3 == 2) ? 1 : 0);

        // Control : Output
        cout << ones << ' ' << twos << endl;
    }
}

// Helper Functions
/* None */
