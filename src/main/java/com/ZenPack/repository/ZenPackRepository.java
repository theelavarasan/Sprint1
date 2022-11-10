package com.ZenPack.repository;

import java.util.Optional;

import com.ZenPack.Specification.SearchSpecification;
import com.ZenPack.Specification.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ZenPack.model.ZenPack;

@Repository
public interface ZenPackRepository extends JpaRepository<ZenPack,Long>, JpaSpecificationExecutor<ZenPack> {

    void deleteByZenPackId(Long zenPackId);

    Optional<ZenPack> findByZenPackId(Long zenPackId);
    
    Optional<ZenPack> findByName(String name);

//    Page<ZenPack> findAll(SortDirection asc, SearchSpecification<ZenPack> specification, Pageable pageable);
}