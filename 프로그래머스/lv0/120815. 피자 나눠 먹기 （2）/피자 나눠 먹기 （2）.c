#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>


int solution(int n) {
    int answer = 1;
    while (1)
    {
        if ((6 * answer) % n != 0)
            answer++;
        else
            break;
    }
    return answer;
}