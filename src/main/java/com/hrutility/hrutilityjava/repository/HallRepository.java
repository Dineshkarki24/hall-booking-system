package com.hrutility.hrutilityjava.repository;

import com.hrutility.hrutilityjava.entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<HallEntity,Long> {
//    List<HallEntity> findAllHallList();
//
//    List<HallEntity> findListById(Long hallId);
}
