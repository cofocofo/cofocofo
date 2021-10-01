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
        string S; cin >> S;

        // Process
        int C[26] = {0, };
        for (char c : S) {
            C[c-'a']++;
        }

        int reds = 0, ones = 0;
        for (int i=0; i<26; i++) {
            if (C[i] >= 2) {
                reds++;
            } else if (C[i] == 1) {
                ones++;
            }
        }

        int ans = reds + ones/2;

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
