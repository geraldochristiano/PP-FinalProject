package main;

import error_listener.ParsingErrorListener;
import grammar.DLexer;
import grammar.DParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import spril_converter.PreConverter;
import spril_converter.Result;
import spril_converter.SprilConverter;
import type_checking.TypeAndDeclarationChecker;

public class Main {

    static String ARGUMENT = """
            int a = 3;
            parallel{}
            """;
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("No arguments!");
            //return;
        }
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
        TypeAndDeclarationChecker typeDeclarationChecker = TypeAndDeclarationChecker.INSTANCE;
        if (!typeDeclarationChecker.checkProgram(tree)) return;

        Result result = PreConverter.INSTANCE.preConvert(tree);
        System.out.println(SprilConverter.INSTANCE.convertToSpril(tree, result));
    }
}
