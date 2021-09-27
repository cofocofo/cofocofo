//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <vector>

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

    // Process
    vector<int> V;
    int n = 1;
    do {
        if (n%3 != 0 && n%10 != 3) {
            V.push_back(n);
        } n++;
    } while (V.size() < 1000);

    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        int K; cin >> K;

        // Control : Output
        cout << V[K-1] << endl;
    }
}

// Helper Functions
/* None */