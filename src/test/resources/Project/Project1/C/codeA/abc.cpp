#include <iostream>
using namespace std;

int main() {
   int n, i;
   int a; int b;
   int sum = a + b;



   bool isPrime = true;

   cout << "Enter a positive integer: ";
   cin >> n;

   for (i = 2; i <= n / 2; ++i) {   //loop has started 
      if (n % i == 0) {
         isPrime = false;
         break;
      }
   }
   if (isPrime)
      cout << n << " is a prime number";
   else


      cout << n << " is not a prime number";

   return 0;
}
