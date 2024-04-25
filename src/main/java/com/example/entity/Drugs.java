package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`drugs`")
public class Drugs {

    private int id;//药品id
    private String drugname;//药品名称
    private double price;//价格
    private String dosage;//计量
    private String date;//生产日期
    private String manufacturer;//公司

}
