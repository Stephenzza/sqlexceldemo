package com.sqlexcel.sqlexceldemo.repository;

import com.sqlexcel.sqlexceldemo.entity.Gas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GasRepository extends JpaRepository<Gas,Integer> {

    public List<Gas> findByPname(String pname);

    @Query(value="from Gas gas where gas.subid=?203")
    Optional<Gas> findBySubid(Integer subid);
}