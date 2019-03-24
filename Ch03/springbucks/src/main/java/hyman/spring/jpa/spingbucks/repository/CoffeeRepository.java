package hyman.spring.jpa.spingbucks.repository;

import hyman.spring.jpa.spingbucks.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: huhan
 * @date: 2019/3/7 21:55
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
