RSL 1

loop:
LDA value_a
ADD one
CMP a_bigger
STA value_a

LDA value_b
ADD one
CMP b_bigger
STA value_b

JMP loop



a_bigger:
JMP a_bigger

b_bigger:
JMP b_bigger





@page(1)
one:
@define(1)

value_a:
@define(10)
value_b:
@define(6)
