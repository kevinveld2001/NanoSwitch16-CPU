start:
LDA 0
ADD 1
CMP halt
STA 2

LDA 1
STA 0

LDA 2
STA 1
JMP start

halt:
JMP halt

@page(1)
@define(1, 1)