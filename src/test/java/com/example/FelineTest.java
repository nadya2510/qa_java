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
    public void testEatMeat() {
        try {
            List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(listFoodExpected);
            List<String> listFoodActual = feline.eatMeat();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
            assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Ожидается 'Кошачьи'","Кошачьи", family);
    }

    @Test
    public void testGetKittens() {
        int countKittens = feline.getKittens(4);
        Mockito.verify(feline, Mockito.times(1)).getKittens(4);
        assertEquals("Ожидается: 4", 4,countKittens);
    }

    @Test
    public void testGetKittens1() {
        int countKittens = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals("Ожидается: 1", 1, countKittens);
    }
}