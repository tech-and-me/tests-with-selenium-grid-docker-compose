package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
//        searchPage.doSearch("012345890");
        searchPage.doSearch(keyword);

        searchPage.goToVideo();
        int actualSize = searchPage.getResult();
        Assert.assertTrue(actualSize > 0);
    }


}
