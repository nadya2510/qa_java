package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

@RunWith(Parameterized.class)
public class LionManeTest extends TestCase {
    private String sexLion;
    private boolean hasMane;

    public LionManeTest(String sexLion, boolean hasMane) {
        this.sexLion = sexLion;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionTest() {
        //Тестовые данные
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Оно", false}
        };
    }


    @Test
    public void testDoesHaveMane() {
        Feline feline =new Feline();
        Lion lion;
        {
            try {
                lion =  new Lion(sexLion, feline);
                Assert.assertEquals(hasMane, lion.doesHaveMane());
            } catch (Exception e) {
               Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка",e.getMessage());
            }
        }

    }

}
