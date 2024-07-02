package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest extends TestCase {

    Feline feline = Mockito.spy(new Feline());
    Lion lion;
    {
        try {
            lion = new Lion("Самец", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetKittens() {
        int countKittens = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals("Ожидается: 1", 1, countKittens);
    }

    @Test
    public void testGetFood() {
        try {
            List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(listFoodExpected);
            List<String> listFoodActual = lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
            assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetFamily() {
        String family = lion.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Ожидается 'Кошачьи'","Кошачьи", family);
    }


}