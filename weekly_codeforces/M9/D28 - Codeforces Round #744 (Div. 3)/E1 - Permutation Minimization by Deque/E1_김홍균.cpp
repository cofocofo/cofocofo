//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <deque>

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
        int P[N];
        for (int i=0; i<N; i++)
            cin >> P[i];

        // Process
        deque<int> deq;
        deq.push_back(P[0]); /* Init */

        /* Maximize deque in lexicographically */
        for (int i=1; i<N; i++) {
            if (deq.front() > P[i]) {
                deq.push_front(P[i]);
            } else {
                deq.push_back(P[i]);
            }
        }

        // Control : Output
        for (int i=0; i<N; i++) {
            cout << deq[i] << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */