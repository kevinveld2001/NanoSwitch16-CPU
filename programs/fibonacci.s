start:
LDA 0
ADD 1
STA 2
NOP

LDA 1
STA 0
NOP

LDA 2
STA 1
NOP
JMP start

@page(2)
@dcb 1, 1