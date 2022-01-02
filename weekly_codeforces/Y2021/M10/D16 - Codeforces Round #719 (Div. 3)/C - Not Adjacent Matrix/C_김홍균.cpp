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

    for (int tc=1; tc<=TC; tc++) {
        int N; cin >> N;

        // Control : Output
        if (N == 2) {
            cout << -1 << endl;
            continue;
        }

        // Process
        int idx = 0;
        int A[N][N];  // matrix

        // fill odd numbers in matrix
        for (int val=1; val<=N*N; val+=2) {
            int y = idx / N;
            int x = idx % N;
            A[y][x] = val;
            idx++;
        }
        // fill even numbers in matrix
        for (int val=2; val<=N*N; val+=2) {
            int y = idx / N;
            int x = idx % N;
            A[y][x] = val;
            idx++;
        }

        /*
         * N = 3
         * 1 3 5
         * 7 9 2
         * 4 6 8
         *
         * N = 4
         *  1  3  5  7
         *  9 11 13 15
         *  2  4  6  8
         * 10 12 14 16
         */

        // Control : Output
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                cout << A[i][j] << ' ';
            } cout << endl;
        }
    }
}

// Helper Functions
/* None */
