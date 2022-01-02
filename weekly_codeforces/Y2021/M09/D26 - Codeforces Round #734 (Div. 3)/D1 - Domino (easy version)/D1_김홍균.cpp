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
        int N, M, K;
        cin >> N >> M >> K;

        // Process
        int H = K; /* n(Horizontal Domino) */
        int V = (N*M)/2 - H; /* n(Vertical Domino) */

        int o, x;
        bool isPossible = true;
        if (N%2 == 1 && M%2 == 0) {
            /* o x o x
             * o x o x
             * o x o x */
            o = (N*M) / 2;
            x = (N*M) / 2;
            o -= K;
            x -= K;
            if (o < 0 || x < 0 || o%2 == 1 || x%2 == 1) {
                isPossible = false;
            }

            /* o o o o
             * x x x x
             * o o o o */
            o = (N/2+1) * M;
            x = (N/2) * M;
            o -= V;
            x -= V;
            if (o < 0 || x < 0 || o%2 == 1 || x%2 == 1) {
                isPossible = false;
            }
        } else if (N%2 == 0 && M%2 == 1) {
            /* o x o x o
             * o x o x o
             * o x o x o
             * o x o x o */
            o = (M/2+1) * N;
            x = (M/2) * N;
            o -= K;
            x -= K;
            if (o < 0 || x < 0 || o%2 == 1 || x%2 == 1) {
                isPossible = false;
            }

            /* o o o o o
             * x x x x x
             * o o o o o
             * x x x x x */
            o = (N*M) / 2;
            x = (N*M) / 2;
            o -= V;
            x -= V;
            if (o < 0 || x < 0 || o%2 == 1 || x%2 == 1) {
                isPossible = false;
            }
        } else if (N%2 == 0 && M%2 == 0) {
            /* o x o x
             * o x o x
             * o x o x
             * o x o x */
            /* o o o o
             * x x x x
             * o o o o
             * x x x x */
            o = (N*M) / 2;
            x = (N*M) / 2;
            o -= K;
            x -= K;
            if (o < 0 || x < 0 || o%2 == 1 || x%2 == 1) {
                isPossible = false;
            }
        }

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */
