//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>
#include <set>

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
        int n; cin >> n;
        int Q[n];
        for (int i=0; i<n; i++)
            cin >> Q[i];

        // Process
        int P1[n], P2[n];
        memset(P1, -1, sizeof(P1));  /* Lexicographically minimal permutation */
        memset(P2, -1, sizeof(P2));  /* Lexicographically maximum permutation */
        bool isUsed[n+1];
        memset(isUsed, false, sizeof(isUsed));

        /*
         * Init P1, P2 using Q
         *
         * Q = [3, 3, 4, 4, 7, 7, 7]
         * P1 = [3, -1, 4, -1, 7, -1, -1]
         * P2 = [3, -1, 4, -1, 7, -1, -1]
         */
        P1[0] = P2[0] = Q[0];
        isUsed[Q[0]] = true;
        for (int i=1; i<n; i++) {
            if (Q[i] > Q[i-1]) {
                P1[i] = P2[i] = Q[i];
                isUsed[Q[i]] = true;
            }
        }

        /*
         * Find P1
         *
         * P1 = [3, -1, 4, -1, 7, -1, -1]
         *          #1     #2     #3  #4
         * unUsedNums = [1, 2, 5, 6]
         *
         * #1 - 1
         * #2 - 2
         * #3 - 5
         * #4 - 6
         */
        int num = 1;
        bool isUsedP1[n+1];
        memcpy(isUsedP1, isUsed, sizeof(isUsed));
        for (int i=0; i<n; i++) {
            if (P1[i] == -1) {
                while (isUsedP1[num]) num++;
                P1[i] = num;
                isUsedP1[num] = true;
            }
        }

        /*
         * Find P2
         *
         * P2 = [3, -1, 4, -1, 7, -1 -1]
         *          #1     #2     #3 #4
         * unUsedNums = [1, 2, 5, 6]
         *
         * #1 - 2 (should be less than 3 and max number in unUsedNums)
         * #2 - 1 (should be less than 4 and max number in unUsedNums)
         * #3 - 6 (should be less than 7 and max number in unUsedNums)
         * #4 - 5 (should be less than 6 and max number in unUsedNums)
         */
        set<int> isUsedP2;
        for (int i=1; i<=n; i++) {
            if (not(isUsed[i])) {
                isUsedP2.insert(i);
            }
        }
        for (int i=0; i<n; i++) {
            if (P2[i] == -1) {
                /* num = should be less than P2[i]-1 and max number in unUsedNums
                 *     -> find by lower bound algorithm
                 */
                num = *(--isUsedP2.lower_bound(P2[i-1]));
                P2[i] = num;
                isUsedP2.erase(num);
            }
        }

        // Control : Output
        for (int p1 : P1) {
            cout << p1 << ' ';
        } cout << endl;
        for (int p2 : P2) {
            cout << p2 << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */
