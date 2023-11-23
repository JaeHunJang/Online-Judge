#include<iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        std::cout << "#" << test_case << " ";
        
        int n;
        std::cin >> n;

        std::vector<int> arr(n);
        std::vector<int> list;

        int min = 100001;
        for (int i = 0; i < n; i++) {
            int num;
            std::cin >> num;
            list.push_back(std::abs(num));
            if (list[i] < min) 
                min = list[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (list[i] == min)
                count++;
        }

        std::cout << min << " " << count << std::endl;
        
	}
	return 0;
}