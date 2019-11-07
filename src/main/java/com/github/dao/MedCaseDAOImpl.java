package com.github.dao;

import com.github.model.MedCase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class MedCaseDAOImpl implements MedCaseDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, MedCase> medCasesList = new HashMap<>();

    static {
        MedCase medCase = new MedCase();
        medCase.setId(AUTO_ID.getAndIncrement());
        medCase.setStatus("open");
        medCase.setNumberOfCase("ABC1234567");
        medCasesList.put(medCase.getId(),medCase);
        MedCase medCase2 = new MedCase();
        medCase2.setId(AUTO_ID.getAndIncrement());
        medCase2.setStatus("close");
        medCase2.setNumberOfCase("CDE1234567");
        medCasesList.put(medCase2.getId(),medCase2);
    }

    @Override
    public List<MedCase> allMedCases() {
        return new ArrayList<>(medCasesList.values());
    }

    @Override
    public void add(MedCase medCase) {
        medCase.setId(AUTO_ID.getAndIncrement());
        medCasesList.put(medCase.getId(), medCase);
    }

    @Override
    public void delete(MedCase medCase) {
        medCasesList.remove(medCase.getId());
    }

    @Override
    public void edit(MedCase medCase) {
        medCasesList.put(medCase.getId(), medCase);
    }

    @Override
    public MedCase getById(int id) {
        return medCasesList.get(id);
    }
}
