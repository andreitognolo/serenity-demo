package org.codereuse.serenity.demo.imdb;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.codereuse.serenity.demo.imdb.steps.UserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Theo on 29/03/15.
 */
@RunWith(SerenityRunner.class)
public class SmokeTests {

    @Managed
    WebDriver driver;

    @Steps
    UserSteps user;

    @Test
    public void shouldBeAbleToSearchForMovie() {
        user.opens_imdb_home_page();
        user.searches_for_movie("Titanic");
        user.search_header_should_contain("Titanic");
        user.should_see_number_of_titles_displayed(10);
        user.should_see_in_search_results("Titanic (1997)");
    }
}
