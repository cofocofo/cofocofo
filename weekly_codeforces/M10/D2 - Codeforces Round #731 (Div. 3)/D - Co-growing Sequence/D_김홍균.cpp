//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>

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
        int X[N];
        for (int i=0; i<N; i++)
            cin >> X[i];

        // Process
        long long Y[N];
        memset(Y, 0, sizeof(Y));
        for (int i=1; i<N; i++) {
            /* If a_i & a_(i+1) != a_i */
            if ((X[i-1] & X[i]) != X[i-1]) {
                /* For a_i & a_(i+1) = a_i
                 * a_(i+1) should be (a_i | a_(i+1))
                 * thus, X[i] should be (X[i-1] | X[i])
                 * and, Y[i] = (X[i-1] | X[i]) - X[i]
                 * update, X[i] |= X[i-1] */
                Y[i] = (X[i-1] | X[i]) - X[i];
                X[i] |= X[i-1];
            }
        }

        // Control : Output
        for (int i=0; i<N; i++) {
            cout << Y[i] << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */