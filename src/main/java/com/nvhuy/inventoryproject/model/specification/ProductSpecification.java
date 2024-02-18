package com.nvhuy.inventoryproject.model.specification;

import com.nvhuy.inventoryproject.dto.ProductDto;
import com.nvhuy.inventoryproject.entity.Product;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProductSpecification {
    public static Specification<Product> searchProducts(ProductDto criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));
            }
            if (criteria.getDescription() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + criteria.getDescription().toLowerCase() + "%"));
            }
            if (criteria.getImageUrl() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("imageUrl")), "%" + criteria.getImageUrl().toLowerCase() + "%"));
            }
            if (criteria.getWarranty() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("warranty")), "%" + criteria.getWarranty().toLowerCase() + "%"));
            }
            if (criteria.getCategoryName() != null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("category").get("name")), criteria.getCategoryName().toLowerCase()));
            }
            if (criteria.getBrandName() != null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("brand").get("name")), criteria.getBrandName().toLowerCase()));
            }
            if (criteria.getSupplierName() != null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("supplier").get("name")), criteria.getSupplierName().toLowerCase()));
            }

            // Tìm kiếm theo kiểu int hoặc double
            if (criteria.getMinPriceImport() != null) {
                Expression<Double> priceImport = root.get("priceImport");
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(priceImport, criteria.getMinPriceImport()));
            }
            if (criteria.getMaxPriceImport() != null) {
                Expression<Double> priceImport = root.get("priceImport");
                predicates.add(criteriaBuilder.lessThanOrEqualTo(priceImport, criteria.getMaxPriceImport()));
            }
            if (criteria.getMinPriceSell() != null) {
                Expression<Double> priceSell = root.get("priceSell");
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(priceSell, criteria.getMinPriceSell()));
            }
            if (criteria.getMaxPriceSell() != null) {
                Expression<Double> priceSell = root.get("priceSell");
                predicates.add(criteriaBuilder.lessThanOrEqualTo(priceSell, criteria.getMaxPriceSell()));
            }
            if (criteria.getMinDiscount() != null) {
                Expression<Double> discount = root.get("discount");
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(discount, criteria.getMinDiscount()));
            }
            if (criteria.getMaxDiscount() != null) {
                Expression<Double> discount = root.get("discount");
                predicates.add(criteriaBuilder.lessThanOrEqualTo(discount, criteria.getMaxDiscount()));
            }
            if (criteria.getMinQuantity() != null) {
                Expression<Integer> quantity = root.get("quantity");
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(quantity, criteria.getMinQuantity()));
            }
            if (Objects.nonNull(criteria.getMaxQuantity())) {
                Expression<Integer> quantity = root.get("quantity");
                predicates.add(criteriaBuilder.lessThanOrEqualTo(quantity, criteria.getMaxQuantity()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
