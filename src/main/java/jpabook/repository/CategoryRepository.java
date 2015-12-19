package jpabook.repository;

import jpabook.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arahansa on 2015-12-19.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
