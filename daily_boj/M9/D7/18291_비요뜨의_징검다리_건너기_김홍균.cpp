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
const long MOD = (long)(1e9+7);

// Set up : Functions Declaration
long pow2(long n);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        int N; cin >> N;

        // Process
        /* nCr
         * n = N-2 (1번과 N번 징검다리는 무조건 밟아야 함)
         * r = 0, ..., N-2
         * sum( (N-2)C0 + (N-2)C1 + ... + (N-2)C(N-1) + (N-2)C(N-2) = 2^(N-2)
         */
        long ans = pow2(N-2);

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
long pow2(long n)
/* O(logn) power of 2 */
{
    if (n <= 0)
        return 1;
    if (n & 1) {
        return 2 * (pow2(n-1)) % MOD;
    } else {
        long t = pow2(n/2);
        return t * t % MOD;
    }
}

// 2 - 1
// 1 2

// 3 - 2
// 1 3
// 1 2 3

// 4 - 4
// 1 4
// 1 2 4
// 1 3 4
// 1 2 3 4

// 5 - 8
// 1 5
// 1 2 5
// 1 3 5
// 1 4 5
// 1 2 3 5
// 1 2 4 5
// 1 3 4 5
// 1 2 3 4 5