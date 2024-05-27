package postfix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PostfixTestCasesTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testPostfixConversionAndEvaluation(String message, String infix, String expectedPostfix, double expectedResult) {
        Infix infixConverter = new Infix();
        Postfix postfixEvaluator = new Postfix();

        try {
            String postfix = infixConverter.toPostfix(infix);
            double result = postfixEvaluator.evaluate(postfix);

            assertEquals(expectedPostfix, postfix);
            assertEquals(expectedResult, result);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }

    public static Stream<Arguments> testCases() {
        return TestCases.allTestCases().map(args -> arguments(args));
    }
}
