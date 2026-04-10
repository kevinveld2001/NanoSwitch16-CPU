@page(0)
PJP 2

@page(1)

value_a:
@define(0)
value_b:
@define(0)

one:
@define(1)

temp:
@define(0)

@define(0, 0)

data:
@define( 5, 7, 2, 9, 4, 10, 1, 6, 3, 8)


@page(2)
NOP
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

PJP 3

reset:
NOP
PJP 5

one_value:
@define(1)



@page(3)
NOP
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
NOP
PJP 4

b_bigger:
NOP
PJP 2


@page(4)
NOP
RSL 2
LDA pointer_a
NOP
RSL 6
STA from_a
STA temp_to_a

NOP
RSL 2
LDA pointer_b
NOP
RSL 6
STA to_temp
STA to_b

PJP 6


@page(5)
NOP
RSL 5
LDA start_of_data
NOP
RSL 2
STA pointer_a
STA pointer_b
PJP 2

start_of_data:
@define(5)


@page(6)
NOP
RSL 1

to_temp:
LDA 0
STA temp

from_a:
LDA 0
to_b:
STA 0

LDA temp
temp_to_a:
STA 0

PJP 2
