package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void beforeAll() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensLionTest() {
        Mockito.when(feline.getKittens()).thenReturn(5);
        int expectedKittensLion = 5;
        int actualKittensLion = lion.getKittens();
        Assert.assertEquals(expectedKittensLion, actualKittensLion);
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Колбаса", "Тушенка"));
        List<String> expectedFoodLion = List.of("Мясо", "Колбаса", "Тушенка");
        List<String> actualFoodLion = lion.getFood();
        Assert.assertEquals(expectedFoodLion, actualFoodLion);
    }
}
