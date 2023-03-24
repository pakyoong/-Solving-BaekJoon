#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

int solution(int n) {
    int answer = 0;
    for(int i=2; i<=n; i++){
        for(int j=2; j<=(sqrt(i)); j++){
            if(i%j==0){
                answer++;
                break;
            }
        }
    }
    return answer;
}