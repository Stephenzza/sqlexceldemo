package com.sqlexcel.sqlexceldemo.repository;

import com.sqlexcel.sqlexceldemo.entity.Gas;
import com.sqlexcel.sqlexceldemo.entity.GasContam;
import com.sqlexcel.sqlexceldemo.entity.GasJoinContam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GasRepository extends JpaRepository<Gas,Integer> {

    public List<Gas> findByPname(String pname);

    @Query(value="select gas.stcode,gas.subid,gas.tempid from Gas gas where gas.subid=:subid")
    List<Gas> findBySubid(@Param("subid") Integer subid);

    //@Query(value="select a.subid,a.pname,b.datetime from Gas a left join GasContam b on a.subid = b.subid")
    //List<Map<String,>> selectDateAndSubid();
    @Query(value="select t1.subid,t1.pname,t2.datetime from feiqi as t1 left join feiqi_paiwu as t2 on t1.subid = t2.subid where t2.datetime is not null",nativeQuery =true)
    List<List> selectGas();

    @Query(value="select feiqi.subid,feiqi.pname,feiqi_paiwu.datetime from feiqi left join feiqi_paiwu on feiqi.subid = feiqi_paiwu.subid",nativeQuery =true)
    List<List> selectWater();

    @Query(value="select feiqi.subid,feiqi.pname,feiqi_paiwu.datetime from feiqi left join feiqi_paiwu on feiqi.subid = feiqi_paiwu.subid",nativeQuery =true)
    List<List> selectSewagePlant();
}