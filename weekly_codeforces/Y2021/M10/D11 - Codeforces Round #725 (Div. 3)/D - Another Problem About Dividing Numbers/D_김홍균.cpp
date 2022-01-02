//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <numeric>
#include <cstring>
#include <vector>

using namespace std;

#define endl '\n'

// Set up : Global Variables
const int MAX = 100000;
bool isPrime[MAX+1];
vector<int> P;

// Set up : Functions Declaration
int factorize(int n);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Process
    memset(isPrime, true, sizeof(isPrime));
    isPrime[0] = isPrime[1] = false;
    for (int i=2; i<=MAX; i++) { // Sieve of Eratosthenes
        if (isPrime[i]) {
            P.push_back(i);  // Get & Save primes
            for (int j=i+i; j<=MAX; j+=i) {
                isPrime[j] = false;
            }
        }
    }


    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        int A, B, K;
        cin >> A >> B >> K;

        // Process
        int g = gcd(A, B);  // Greatest Common Divisor

        int le = 0;  // min K
        if (A/g != 1) le++;  // residual factor of A
        if (B/g != 1) le++;  // residual factor of B
        if (A == B) {
            le = max(le, 2);
        }

        int n1 = factorize(g);  // number of divisors(g)
        int n2 = factorize(A/g);  // number of divisors(A/g)
        int n3 = factorize(B/g);  // number of divisors(B/g)

        // Sum of number of divisors(A) & divisors(B)
        int ge = 2*n1 + n2 + n3;  // max K

        // Control : Output
        cout << ((le <= K && K <= ge) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
int factorize(int n)
{
    int cnt = 0;
    for (int p : P) {
        if (n < p) break;
        while (n % p == 0) {
            cnt++;
            n /= p;
        }
    }
    if (n != 1) cnt++;  // prime in (10^5, 10^9]
    return cnt;
}