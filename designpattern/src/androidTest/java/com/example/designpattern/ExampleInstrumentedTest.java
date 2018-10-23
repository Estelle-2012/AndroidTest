package com.example.designpattern;

import android.content.Context;


import com.example.designpattern.startegypattern.I_Startegy;
import com.example.designpattern.startegypattern.Method;
import com.example.designpattern.startegypattern.Stattegy1;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.designpattern", appContext.getPackageName());
    }

    @Test
    public void testStarttege() {
        I_Startegy i_startegy = new Stattegy1();
        Method method = new Method(i_startegy);
        method.action();
    }
}
