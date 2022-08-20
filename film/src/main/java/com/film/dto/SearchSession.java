package com.film.dto;

public class SearchSession {
    private String searchValTitle;
//    private String searchValDirector;
    private String searchValCategory;

    public SearchSession() {
    }

    public SearchSession(String searchValTitle, String searchValCategory) {
        this.searchValTitle = searchValTitle;
        this.searchValCategory = searchValCategory;
    }

    public String getSearchValTitle() {
        return searchValTitle;
    }

    public void setSearchValTitle(String searchValTitle) {
        this.searchValTitle = searchValTitle;
    }

    public String getSearchValCategory() {
        return searchValCategory;
    }

    public void setSearchValCategory(String searchValCategory) {
        this.searchValCategory = searchValCategory;
    }
}
