//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
struct Player { int no, token; };
typedef long long ll;

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
    int t; cin >> t;

    while (t--) {
        int n; cin >> n;
        vector<Player> P(n);
        for (int i=0; i<n; i++) {
            P[i].no = i+1;  /* order */
            cin >> P[i].token;
        }

        // Process
        sort(P.begin(), P.end(), [](const Player &u, const Player &v) {
            return make_pair(u.token, u.no) < make_pair(v.token, v.no);
        });  /* sort by (token, no) */

        ll sum = 0;
        int cnt = 0;
        for (int i=0; i<n-1; i++) {
            cnt++;
            sum += P[i].token;
            if (sum < P[i+1].token) {
                cnt = 0;
            }
        } cnt++;  /* last */

        vector<int> V(cnt);
        for (int i=0; i<cnt; i++) {
            V[i] = P[(n-1)-i].no;
        } sort(V.begin(), V.end());

        // Control : Output
        cout << cnt << endl;
        for (int e : V) {
            cout << e << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */
