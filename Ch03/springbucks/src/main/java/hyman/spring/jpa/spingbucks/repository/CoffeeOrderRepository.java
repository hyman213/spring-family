package hyman.spring.jpa.spingbucks.repository;

import hyman.spring.jpa.spingbucks.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @描述：
 * @Author：huhan
 * @Date: 2019/3/7 21:57
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {

}
