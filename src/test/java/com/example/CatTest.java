package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest extends TestCase {
    @Mock
    Feline feline = new Feline();

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        assertEquals("Ожидается: "+expectedSound,expectedSound,  cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception  {
         Cat cat = new Cat(feline);
         List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
         Mockito.when(feline.eatMeat()).thenReturn(listFoodExpected);
         List<String> listFoodActual = cat.getFood();
         assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());

    }

}