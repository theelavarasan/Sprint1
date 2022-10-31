package com.ZenPack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ZenPack.model.ZenPack;

@Repository
public interface ZenPackRepository extends JpaRepository<ZenPack,Integer>, JpaSpecificationExecutor<ZenPack> {

    void deleteByZenPackId(Long zenPackId);

    Optional<ZenPack> findByZenPackId(Long zenPackId);
    
    Optional<ZenPack> findByName(String name);
}