//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

#define endl '\n'

// Set up : Global Variables
#define $a 1
#define $b 2
#define $c 3
#define $d 4
#define $e 5
#define $na 6
#define $nb 7
#define $nc 8
#define $nd 9
#define $ne 10

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
        string W[N];
        for (int i=0; i<N; i++)
            cin >> W[i];

        // Process
        int dp[N][10+1];
        memset(dp, 0, sizeof(dp));

        for (int i=0; i<N; i++) {
            string w = W[i];
            for (char c : w) {
                switch (c) {
                    case 'a': dp[i][$a]++; break;
                    case 'b': dp[i][$b]++; break;
                    case 'c': dp[i][$c]++; break;
                    case 'd': dp[i][$d]++; break;
                    case 'e': dp[i][$e]++; break;
                }
            }
            for (int j=6; j<=10; j++) {
                for (int k=1; k<=5; k++) {
                    if (k == j-5) continue;
                    dp[i][j] += dp[i][k];
                }
            }
        }

        int ans = 0;
        for (int j=1; j<=5; j++) {
            priority_queue<int> pq;
            for (int i=0; i<N; i++) {
                pq.push({dp[i][j] - dp[i][j+5]});
            }

            int time = 0, count = 0;
            while (not(pq.empty())) {
                int diff = pq.top(); pq.pop();
                if (count + diff <= 0) break;
                count += diff;
                time++;
            }

            ans = max(ans, time);
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */