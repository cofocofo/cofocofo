//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <queue>

using namespace std;

#define endl '\n'

// Set up : Global Variables
typedef pair<int,int> pii;

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
        int A[N+1];
        for (int i=1; i<=N; i++)
            cin >> A[i];

        // Process
        priority_queue<pii> pq; /* Use Priority Queue for
                                 * extract the most sociability person */
        for (int i=1; i<=N; i++) {
            pq.emplace(A[i], i); /* Sociability, No */
        }

        vector<pii> V;
        while (pq.size() > 1) {
            auto [s1, n1] = pq.top(); pq.pop();
            auto [s2, n2] = pq.top(); pq.pop();

            if (s1 > 0 && s2 > 0) { /* Talk */
                V.emplace_back(min(n1, n2), max(n1, n2));
                pq.emplace(s1-1, n1);
                pq.emplace(s2-1, n2);
            } else if (s1 > 0) { /* s2 == 0, n2 leave meeting */
                pq.emplace(s1, n1);
            } else if (s2 > 0) { /* s1 == 0, n1 leave meeting */
                pq.emplace(s2, n2);
            }
        }

        // Control : Output
        cout << V.size() << endl;
        for (auto [n1, n2] : V) {
            cout << n1 << ' ' << n2 << endl;
        }
    }
}

// Helper Functions
/* None */