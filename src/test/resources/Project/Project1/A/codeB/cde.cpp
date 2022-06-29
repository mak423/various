#include <iostream>
using namespace std;

int main()
{
    unsigned int N; //declaring variables

    unsigned long long factorial = 1;

    cout << "Enter a     positive      integer: ";
    cin >> n;


    for(int i = 1; i <=n; ++i)
    {
        factorial *= i;
    }
    /*
    assd
    asd
    */
    cout << "Factorial of " << n << " = " << factorial; //factorial is here     
    return 0;
}



int getSum()
{
    int n, SUM = 0;

    cout << "Enter a positive integer: ";
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        sum += i;
    }

    cout << "Sum = " << sum;
    return 0;
}