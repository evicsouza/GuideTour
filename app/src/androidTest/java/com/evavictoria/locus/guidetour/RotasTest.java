package com.evavictoria.locus.guidetour;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RotasTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verificaInicio() {
        onView(withText("Inicio"));
    }
    @Test
    public void verificaFav() {
        onView(withText("Favoritos"));
    }

    @Test
    public void verificaBotaoRotas(){

    }

}
