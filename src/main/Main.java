package main;

import error_listener.ParsingErrorListener;
import grammar.DLexer;
import grammar.DParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import type_checking.TypeAndDeclarationChecker;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("No arguments!");
            return;
        }
        // Lexical analysis and parsing
        CharStream stream = CharStreams.fromString(args[0]);
        ParsingErrorListener errorListener = new ParsingErrorListener();
        DLexer lexer = new DLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        DParser parser = new DParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.program();
        if (errorListener.hasErrors()){
            System.out.println("Parsing error! Messages:");
            errorListener.getErrors().forEach(System.out::println);
            return;
        }

        // Type and declaration checking
        TypeAndDeclarationChecker typeDeclarationChecker = TypeAndDeclarationChecker.INSTANCE;
        if (!typeDeclarationChecker.checkProgram(tree)) return;

    }
}
