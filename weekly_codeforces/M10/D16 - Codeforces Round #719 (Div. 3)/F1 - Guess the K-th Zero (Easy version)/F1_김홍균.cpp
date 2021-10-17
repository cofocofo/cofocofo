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
    while (true) {
        int N, T;
        cin >> N >> T;
        int K; cin >> K;

        // Process
        int L = 1, R = N;
        while (L < R) {

//            cout << "L, R : " << L << ", " << R << endl;
            int M = (L+R) / 2;
            cout << "? " << M+1 << ' ' << R << endl << flush;
            int k; cin >> k;

            if (R-M > k) {
                L = M+1;
            } else {
                R = M;
            }
        }

        cout << "! " << L << endl << flush;
        return 0;
    }
}

// Helper Functions
/* None */

// 1 3 4 6
//

// 1 6
// L M M+1 R
// R-(M+1)+1