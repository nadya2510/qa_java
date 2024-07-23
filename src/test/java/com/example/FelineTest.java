package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {
    @Spy
    Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception  {
        List<String> listFoodActual = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String expectedFamily =  "Кошачьи";
        assertEquals("Ожидается: "+expectedFamily,expectedFamily, feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        int expectedCount = 4;
        assertEquals("Ожидается: "+expectedCount, expectedCount, feline.getKittens(expectedCount));
    }

    @Test
    public void testGetKittens1() {
        int countKittens = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}