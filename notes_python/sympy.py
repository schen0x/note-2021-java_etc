from sympy import symbols, solve
x= symbols('x')

lhs = 93.9/x-0.82

sol = solve(lhs, x)

print(sol)
