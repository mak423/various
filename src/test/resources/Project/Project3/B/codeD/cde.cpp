#include <iostream>
using namespace std;

int main()
{
    unsigned int N;
    unsigned long long factorial = 1;

    cout << "Enter      a positive integer: "; //getting input
    cin >> n;

    for(int i = 1; i <=n; ++i)
    {
        factorial *= i;
    }

    cout << "Factorial of " << n << " = " << factorial;  //factorial is here 
    return 0;
}

#ifdef isRootenabled


int roots() {

    float a, b, c, x1, x2, discriminant, realPart, imaginaryPart; //parting the numbers
    cout << "Enter coefficients a, b and c: ";
    cin >> a >> b >> c;
    discriminant = b*b - 4*a*c;
    
    //first check
    if (discriminant > 0) {
        x1 = (-b + sqrt(discriminant)) / (2*a);
        x2 = (-b - sqrt(discriminant)) / (2*a);
        cout << "Roots are real and different." << endl;
        cout << "x1 = " << x1 << endl;
        cout << "x2 = " << x2 << endl;
    }
    //second check
    else if (discriminant == 0) {
        cout << "Roots are real and same." << endl;
        x1 = (-b + sqrt(discriminant)) / (2*a);
        cout << "x1 = x2 =" << x1 << endl;
    }
    
    //second check

    else {
        realPart = -b/(2*a);
        imaginaryPart =sqrt(-discriminant)/(2*a);
        cout << "Roots are complex and different."  << endl;
        cout << "x1 = " << realPart << "+" << imaginaryPart << "i" << endl;
        cout << "x2 = " << realPart << "-" << imaginaryPart << "i" << endl;
    }

    return 0;
}
#endif