package com.ankit.domain;

/**
 * Created by ankit07 on 9/2/16.
 */
public class Income {

    private Long id;
    private String year;
    private String month;
    private Integer income;
    private String source; // source of income

    public Income(Long id,String year,String month,Integer income,String source){
        this.id = id;
        this.year = year;
        this.month = month;
        this.income = income;
        this.source = source;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
