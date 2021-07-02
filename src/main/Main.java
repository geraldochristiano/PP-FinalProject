package main;

import error_listener.ParsingErrorListener;
import grammar.DLexer;
import grammar.DParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import spril_converter.PreGenerator;
import spril_converter.Result;
import spril_converter.SprilGenerator;
import type_checking.TypeAndDeclarationChecker;

public class Main {

    static String ARGUMENT = """
            
            """;

    public static void main(String[] args) {
        /*if (args.length == 0){
            System.out.println("No arguments!");
            return;
        }*/

        // Lexical analysis and parsing
        CharStream stream = CharStreams.fromString(ARGUMENT);
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
        if (!TypeAndDeclarationChecker.INSTANCE.checkProgram(tree)) return;

        Result result = PreGenerator.INSTANCE.preConvert(tree);
        System.out.println(SprilGenerator.INSTANCE.convertToSpril(tree, result));
    }
}
