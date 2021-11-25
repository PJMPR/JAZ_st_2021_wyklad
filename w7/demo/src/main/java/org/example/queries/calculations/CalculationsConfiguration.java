package org.example.queries.calculations;

import org.example.queries.search.Funcs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CalculationsConfiguration {

    @Bean
    public List<Calculation> calculations(){
        return List.of(
                new FieldCalculation(Collectors.averagingDouble(Number::doubleValue), Funcs.AVARAGE),
                new FieldCalculation(Collectors.summingDouble(Number::doubleValue), Funcs.SUM)
        );
    }
}
