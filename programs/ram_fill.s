start:
LDA number
RSL 1
write:
STA 0
RSU 1
write_uper:
STA 0

RSL 0
LDA pointer
ADD one
STA pointer
STA write
STA write_uper
JMP start


number:
@define(15)

pointer:
@define(0)
one:
@define(1)