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
struct Point { int y, x; };

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
        int N; cin >> N;
        char G[N][N];
        Point P[2];
        int idx = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                cin >> G[i][j];
                if (G[i][j] == '*') {
                    P[idx++] = {i, j};
                }
            }
        }

        // Process
        auto [ay, ax] = P[0];
        auto [by, bx] = P[1];

        /* Use modular */
        if (ay == by) {
            int y = (ay + 1) % N;
            G[y][ax] = G[y][bx] = '*';
        } else if (ax == bx) {
            int x = (ax + 1) % N;
            G[ay][x] = G[by][x] = '*';
        } else {
            G[ay][bx] = G[by][ax] = '*';
        }

        // Control : Output
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                cout << G[i][j];
            } cout << endl;
        }
    }
}

// Helper Functions
/* None */
