#  Stack 백준 문제 : 쇠막대기

## 문제 설명 
--- 
쇠막대기를 레이저로 자르려고 한다.
잘려진 쇠막대기 조각의 총 개수를 구해라.

문제를 풀기 위해서 필요한 조건은 다음과 같다.
- '()'의 경우는 무조건 레이저를 의미한다.
- 위에를 제외한 경우는 모두 쇠막대기의 각 끝점이다.
- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다. <br>


<br>

## 첫 번째 문제 풀이
--- 
괄호의 짝을 찾는 문제와 똑같이 해결했다. (Stack 활용)
1) '(' 이 나올 경우 모두 stack에 넣어준다.
2) ')'이 나올 경우는 두개로 나뉘어서 생각한다. <br><br>
   * 바로 직전의 괄호가 '('일 경우 : <br>레이저에 해당하기 때문에 stack 에 쌓인 '('의 개수(stack 의 길이 - 1)를 활용해서 해당 레이저로 생긴 쇠막대기 조각의 개수를 계산한다.
   *  바로 직전의 괄호가 ')'일 경우 : <br>쇠막대기의 오른쪽 끝점을 의미한다. 따라서 쇠막대기의 왼쪽 끝점을 pop 해준다.<br>
   <br> ** 무조건 적어도 하나의 레이저가 쇠막대기를 지나기 때문에 쇠막대기가 끝나는 지점에서 answer + 1 를 한다.

<br>
해당 과정을 거치고 총 합계 즉 answer 값을 출력한다.
<br>
<br>

--- 
<br>
문제풀이 하는데 걸린 시간 : 20분
<br> 해당 시간만큼 걸린 이유 : 알고리즘을 알고 풀어서 금방 풀이 방법을 알 수 있었다.
<br> 출처 : https://www.acmicpc.net/problem/10799

```
다른 풀이도 고민해보고 추가한다.
```