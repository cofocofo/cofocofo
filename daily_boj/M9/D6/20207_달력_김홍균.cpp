//
//  BOJ
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
    int N; cin >> N;
    int D[365+2] = {0, };
    for (int i=0; i<N; i++) {
        int S, E;
        cin >> S >> E;
        D[S]++, D[E+1]--;
    }

    // Process
    /* Prefix Sum */
    for (int i=2; i<=365; i++) {
        D[i] += D[i-1];
    }

    int ans = 0;
    for (int i=1; i<=365; i++) {
        if (D[i] > 0) {
            int cnt = D[i];
            int j = i;
            /* Connected Schedule */
            while (j+1 <= 365 && D[j+1] > 0) {
                j++;
                cnt = max(cnt, D[j]);
            } ans += (j-i+1) * cnt; /* width * height */
            i = j; /* Update i */
        }
    }

    // Control : Output
    cout << ans << endl;
}

// Helper Functions
/* None */