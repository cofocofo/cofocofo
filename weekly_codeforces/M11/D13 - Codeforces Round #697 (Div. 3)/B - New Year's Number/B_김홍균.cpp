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
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()

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
    int t; cin >> t;

    while (t--) {
        int n; cin >> n;

        // Process
        int q = n / 2020;  /* a + b */
        int r = n % 2020;  /* b */

        bool isPossible = false;
        if (q >= r) {
            isPossible = true;
        } else if (q-1 >= r+2020) {
            isPossible = true;
        }

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */
