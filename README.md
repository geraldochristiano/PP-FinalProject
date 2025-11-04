## Description
This repo contains the final project for Programming Paradigms course at University of Twente, which is the construction of a compiler for a custom language called *D*.  

The compiler does **NOT** compile to native machine code, instead it compiles to SprIL (Sprockell Intermediate Language). The compiled SprIL code is run by the Sprockell virtual machine (VM) written in Haskell. This can be compared to the Java bytecode and JVM.

This projects depends on [ANTLR v4](https://www.antlr.org/) for parsing. This dependency can be added with Maven, Eclipse plugin (which we use), or downloaded from the website.

## Usage
To start using the compiler, you must either pass the program string (written in D language) to the "ARGUMENT" field in the main class or pass the arguments as string in the command  line when running the main class. (see next section for location of main class) 

The program will then prompt you if you want to change the channel delay and shared memory size for the Sprockell VM which you can change if you want to. 

Do note that this will affect the behaviour of the program, so don't fill them if you are not sure or do not know the channel delay or shared memory size of your Sprockell program.

## Source files
The source code of the program is in 'src' directory. The main class of the program is in 'src/main/' directory named
'Main.java'. The class have a static field named "ARGUMENT" in which you can pass your program string.

## Sprockell
Since the Sprockell is also extended, we also include it here. The 'sprockell' directory contains the source files of the Sprockell. Only the 'src' directory of the Sprockell is included and not the other files (Cabal file,etc).

## Generated source files
ANLTR generate several source files for our language. The files are located in the 'gen' directory.
The generated source files are the lexer and parser of our language, and the tree visitor and tree
listener for the parse tree of our language.

## Other files
There are also other files/folders in the current directory such as ".idea" folder, and ".iml" file. These are files
generated and used by IntelliJ to configure the project. You can ignore them if you
are not using IntelliJ.

The "pom.xml" defines the ANTLR dependency of this project for Maven. 
