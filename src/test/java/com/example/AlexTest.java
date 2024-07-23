package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest extends TestCase {
    @Mock
    Feline feline = new Feline();

    @Test
    public void testGetFriends() throws Exception {
        Alex  alex =  new Alex(feline);
        List<String> listFriendsExpected = List.of("Марти", "Глории", "Мелман");
        List<String> listFriendsActual = alex.getFriends();
        assertEquals("Ожидается:"+listFriendsExpected.toString(), listFriendsExpected.toString(), listFriendsActual.toString());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception{
        Alex  alex =  new Alex(feline);
        String expectedPlace = "Нью-Йоркский зоопарк";
        String placeOfLiving = alex.getPlaceOfLiving();
        assertEquals("Ожидается: "+expectedPlace, expectedPlace, placeOfLiving);
    }

    @Test
    public void testGetKittens() throws Exception {
        Alex  alex = Mockito.spy(new Alex(feline));
        int countKittens = alex.getKittens();
        Mockito.verify(alex, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception{
        Alex  alex =  new Alex(feline);
        List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(listFoodExpected);
        List<String> listFoodActual = alex.getFood();
        assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());
    }

    @Test
    public void testGetFamily() throws Exception{
        Alex  alex =  new Alex(feline);
        String family = alex.getFamily();
        Mockito.verify(feline).getFamily();
    }
}