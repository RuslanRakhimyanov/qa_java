package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatPredatorTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Колбаса", "Тушенка"));
        List<String> expectedFoodPredator = List.of("Мясо", "Колбаса", "Тушенка");
        List<String> actualFoodPredator = feline.eatMeat();
        Assert.assertEquals(expectedFoodPredator, actualFoodPredator);
    }

    @Test
    public void getKittensNoParamTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int expectedKittensNoParam = 1;
        int actualKittensNoParam = feline.getKittens();
        Assert.assertEquals(expectedKittensNoParam, actualKittensNoParam);
    }

    @Test
    public void getKittensWithParamTest() {
        int expectedKittensWithParam = 5;
        int actualKittensWithParam = feline.getKittens(5);
        Assert.assertEquals(expectedKittensWithParam, actualKittensWithParam);
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }
}
