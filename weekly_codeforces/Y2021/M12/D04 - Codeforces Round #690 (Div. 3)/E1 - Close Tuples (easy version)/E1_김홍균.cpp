//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
#define str(x) to_string(x)
#define error logic_error("line " + str(__LINE__))

// Set up : Definitions
typedef long long ll;
struct Pair { ll val, cnt; };

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
        int A[n];
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        map<ll,ll> dp;
        for (int a : A) {
            dp[a]++;
        }

        vector<Pair> P;
        P.reserve(size(dp));
        for (auto [val, cnt] : dp) {
            P.push_back({val, cnt});
        }

        ll ans = 0;
        for (int i=0; i<size(P); i++) {

            auto [i_val, i_cnt] = P[i];
            if (i_cnt >= 3) {
                ans += (i_cnt * (i_cnt-1) * (i_cnt-2) / 6);
            }

            if (i < size(P)-1) {
                auto [j_val, j_cnt] = P[i+1];
                if (abs(j_val - i_val) <= 2) {
                    if (j_cnt >= 2 && i_cnt >= 1) {
                        ans += (j_cnt * (j_cnt-1) / 2 * i_cnt);
                    }
                    if (j_cnt >= 1 && i_cnt >= 2) {
                        ans += (j_cnt * (i_cnt) * (i_cnt-1) / 2);
                    }
                }
            }

            if (i < size(P)-2) {
                auto [j_val, j_cnt] = P[i+1];
                auto [z_val, z_cnt] = P[i+2];
                if (abs(z_val - i_val) <= 2) {
                    if (z_cnt >= 2 && i_cnt >= 1) {
                        ans += (z_cnt * (z_cnt-1) / 2 * i_cnt);
                    }
                    if (z_cnt >= 1 && i_cnt >= 2) {
                        ans += (z_cnt * (i_cnt) * (i_cnt-1) / 2);
                    }

                    if (z_cnt >= 1 && j_cnt >= 1 && i_cnt >= 1) {
                        ans += (z_cnt * j_cnt * i_cnt);
                    }
                }
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
