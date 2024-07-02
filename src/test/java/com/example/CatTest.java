package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTest extends TestCase {

    Feline  feline = Mockito.spy(new Feline());
    Cat cat = new Cat(feline);

    @Test
    public void testGetSound() {
        Feline  feline1 = new Feline();
        Cat cat1 = new Cat(feline1);
        assertEquals("Ожидается 'Мяу'","Мяу", cat1.getSound());
    }

    @Test
    public void testGetFood() {
        try {
            List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(listFoodExpected);
            List<String> listFoodActual = cat.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
            assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testGetFamily() {
        String family = cat.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Ожидается 'Кошачьи'","Кошачьи", family);
    }
}