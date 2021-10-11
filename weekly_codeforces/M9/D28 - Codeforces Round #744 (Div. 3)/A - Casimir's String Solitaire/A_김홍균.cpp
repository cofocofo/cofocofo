//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>

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
        map<char,int> M;
        for (char c : S) { /* Count 'A', 'B', 'C' */
            M[c]++;
        }

        bool isPossible = (M['B'] == M['A'] + M['C']);

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */