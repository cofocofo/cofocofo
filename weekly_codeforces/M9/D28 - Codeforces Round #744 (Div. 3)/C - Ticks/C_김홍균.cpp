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
        int N, M, K;
        cin >> N >> M >> K;
        char G[N][M];
        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                cin >> G[i][j];

        // Process
        bool isVisited[N][M];
        memset(isVisited, false, sizeof(isVisited));

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                /* Center cell (i, j) */
                if (G[i][j] == '*' && not(isVisited[i][j])) {
                    int d = 1;
                    /* Check Tick & Calculate d */
                    for (; i-d>=0 && j-d>=0 && j+d<M; d++) {
                        if (G[i-d][j-d] == '*' && G[i-d][j+d] == '*') {
                            continue;
                        } else {
                            break;
                        }
                    } d--;

                    /* Paint Tick */
                    if (d >= K) {
                        for (int k=0; k<=d; k++) {
                            isVisited[i-k][j-k] = isVisited[i-k][j+k] = true;
                        }
                    }
                }
            }
        }

        /* Check All Tick cells painted */
        bool isPossible = true;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (G[i][j] == '*' && not(isVisited[i][j])) {
                    isPossible = false;
                    goto end;
                }
            }
        } end:

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */