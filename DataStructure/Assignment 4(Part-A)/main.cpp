#include <iostream>
#include <chrono>
#include <ctime>
using namespace std;

void populatearray(int a[],int size){
    for(int i=0;i<size;i++)
    {
        a[i] = i+1;
    }
}

int search(int a[],int size,int value) {
    int first, last, middle;
    first = 0;
    last = size;
    middle = (first+last)/2;
    while (first <= last)
    {
        if(a[middle] < value)
        {
            first = middle + 1;
        }
        else if(a[middle] == value)
        {
            return middle;
        }
        else {
            last = middle - 1;
        }
        middle = (first + last)/2;
    }
    if(first > last)
    {
        return -1;
    }
}

int main() {
    const int size = 10000;
    int a[size];
    populatearray(a, size);
    int searchresult = 0;
    for (int i = 1; i <= size; i++) {
        auto t1 = chrono::high_resolution_clock::now();
        searchresult = search(a, size, i);
        auto t2 = chrono::high_resolution_clock::now();

        if (searchresult <= 0) {
            cout << "No result found for " << i << endl;
        } else {
            cout << i << " was found at position " << searchresult << endl;
        }

//        time_t ttp1 = std::chrono::high_resolution_clock::to_time_t(t1);
//        time_t ttp2 = std::chrono::high_resolution_clock::to_time_t(t2);
//        cout << "Start time\t: " << ctime(&ttp1) << "End time\t: " << ctime(&ttp2) << "Duration\t: "
//             << chrono::duration_cast<chrono::microseconds>(t2 - t1).count() << " microseconds." << "\n" << endl;

        cout << "Start time\t: " << t1.time_since_epoch().count() << "\nEnd time\t: " << t1.time_since_epoch().count() <<"\nDuration\t: " <<chrono::duration_cast<chrono::microseconds>(t2 - t1).count() << " microseconds." << "\n" <<endl;
    }
}