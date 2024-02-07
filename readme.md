# NanoSwitch16
The NanoSwitch16 is a 4-bit CPU. The CPU has 16 pages of 16 bytes RAM. The CPU has a super small instruction
set. It is enough to be Turing complete. however, this makes writing programs for it challenging. Additionally, it
also has some instructions to make use of the 16 pages. You can use the pages for code, variables, or both.

The project also comes with an assembler that can convert assembly code into machine code that the CPU understands.
It is built in Java and takes the input file path as a parameter. It will then make a .bin file in the same folder
with the assembled code.

## Instruction set
The instrucion is contained in a opcode and a operand.
```
0b 0000 0000
   [  ] [  ]
   |    L operand
   |
   L opcode
```

Instructions:
```
NOP     0x0     0b0000  : No instruction
LDA     0x1     0b0001  : Load value from ram using the operand as the address. Into `a` register.
STA     0x2     0b0010  : Store value from `a` register to address in operand.    
ADD     0x3     0b0011  : Add `a` register and add ram value of the operand address. And put the result into 
                          the `a` register.
JMP     0x4     0b0100  : Jump to address in uperand.
CMP     0x5     0b0101  : If carry flag is set after `ADD` jump to address in uperand.

INP     0x6     0b0110  : (not implemented)
OUT     0x7     0b0111  : (not implemented)

PJP     0x8     0b1000  : Jump to first adress of a page defined in uperand.
RSU     0x9     0b1001  : Set RAM page register to the uper (high byte) part of the page defined in operand.
RSL     0xa     0b1010  : Set RAM page register to the lower (low byte) part of the page defined in operand.


NOP     0xb     0b1011  : No instruction. Possible expansion
NOP     0xc     0b1100  : No instruction. Possible expansion
NOP     0xd     0b1101  : No instruction. Possible expansion
NOP     0xe     0b1110  : No instruction. Possible expansion
NOP     0xf     0b1111  : No instruction. Possible expansion
```

## registers

| name             | bits | explanation                                                                      |
| ---------------- | ---- | -------------------------------------------------------------------------------- | 
| `FETCH`          | 1    | Swaps every clock cycle and determines if it should fetch or execute.            |
| `A`              | 4    | This register can be writen to and read from. It is also used for the ALU.       |
| `CARRY`          | 1    | If add operation has a carry bit it will be set to `1` else to a `0`.            |
| `INSTRUCTION`    | 8    | After fetch this will hold the opcode and operand.                               |
| `PROGRAM_PAGE`   | 4    | High byte address to define the current program execute page. default is `0`.    |
| `RAM_PAGE`       | 4    | High byte address to define the current page where vars are stored. default: `1`.|
| `RAM_SIDE`       | 1    | DEFINES if the processor should read/write to `LOW` or `HIGH` byte. default:`LOW`|
