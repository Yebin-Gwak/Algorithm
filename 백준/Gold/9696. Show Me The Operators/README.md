# [Gold V] Show Me The Operators - 9696 

[문제 링크](https://www.acmicpc.net/problem/9696) 

### 성능 요약

메모리: 16124 KB, 시간: 156 ms

### 분류

사칙연산, 많은 조건 분기, 자료 구조, 덱, 구현, 수학, 파싱, 문자열

### 제출 일자

2024년 4월 18일 14:54:11

### 문제 설명

<p>A programming instructor needs your help to teach his students on precedence level of binary arithmetic operators (+, -, *, /). Write a program which can show the sequence of operators executed when evaluating an arithmetic expression according to the precedence rules below.</p>

<p>Precedence rules:</p>

<ol>
	<li>Multiplication and division operators have higher precedence than plus and minus operators</li>
	<li>Multiplication and division operators have the same level of precedence. However, in an expression, the operator which appears first from the left of the expression has higher precedence.</li>
	<li>Plus and minus operators have the same level of precedence. However, in an expression, the operator which appears first from the left of the expression has higher precedence.</li>
</ol>

<p>Evaluation of expression starts from left o right.</p>

### 입력 

 <p>The first line of the input data contains an integer which represents the number of test cases. The line is then followed by the data for each of the test cases. Each test case contains an arithmetic expression containing mixture of positive integer operands and binary arithmetic operators (with a space in between). For simplicity, let’s assume the maximum number of operators in an expression is limited to 10.</p>

### 출력 

 <p>The output comprises of one line for each test case (arithmetic expression). The line begins with prefix “Case #x:” where x represents the case number, followed by the output of the test case. For each test case, a list of arithmetic operators will be produced according to the precedence they were executed in the expression. The list is terminated with the final result of the execution.</p>

