package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final boolean isMane;
    private final String sex;

    @Mock
    private Feline feline;

    public LionParamTest(String sex, boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }
    @Parameterized.Parameters(name = "Тест LionParamTest - {0}")
    public static Object[] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
            Lion lion = new Lion(sex, feline);
            Boolean expectedIsMane = isMane;
            Boolean actualIsMane = lion.doesHaveMane();
            Assert.assertEquals(expectedIsMane, actualIsMane);
    }
    @Test
    public void doesHaveManeTestException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Undefined", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
