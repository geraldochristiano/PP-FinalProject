package tests;

import grammar.DLexer;
import grammar.DParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;
import spril_converter.PreGenerator;
import spril_converter.Result;
import spril_converter.SprilGenerator;
import type_checking.TypeAndDeclarationChecker;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class SemanticsTest {
    private final TypeAndDeclarationChecker checker = new TypeAndDeclarationChecker();

    @Test
    public void operationTest() throws IOException {
        testTrue("int a = 6 - 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 4")));
        testTrue("int a = 6 + 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 8")));
        testTrue("int a = 6 * 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 12")));
//        testTrue("int a = 6 / 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 3")));
//        testTrue("int a = 6 ^ 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 36")));
        testTrue("int a = 6; a++; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 7")));
        testTrue("int a = 6; a--; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 5")));
        testTrue("int a = 15 >> 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 3")));
        testTrue("int a = 15 << 2; print(a);", new ArrayList<>(Collections.singletonList("Sprockell 0 says 60")));
    }

    @Test
    public void daysOfFebruary() throws IOException {
        //This test includes if-else-statement, while loop, for loop,
        // primitive type declaration, initialisation, and usage,
        // and print statement
        String expr = """
                int result;
                int year;
                
                loop (int i = 2000; | i < 2020 | i++;) {
                    year = i;
                    
                    whenever (year > 4 and year < 8) {
                        result = 28;
                        break;
                    }
                    
                    whilst (year >= 4) {
                        year = year - 4;
                    }
                    
                    
                    
                    whenever (year == 0) {
                        result = 29;
                    } elseways {
                        result = 28;
                    }
                    print(result);
                }
                """;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 2000; i < 2020; i++) {
            if (i % 4 == 0) {
                result.add("Sprockell 0 says 29");
            } else {
                result.add("Sprockell 0 says 28");
            }
        }
        testTrue(expr, result);
    }

    @Test
    public void petersonsTest() throws IOException {
        String expr =
                """
                        shared bool flag0 = no-go;
                        shared bool flag1 = no-go;
                        shared int turn;
                        shared int result = 0;
                        
                        parallel {
                            critical {
                                flag1 = go;
                                turn = 0;
                                whilst (flag0 and turn == 0);
                                result = result + 5;
                                flag1 = no-go;
                            }
                            critical {
                                flag0 = go;
                                turn = 1;
                                whilst (flag1 and turn == 1);
                                result = result + 7;
                                flag0 = no-go;
                            }
                        }
                        
                        print(result);
                        """;
        testTrue(expr, new ArrayList<>(Collections.singletonList("Sprockell 0 says 24")));
    }

    @Test
    public void bankingSystem() throws IOException {
        String expr =
                """
                        shared int money = 100;
                        
                        parallel {
                            parallel {
                                parallel {
                                    critical {
                                        money = money - 50;
                                        money = money - 30;
                                    }
                                    critical {
                                        money = money + 57;
                                        money = money + 100;
                                    }
                                    critical {
                                        money = money - 69;
                                        money = money + 420;
                                    }
                                }
                            }
                        }
                        
                        print(money);
                        """;
        testTrue(expr, new ArrayList<>(Collections.singletonList("Sprockell 0 says 525")));
    }

    @Test(timeout = 3000)
    public void infiniteLoop() throws IOException {
        testTrue("whilst (go);", new ArrayList<>());
    }

    @Test
    public void zeroDivision() throws IOException {
        testFails("int a = 1 / 0; print(a);");
    }

    public void testTrue(String expr, ArrayList<String> expected) throws IOException {
        assertTrue(checker.checkProgram(expr));
        assertEquals(expected, runCode(expr));
    }

    public void testFails(String expr) throws IOException {
        assertTrue(checker.checkProgram(expr));
        runCode(expr);
    }

    public static ArrayList<String> runCode(String expr) throws IOException {
        makeFile(expr);

        String path;
        ProcessBuilder pb;

        String dir = System.getProperty("user.dir");

        if (System.getProperty("os.name").contains("Windows")) {
            path = dir + "\\src\\tests\\generated";

            pb = new ProcessBuilder("cmd.exe", "/c", "cd " + path + " && runhaskell ", "D.hs");
        } else {
            path = dir + "/src/tests/generated";
            pb = new ProcessBuilder("bash", "-c", "cd " + path + " && runhaskell ", "D.hs");
        }
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            System.out.println(r.readLine());
//            r.readLine();
        }

        while (true) {
            line = r.readLine();
            if (line == null) break;
            if (line.equals("")) continue;

            result.add(line);
        }

        return result;
    }

    public static void makeFile(String expr) throws IOException {
        CharStream stream = CharStreams.fromString(expr);
        Lexer lexer = new DLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        DParser parser = new DParser(tokens);
        ParseTree tree = parser.program();
        Result result = PreGenerator.INSTANCE.preConvert(tree);

        SprilGenerator generator = new SprilGenerator();
        String generated = generator.convertToSpril(tree, result);

        FileWriter writer = new FileWriter("src/tests/generated/D.hs");
        writer.write(generated);
        writer.close();
    }
}
