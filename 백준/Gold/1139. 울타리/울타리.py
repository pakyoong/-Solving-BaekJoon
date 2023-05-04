from math import sqrt
from itertools import combinations

def main():
    N = int(input())
    fences = list(map(int, input().split()))
    fences.sort()

    dp = [-1 for _ in range(1 << N)]

    def solve(state):
        if dp[state] != -1:
            return dp[state]

        dp[state] = 0

        for i, j, k in combinations(range(N), 3):
            if not (state >> i) & 1 and not (state >> j) & 1 and not (state >> k) & 1:
                if fences[i] + fences[j] > fences[k]:
                    p = (fences[i] + fences[j] + fences[k]) / 2
                    area = sqrt(p * (p - fences[i]) * (p - fences[j]) * (p - fences[k]))
                    dp[state] = max(dp[state], area + solve(state | (1 << i) | (1 << j) | (1 << k)))

        return dp[state]

    print(solve(0))

if __name__ == '__main__':
    main()
