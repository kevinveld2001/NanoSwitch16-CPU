start:
LDA 0
ADD 1
CMP halt
STA 2
NOP

LDA 1
STA 0
NOP

LDA 2
STA 1
NOP
JMP start

halt:
JMP halt

@page(2)
@dcb(1, 1)