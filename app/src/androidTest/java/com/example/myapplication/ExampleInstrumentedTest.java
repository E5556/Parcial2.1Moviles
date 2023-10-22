package com.example.myapplication;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void testGetProduct() {
        // Arrange
        double veces = 2.0;
        double multiplicador = 3.0;
        double expected = 6.0;

        // Act
        double result = MainActivity.getProduct(veces, multiplicador);

        // Assert

        assertEquals(expected, result, 0.001); // Se utiliza delta para manejar errores de punto flotante
    }

    @Test
    public void testGetProductWhitIva() {
        // Arrange

        double multiplicador  = 2.0;
        double veces = MainActivity.getIVA();
        double expected = 0.38;

        // Act
        double result = MainActivity.getProduct(veces, multiplicador);

        // Assert
        assertEquals(expected, result, 0.001); // Se utiliza delta para manejar errores de punto flotante
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myapplication", appContext.getPackageName());
    }

    /**
     * Example local unit test, which will execute on the development machine (host).
     *
     * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
     */
    public static class ExampleUnitTest {
        @Test
        public void addition_isCorrect() {



            assertEquals(4, 2 + 2);
        }
    }
}