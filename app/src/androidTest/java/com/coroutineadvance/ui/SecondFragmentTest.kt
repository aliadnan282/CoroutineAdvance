package com.coroutineadvance.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.coroutineadvance.R
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


@RunWith(AndroidJUnit4::class)
class SecondFragmentTest {
    private lateinit var context:Context
    @Mock
    private lateinit var mockNavController: NavController
    @Before
    fun provideContext(){
        context= InstrumentationRegistry.getInstrumentation().targetContext;
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun testEventFragment() {
        val fragmentArgs = Bundle().apply {
            putInt("selectedListItem", 0)
        }

        val navController= TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.setGraph(R.navigation.nav_graph)

       val second= launchFragmentInContainer<SecondFragment>()
        second.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.button_second))
            .perform(click())

        Truth.assertThat(navController.currentDestination?.id).isEqualTo(R.id.FirstFragment)
    }

    @Test
    fun navigateFragment(){
        val navController= TestNavHostController(ApplicationProvider.getApplicationContext())

        val scenario = launchFragmentInContainer {
            SecondFragment().also { fragment ->

                // In addition to returning a new instance of our Fragment,
                // get a callback whenever the fragment’s view is created
                // or destroyed so that we can set the NavController
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        // The fragment’s view has just been created
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }

        onView(withId(R.id.button_second))
            .perform(click())

        Truth.assertThat(navController.currentDestination?.id).isEqualTo(R.id.FirstFragment)
    }

    @Test
    fun testNavigationToInGameScreen() {
        // Create a TestNavHostController
     //   val mockNavController: NavController = mock(NavController::class.java)
       /* val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        navController.setGraph(R.navigation.nav_graph)
*/
        // Create a graphical FragmentScenario for the TitleScreen
        val titleScenario = launchFragmentInContainer<SecondFragment>()

        // Set the NavController property on the fragment
        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), mockNavController)
        }

        // Verify that performing a click changes the NavController’s state
        onView(ViewMatchers.withId(R.id.button_second)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
}