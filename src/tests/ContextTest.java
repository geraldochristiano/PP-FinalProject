package tests;

import org.junit.Test;
import type_checking.TypeAndDeclarationChecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContextTest {
    private final TypeAndDeclarationChecker checker = new TypeAndDeclarationChecker();

    @Test
    public void declaredTest() {
        //Non-shared variables
        testTrue("int a; a = 5;");
        testTrue("bool b; b = go;");
        testTrue("char c; c = '5';");
        testTrue("int a = 5;");
        testTrue("bool b = go;");
        testTrue("char c = '5';");

        //Shared variables
        testTrue("shared int a; a = 5;");
        testTrue("shared bool b; b = go;");
        testTrue("shared char c; c = '5';");
        testTrue("shared int a = 5;");
        testTrue("shared bool b = go;");
        testTrue("shared char c = '5';");

        System.out.println("\n#### expected errors: ####");
        //Initializing non-declared variables
        testFalse("a = 5;");
        testFalse("b = go;");
        testFalse("c = 'c'");

        //Wrong type
        testFalse("int a; a = 'a';");
        testFalse("bool b; b = 2;");
        testFalse("char c; c = no-go;");
        System.out.println("#### expected errors end ####\n");
    }

    @Test
    public void blockTest() {
        //Using same name in other block is allowed
        testTrue("int a = 5; { bool a = go; }");
        testTrue("int a = 5; { a = 10; }");

        System.out.println("\n#### expected errors: ####");
        //Assigning value outside of block where variable has been declared
        testFalse("{ int a; } a = 5;");
        //Critical can only be inside of a parallel block
        testFalse("critical {}");
        //Critical blocks can't be nested
        testFalse("parallel { critical { critical {} } }");
        System.out.println("#### expected errors end ####\n");
    }

    @Test
    public void conditionTest() {
        //If statement
        testTrue("whenever (go);");
        testTrue("whenever (10 == 5);");
        testTrue("bool b = no-go; whenever (b);");

        System.out.println("\n#### expected errors: ####");
        testFalse("bool b; whenever (b);");
        testFalse("whenever (10);");
        testFalse("whenever ('c')");
        testFalse("int a = 5; whenever (a);");
        testFalse("char c = 'c'; whenever (c);");
        System.out.println("#### expected errors end ####\n");

        //While loop
        testTrue("whilst (go);");
        testTrue("whilst (10 == 5);");
        testTrue("bool b = no-go; whilst (b);");

        System.out.println("\n#### expected errors: ####");
        testFalse("whilst (10);");
        testFalse("whilst ('c')");
        testFalse("int a = 5; whilst (a);");
        testFalse("char c = 'c'; whilst (c);");
        System.out.println("#### expected errors end ####\n");

        //For loop
        testTrue("loop (int a = 5; | a < 10 | a++;);");
        testTrue("int a; loop (a = 5; | a < 10 | a++;);");

        System.out.println("\n#### expected errors: ####");
        testFalse("loop (int a = 5; | a = 6 | a--;);");
        testFalse("int a = 6; loop (a < 10; | a < 10 | a++;);");
        System.out.println("#### expected errors end ####\n");
    }

    private void testTrue(String expr) {
        assertTrue(checker.checkProgram(expr));
    }

    private void testFalse(String expr) {
        assertFalse(checker.checkProgram(expr));
    }
}
