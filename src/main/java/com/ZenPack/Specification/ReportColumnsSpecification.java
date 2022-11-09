package com.ZenPack.Specification;

import com.ZenPack.Dto.SpecificationDto;
import com.ZenPack.model.ReportColumns;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ReportColumnsSpecification implements Specification<ReportColumns> {
    SpecificationDto criteria;
    private Root<ReportColumns> root;
    private CriteriaQuery<?> query;
    private CriteriaBuilder builder;

    public ReportColumnsSpecification(){
    }

    public ReportColumnsSpecification(final SpecificationDto specificationDto){
        super();
        this.criteria=specificationDto;
    }


    @Override
    public Predicate toPredicate(final Root<ReportColumns> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
//        this.root = root;
//        this.query = query;
//        this.builder = builder;
        switch (criteria.getOperation()) {
            case "EQUALS":
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            case "NOT_EQUAL":
                return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case "GREATER_THAN":
                return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case "LESS_THAN":
                return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case "LIKE":
                return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
            case "STARTS_WITH":
                return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            case "ENDS_WITH":
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
            case "CONTAINS":
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            case "N0T_CONTAINS":
                return builder.notLike(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            case "BLANKS":
                return builder.notEqual(root.get(criteria.getKey()),criteria.getValue());
            case "NOT_BLANKS":
                return builder.equal(root.get(criteria.getKey()),criteria.getValue());
            default:
                return null;
        }
    }
}
