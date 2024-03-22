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
            // Đảm bảo rằng categoryName không phải là null và không phải là một danh sách rỗng
            if (criteria.getCategoryName() != null && !criteria.getCategoryName().isEmpty()) {
                // Tạo một mảng để lưu trữ các điều kiện cho mỗi categoryName trong danh sách
                List<Predicate> categoryNamePredicates = new ArrayList<>();

                // Lặp qua từng categoryName trong danh sách
                for (String categoryName : criteria.getCategoryName()) {
                    // Tạo một điều kiện cho mỗi categoryName
                    Predicate categoryNamePredicate = criteriaBuilder.equal(criteriaBuilder.lower(root.get("category").get("name")), categoryName.toLowerCase());
                    // Thêm điều kiện vào danh sách
                    categoryNamePredicates.add(categoryNamePredicate);
                }

                // Tạo một điều kiện tổng hợp bằng cách kết hợp tất cả các điều kiện cho từng categoryName bằng OR
                Predicate categoryNameCombinedPredicate = criteriaBuilder.or(categoryNamePredicates.toArray(new Predicate[0]));

                // Thêm điều kiện tổng hợp vào danh sách điều kiện chính
                predicates.add(categoryNameCombinedPredicate);
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

            // Create & Update
            if (criteria.getCreatedBy() != null) {
                predicates.add(criteriaBuilder.equal(root.get("createdBy"), criteria.getCreatedBy()));
            }

            if (criteria.getCreatedDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("createdDate"), criteria.getCreatedDate()));
            }

            if (criteria.getUpdateBy() != null) {
                predicates.add(criteriaBuilder.equal(root.get("updateBy"), criteria.getUpdateBy()));
            }

            if (criteria.getUpdateDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("updateDate"), criteria.getUpdateDate()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
