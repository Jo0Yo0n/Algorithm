/**
 * @file prob8-1.cpp
 * @author JOOYOOtextLen LEE (dlwndbs10@gmail.com)
 * @brief 주어진 Text string에서 pattern을 모두 찾는 3가지 알고리즘
 * 1. Brute force 2. KMP 3. Rabin-Karp 을 구현하고,
 * 주어진 자료에 대해 각 알고리즘이 수행한 문자비교 회수와 비교표 출력.
 *
 * Text String: "A STRING SEARCHING EXAMPLE CONSISTING OF A GIVEN STRING"
 * Pattern String: "STING"
 *
 * @version 0.1
 * @date 2022-11-03
 *
 * @copyright Copyright (c) 2022
 */

#include <cstdlib>
#include <cstring>
#include <iostream>

int bruteSearch(char* pattern, char* text);
void initnext(char* pattern);
int kmpSearch(char* pattern, char* text);
int rkSearch(char* pattern, char* text);

const int q = 33554393;
const int d = 32;
int bruteSearchCount = 0;
int kmpSearchCount = 0;
int rkSearchCount = 0;
int SP[100];

int main() {
    char text[100] = "AAAAAAAAAAAAAAAAAAAAAAAA";  // textLen == 55
    char pattern[20] = "AAAAAAAAAB";                                                  // patternLen == 5
    std::cout << strlen(text) << " " << strlen(pattern) << '\n';
    std::cout << bruteSearch(pattern, text) << '\n';
    std::cout << kmpSearch(pattern, text) << '\n';
    //std::cout << rkSearch(pattern, text) << '\n';

    std::cout << "bruteSearchCount: " << bruteSearchCount << '\n';
    std::cout << "kmpSearchCount: " << kmpSearchCount << '\n';
    //std::cout << "rkSearchCount: " << rkSearchCount << '\n';
}

/**
 * @brief BruteForece Search
 *
 * @param pattern -> text 문자열에서 찾고자하는 문자열
 * @param text -> 비교할 문자열
 * @return int -> text 내의 pattern이 존재하는 위치
 */
int bruteSearch(char* pattern, char* text) {
    int i, j, patternLen = strlen(pattern), textLen = strlen(text);

    for (i = 0, j = 0; j < patternLen && i < textLen - patternLen; i++, j++) {
        bruteSearchCount++;

        bruteSearchCount++;
        if (text[i] != pattern[j]) {
            i -= j;  // 비교가 실패할 때마다 한 칸씩 앞으로 이동
            j = -1;  // 비교할 문자열인 pattern은 처음으로 돌아감
        }
    }
    bruteSearchCount++;

    if (j == patternLen)  // text 문자열 내의 pattern이 존재하는 위치 반환
        return i - patternLen;
    else           // text 문자열 내에 pattern이 존재하지 않는 경우
        return i;  // textLen - patternLen의 결과 반환
}

/**
 * @brief SP[i] 배열을 초기화
 * SP[i] : 주어진 문자열의 0~i까지의 부분 문자열 중에서 prefix == suffix가
 * 될 수 있는 부분 문자열 중에서 가장 긴 것의 길이
 * (이때, prefix가 0~i까지의 부분 문자열과 같을 수는 없다.)
 *
 * @param pattern SP 배열의 대상이 되는 pattern 문자열
 */
void initSP(char* pattern) {
    int i, j, patternLen = strlen(pattern);
    SP[0] = -1;
    for (i = 0, j = -1; i < patternLen; i++, j++, SP[i] = j) {
        kmpSearchCount++;

        while ((j >= 0) && (pattern[i] != pattern[j])) {
            kmpSearchCount++;
            j = SP[j];
        }
        kmpSearchCount++;
    }
    kmpSearchCount++;
}

int kmpSearch(char* pattern, char* text) {
    int i, j, patternLen = strlen(pattern), textLen = strlen(text);
    initSP(pattern);

    for (i = 0, j = 0; j < patternLen && i < textLen - patternLen; i++, j++) {
        kmpSearchCount++;

        while ((j >= 0) && (text[i] != pattern[j])) {
            kmpSearchCount++;
            j = SP[j];
        }
        kmpSearchCount++;
    }
    kmpSearchCount++;

    if (j == patternLen)  // text 문자열 내의 pattern이 존재하는 위치 반환
        return i - patternLen;
    else           // text 문자열 내에 pattern이 존재하지 않는 경우
        return i;  // textLen - patternLen의 결과 반환
}

/*
int rkSearch(char* pattern, char* text) {
    int i, dM = 1, h1 = 0, h2 = 0;
    int patternLen = strlen(pattern), textLen = strlen(text);
    for (i = 1; i < patternLen; i++) {
        dM = (d * dM) % q;
    }
    for (i = 0; i < patternLen; i++) {
        h1 = (h1 * d + index(pattern[i])) % q;
        h2 = (h2 * d + index(text[i])) % q;
    }
    for (i = 0; h1 != h2; i++) {
        h2 = (h2 + d * q - index(text[i]) * dM) % q;
        h2 = (h2 * d + index(text[i + patternLen])) % q;
        if (i > textLen - patternLen) return textLen;
    }
}
*/