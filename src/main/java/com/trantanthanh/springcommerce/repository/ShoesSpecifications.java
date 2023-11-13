package com.trantanthanh.springcommerce.repository;
import com.trantanthanh.springcommerce.model.Shoes;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;

public class ShoesSpecifications {

    public static Specification<Shoes> priceBetweenAndBrandIdAndColorId(
            double minPrice, double maxPrice, List<Long> brandIds, List<Long> colorIds) {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true); // Đảm bảo kết quả là duy nhất

            // Lọc theo giá từ a đến b
            Specification<Shoes> priceBetween = (rootPrice, queryPrice, criteriaBuilderPrice) ->
                    criteriaBuilderPrice.between(rootPrice.get("price"), minPrice, maxPrice);

            // Lọc theo brand_id
            Specification<Shoes> brandIdIn = createBrandIdInSpecification(brandIds);

            // Lọc theo color_id
            Specification<Shoes> colorIdIn = createColorIdInSpecification(colorIds);

            // Kết hợp các điều kiện với AND
            return criteriaBuilder.and(priceBetween.toPredicate(root, query, criteriaBuilder),
                    brandIdIn.toPredicate(root, query, criteriaBuilder),
                    colorIdIn.toPredicate(root, query, criteriaBuilder));
        };
    }

    // Nếu mảng rỗng thì bỏ qua, đánh dấu điều kiện luôn đúng
    private static Specification<Shoes> createBrandIdInSpecification(List<Long> brandIds) {
        return (root, query, criteriaBuilder) -> {
            if (brandIds != null && !brandIds.isEmpty()) {
                return root.get("brand").get("id").in(brandIds);
            }
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }

    // Nếu mảng rỗng thì bỏ qua, đánh dấu điều kiện luôn đúng
    private static Specification<Shoes> createColorIdInSpecification(List<Long> colorIds) {
        return (root, query, criteriaBuilder) -> {
            if (colorIds != null && !colorIds.isEmpty()) {
                query.distinct(true); // Đảm bảo kết quả là duy nhất
                return root.join("shoesColorList").join("color").get("id").in(colorIds);
            }
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        };
    }
}
