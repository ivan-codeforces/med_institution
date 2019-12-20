package com.github.service;

import com.github.bo.CaseBo;
import com.github.util.ResultOfPagingCalculations;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CasePagingService {
    private CaseService caseService;
    private static final Logger LOGGER = Logger.getLogger(CasePagingService.class);

    @Autowired
    public CasePagingService(CaseService caseService) {
        this.caseService = caseService;
    }

    public ResultOfPagingCalculations findPage(Integer page) {
        LOGGER.info("findPage - entryPoint");
        List<CaseBo> medCases = caseService.listCases();

        PagedListHolder<CaseBo> pagedListHolder = new PagedListHolder<CaseBo>(medCases);
        pagedListHolder.setPageSize(10);
//        LOGGER.info("findPage - entryPoint");
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            page = 1;
        }

        ResultOfPagingCalculations result = new ResultOfPagingCalculations();

        if (page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            result.setListCases(pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            result.setListCases(pagedListHolder.getPageList());
        }

            result.setCountPage(medCases.size() / 10 + 1);

        return result;
    }

}
