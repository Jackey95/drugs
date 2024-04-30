package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Drugs;
import com.example.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpI implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drugs> findAllDrugs(){ return drugMapper.selectList(null);}

    @Override
    public Drugs findDrugById(int id){ return drugMapper.selectById(id);}

    @Override
    public Drugs addDrug(Drugs drug){ drugMapper.insert(drug);
        return drug;
    }

    @Override
    public void updateDrug(Drugs drug){ drugMapper.updateById(drug);}

    @Override
    public void deleteDrug(int id) { drugMapper.deleteById(id);}

    @Override
    public IPage<Drugs> getPage(int pageNum, int size){
        IPage<Drugs> drugPage = new Page<>(pageNum, size);//参数一是当前页，参数二是每页个数
        drugPage = drugMapper.selectPage(drugPage, null);
        return drugPage;
    }

    @Override
    public List<Drugs> searchDrugs(Drugs drug){
//       QueryWrapper<Drugs> queryWrapper=new QueryWrapper<>();
//       queryWrapper.like(drug.getDrugname()!=""&&drug.getDrugname()!=null,"Drugname",drug.getDrugname());
//       queryWrapper.eq(drug.getCategory()!=""&&book.getCategory()!=null,"category",book.getCategory());
//       queryWrapper.eq(book.getAuthor()!=""&&book.getAuthor()!=null,"author",book.getAuthor());
//       return bookMapper.selectList(queryWrapper);
        LambdaQueryWrapper<Drugs> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(drug.getDrugname()!=""&&drug.getDrugname()!=null,Drugs::getDrugname,drug.getDrugname());
        queryWrapper.eq(drug.getDosage()!=""&&drug.getDosage()!=null,Drugs::getDosage,drug.getDosage());
        queryWrapper.eq(drug.getManufacturer()!=""&&drug.getManufacturer()!=null,Drugs::getManufacturer,drug.getManufacturer());
        return drugMapper.selectList(queryWrapper);
    }
}
