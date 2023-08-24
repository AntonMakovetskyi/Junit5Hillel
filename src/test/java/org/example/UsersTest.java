package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Collections;
import java.util.stream.IntStream;

public class UsersTest {
    static UserManager userManager;

    @BeforeAll
    public static void initUsers() {
        userManager = new UserManager();
        userManager.users.add(new User("Anton", 67));
        userManager.users.add(new User("Artem", 75));
        userManager.users.add(new User("Olga", 25));
        userManager.users.add(new User("Felix", 89));
    }

    @BeforeEach
    public void printSomething() {
        System.out.println("My test");
    }

    @Test
    @Disabled("It is not implemented yet")
    @Tag("DEV")
    public void testOldestUser() {
        Assertions.assertEquals(userManager.getNameOldestUser(), "Felix");
    }

    @Test
    @DisplayName("Youngest User")
    @Tag("PROD")
    public void testYoungestUser(TestInfo testInfo) {
        System.out.println(testInfo.getTags().toString());
        Assumptions.assumeFalse(true);
        Assertions.assertNotEquals(userManager.getNameOldestUser(), "Felix");
        Assertions.assertAll("Massive test", () -> Assertions.assertTrue(true),
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertTrue(true));

//        Assertions.assertThrows(RuntimeException.class, userManager.getNameOldestUser())
    }

    @RepeatedTest(value = 15, name = "Anton verification")
    public void verifyMyName(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        String myName = "Anton";
        Assertions.assertTrue(myName.startsWith("A"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "Anton", ""})
    public void stringTest(String value) throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertTrue(!value.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void emptyStringTest(String value) throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertTrue(value.isEmpty());
    }




    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    void testWithMethodSource(int argument) throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertNotEquals(9, argument);
    }

    static IntStream argsProviderFactory() {
        return IntStream.range(0, 10);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "alex, 30, dog",
            "brian, 35, cat",
            "charles, 40, cat"
    })
    void testWithCsvSource(String name, int age, String pet) {
        Assertions.assertNotNull(name);
        Assertions.assertTrue(age > 0);
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "C:/Users/38095/IdeaProjects/Junit5Hillel/src/test/testData.csv")
//    void testWithCsvFileSource(String name, int age, String pet) {
//        Assertions.assertNotNull(name);
//        Assertions.assertTrue(age > 0);
//    }


}
