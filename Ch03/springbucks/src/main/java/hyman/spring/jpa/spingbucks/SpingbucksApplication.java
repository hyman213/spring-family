package hyman.spring.jpa.spingbucks;

import hyman.spring.jpa.spingbucks.model.Coffee;
import hyman.spring.jpa.spingbucks.model.CoffeeOrder;
import hyman.spring.jpa.spingbucks.model.OrderState;
import hyman.spring.jpa.spingbucks.repository.CoffeeRepository;
import hyman.spring.jpa.spingbucks.service.CoffeeOrderService;
import hyman.spring.jpa.spingbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SpingbucksApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;


    public static void main(String[] args) {
        SpringApplication.run(SpingbucksApplication.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        log.info("All Coffee: {}", coffeeRepository.findAll());

        Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
        if (latte.isPresent()) {
            CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
            log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
            log.info("Update INIT to INIT: {}", orderService.updateState(order, OrderState.INTI));

        }
    }

}
