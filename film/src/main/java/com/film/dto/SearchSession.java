package com.film.dto;

public class SearchSession {
    private String searchValName;
    private String searchValDirector;
    private String searchValCategory;

    public SearchSession() {
    }

    public SearchSession(String searchValName, String searchValDirector, String searchValCategory) {
        this.searchValName = searchValName;
        this.searchValDirector = searchValDirector;
        this.searchValCategory = searchValCategory;
    }

    public String getSearchValName() {
        return searchValName;
    }

    public void setSearchValName(String searchValName) {
        this.searchValName = searchValName;
    }

    public String getSearchValDirector() {
        return searchValDirector;
    }

    public void setSearchValDirector(String searchValDirector) {
        this.searchValDirector = searchValDirector;
    }

    public String getSearchValCategory() {
        return searchValCategory;
    }

    public void setSearchValCategory(String searchValCategory) {
        this.searchValCategory = searchValCategory;
    }
}
