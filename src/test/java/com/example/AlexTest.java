package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest extends TestCase {

    Feline feline = Mockito.spy(new Feline());
    Alex alex;

    {
        try {
            alex =  Mockito.spy(new Alex (feline));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetFriends() {
        List<String> listFriendsExpected = List.of("Марти", "Глории", "Мелман");
        List<String> listFriendsActual = alex.getFriends();
        Mockito.verify(alex, Mockito.times(1)).getFriends();
        assertEquals("Ожидается:"+listFriendsExpected.toString(), listFriendsExpected.toString(), listFriendsActual.toString());
    }

    @Test
    public void testGetPlaceOfLiving() {
        String placeOfLiving = alex.getPlaceOfLiving();
        Mockito.verify(alex, Mockito.times(1)).getPlaceOfLiving();
        assertEquals("Ожидается: Нью-Йоркский зоопарк", "Нью-Йоркский зоопарк", placeOfLiving);
    }

    @Test
    public void testGetKittens() {
        int countKittens = alex.getKittens();
        Mockito.verify(alex, Mockito.times(1)).getKittens();
        assertEquals("Ожидается: 0", 0, alex.getKittens());
    }

    @Test
    public void testGetFood() {
        try {
            List<String> listFoodExpected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(listFoodExpected);
            List<String> listFoodActual = alex.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
            assertEquals("Ожидается:"+listFoodExpected.toString(), listFoodExpected.toString(), listFoodActual.toString());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetFamily() {
        String family = alex.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Ожидается 'Кошачьи'","Кошачьи", family);
    }
}