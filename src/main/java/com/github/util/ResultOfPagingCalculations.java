package com.github.util;

import com.github.bo.CaseBo;

import java.util.List;

public final class ResultOfPagingCalculations {

    private List<CaseBo> listCases;

    private int countPage;

    public List<CaseBo> getListCases() {
        return listCases;
    }

    public void setListCases(List<CaseBo> listCases) {
        this.listCases = listCases;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }
}
