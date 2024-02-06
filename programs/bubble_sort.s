@page(0)
PJP 2

@page(1)

value_a:
@define(0)
value_b:
@define(0)

@define(0, 0, 0, 0)

data:
@define( 5, 7, 2, 9, 4, 10, 1, 6, 3, 8)


@page(2)
loop:
RSL 2
LDA pointer_b
STA pointer_a
ADD one_value
CMP reset
STA pointer_b
RSL 1

pointer_a:
LDA data
STA value_a

pointer_b:
LDA data
STA value_b

JMP loop

reset:
NOP
PJP 5

one_value:
@define(1)



@page(5)
RSL 5
LDA start_of_data
RSL 2
STA pointer_a
STA pointer_b
PJP 2

start_of_data:
@define(5)
