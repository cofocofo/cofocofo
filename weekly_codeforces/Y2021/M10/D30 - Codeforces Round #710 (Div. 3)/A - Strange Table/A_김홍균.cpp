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
typedef unsigned long long ull;

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
        ull n, m, x;
        cin >> n >> m >> x;

        // Process
        ull i = (x-1) % n;
        ull j = (x-1) / n;

        ull a = (i * m + j) + 1;

        // Control : Output
        cout << a << endl;
    }
}

// Helper Functions
/* None */