package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionExceptionTest {
    @Mock
    private Feline feline;
    @Test
    public void doesHaveManeTestException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Undefined", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
