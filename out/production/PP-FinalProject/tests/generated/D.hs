import Sprockell
import Data.Char

prog::[Instruction]
prog = [
	--whilst go
	Load (ImmValue (0)) regE,
	Compute Add regE regF regF,
	 -- inserting continue
	Load (ImmValue (6)) regC,
	Compute Add regPC regC regC,
	Store regC (IndAddr regF),
	 -- inserting break
	Load (ImmValue (7)) regC,
	Compute Add regPC regC regC,
	Compute Incr regF regF regE,
	Store regC (IndAddr regE),
	-- whilst condition
	Load (ImmValue (1)) regA,
	Push regA,
	Pop regA,
	Branch regA (Rel 2),
	Jump (Rel (4)),
	 -- body
	Nop,
	Load (IndAddr regF) regE,
	Jump (Ind regE),
	-- body end
	Load (ImmValue (0)) regE,
	Compute Sub regF regE regF,
	 --whilst end
	EndProg]

main = run [prog]
main_1 = runWithDebugger (debuggerSimplePrintAndWait myShow) [prog]
