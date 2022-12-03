#include<iostream>

using namespace std;

class Base {
    public:
    // Base(int a) {
    //     cout << "in base class constructor " << a << endl;
    // }
    
    void basefunction() {
        cout << "base function" << endl;
    }

    virtual void virtualfunction() {
        cout << "virtual function in base" << endl;
    }

    virtual void purevirtualfunction() = 0;

};

class Derived : public Base{
    public:
    // Derived() {
    //     cout << "int derived class constructor " << endl;
    // }

    void derivedfunction() {
        cout << "derived function" << endl;
    }

    void virtualfunction() {
        cout << "virtual function in derived" << endl;
    }

    void purevirtualfunction() {
        cout << "pure virtual function in derived" << endl;
    }
};

int main() {
    Derived d;
    d.basefunction();
    d.derivedfunction();
    d.virtualfunction();
    d.purevirtualfunction();
}
