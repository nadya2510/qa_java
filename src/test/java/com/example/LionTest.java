package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest extends TestCase {
    @Mock
    Feline feline = new Feline();

    @Test
    public void testGetKittens() throws Exception{
        Lion  lion = new Lion("Самец", feline);
        int countKittens = lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFood() throws Exception{
        Lion  lion = new Lion("Самец", feline);
        List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(listFoodExpected);
        List<String> listFoodActual = lion.getFood();
        assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());
    }

    @Test
    public void testGetFamily() throws Exception{
        Lion  lion = new Lion("Самец", feline);
        String family = lion.getFamily();
        Mockito.verify(feline).getFamily();

    }


}