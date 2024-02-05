RSL 1
start:
LDA a
ADD b
CMP reset
STA c

LDA b
STA a

LDA c
STA b
JMP start

reset:
PJP 2


@page(1)
a:
@define(1)
b:
@define(1)
c:
@define(1)

one:
@define(1)
null:
@define(0)


@page(2)
LDA one
STA a
STA b
LDA null
STA c
PJP 0