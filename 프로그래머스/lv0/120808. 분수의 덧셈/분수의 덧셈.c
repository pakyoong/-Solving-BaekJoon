#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int denum1, int num1, int denum2, int num2) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(1);
    int a = denum1 * num2 + denum2 * num1;
    int b = num1 * num2;
    int c = 1;
     for(int i= 1 ; i <= a ; i ++) {
        if(a%i == 0 && b%i == 0) {
            c = i;
        }
    }
    answer[0]= a/c;
    answer[1]= b/c;
    return answer;
}