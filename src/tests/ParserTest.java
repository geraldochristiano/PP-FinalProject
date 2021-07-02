package tests;

import org.junit.Test;
import type_checking.TypeAndDeclarationChecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParserTest {
    private final TypeAndDeclarationChecker checker = new TypeAndDeclarationChecker();

    @Test
    public void declarationTest() {
        //Declarations
        testTrue("int a;");
        testTrue("bool b;");
        testTrue("char c;");
        testTrue("shared int a;");
        testTrue("shared bool b;");
        testTrue("shared char c;");
    }

    @Test
    public void declarationInitiationTest() {
        //Declarations with initiations as separate lines
        testTrue("int a; a = 5;");
        testTrue("bool b; b = go;");
        testTrue("char c; c = 'c';");
        testTrue("shared int a; a = 0;");
        testTrue("shared bool b; b = no-go;");
        testTrue("shared char c; c = ' ';");
    }

    @Test
    public void initiationTest() {
        //Initiations
        testTrue("int a = 0;");
        testTrue("bool b = no-go;");
        testTrue("char c = 'f';");
        testTrue("shared int a = 420;");
        testTrue("shared bool b = go;");
        testTrue("shared char c = ' ';");
    }

    @Test
    public void arrayTest() {
        //Only the parsers for arrays work, the code gen does not work for arrays.
        testTrue("int[5] a;");
        testTrue("bool[6] b;");
        testTrue("char[3] c;");

        testTrue("int[3] a = [1,2,3];");
        testTrue("bool[3] b = [go, no-go, no-go];");
        testTrue("char[3] c = ['a', 'b', 'c'];");
    }

    @Test
    public void wheneverTest() {
        //If statement
        testTrue("int x; whenever (go) x = 5;");
        testTrue("int x; whenever (go) x = 5; elseways x = 7;");
        testTrue("int x = 5; whenever (x == 5) { x = 6; } ;");
        testTrue("int x = 5; whenever (x == 5) { x = 6; } elseways { x = 7 };");
    }

    @Test
    public void whilstTest() {
        //Whilst loop
        testTrue("whilst (go);");
        testTrue("whilst (no-go);");
        testTrue("bool x = go; whilst (x) x = no-go;");
        testTrue("whilst (go) {continue;};");
        testTrue("whilst (go) {break;};");
    }

    @Test
    public void loopTest() {
        testTrue("int x = 10; loop (int a = 5; | a < 10 | a++;) { x--;}");
        testTrue("int a; int x = 10; loop (a = 5; | a > 0 | a--;) x++;");
    }

    @Test
    public void parallelTest() {
        //Only parallel block
        testTrue("""
                shared int a = 5;
                parallel {
                    a = 2;
                }
                """);

        //Nested parallel blocks
        testTrue("""
                shared int a = 5;
                parallel {
                    parallel {
                        a = 2;
                    }
                }
                """);

        //Parallel block with critical block
        testTrue("""
                shared int a = 5;
                parallel {
                    critical {
                         a = 2;
                    }
                }
                """);
    }

    @Test
    public void wrongUsageTest() {
        System.out.println("\nAny errors between these lines are expected!");
        System.out.println("-----------------------------------------------------------------------------------------");
        //Unknown words
        testFalse("while (go);");
        testFalse("whilst (true);");
        testFalse("for (int a = 5; a < 10; a++;){}");

        //Arrays need an integer in between brackets indicating their size
        testFalse("int[] a;");
        testFalse("bool[] b;");
        testFalse("char[] c;");

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\n");
    }

    private void testTrue(String expr) {
        assertTrue(checker.checkProgram(expr));
    }

    private void testFalse(String expr) {
        assertFalse(checker.checkProgram(expr));
    }
}
