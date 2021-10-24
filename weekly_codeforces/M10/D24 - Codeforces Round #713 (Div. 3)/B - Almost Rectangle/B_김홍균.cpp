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
        auto [p1y, p1x] = P[0];
        auto [p2y, p2x] = P[1];

        int p3y, p3x;
        int p4y, p4x;
        p3y = p3x = p4y = p4x = -1;

        if (p1y == p2y) {
            int y = (p1y == 0) ? 1 : p1y-1;
            for (int x : {p1x, p2x}) {
                G[y][x] = '*';
            }
        } else if (p1x == p2x) {
            int x = (p1x == 0) ? 1 : p1x-1;
            for (int y : {p1y, p2y}) {
                G[y][x] = '*';
            }
        } else {
            int min_y = min(p1y, p2y);
            int max_y = max(p1y, p2y);
            int min_x = min(p1x, p2x);
            int max_x = max(p1x, p2x);

            for (int y : {min_y, max_y}) {
                for (int x : {min_x, max_x}) {
                    G[y][x] = '*';
                }
            }
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
