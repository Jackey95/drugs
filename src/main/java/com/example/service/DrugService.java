package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.Drugs;

import java.util.List;

public interface DrugService  {
    public List<Drugs> findAllDrugs();

    public Drugs findDrugById(int id);

    public Drugs addDrug(Drugs drug);

    public void updateDrug(Drugs drug);

    public void deleteDrug(int id);

    public IPage<Drugs> getPage(int pageNum, int size);

    List<Drugs> searchDrugs(Drugs drug);
}
