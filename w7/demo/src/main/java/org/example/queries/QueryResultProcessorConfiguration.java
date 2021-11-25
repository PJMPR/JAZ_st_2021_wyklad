package org.example.queries;

import org.example.queries.calculations.Calculate;
import org.example.queries.calculations.Calculation;
import org.example.queries.calculations.Calculator;
import org.example.queries.criterias.Criteria;
import org.example.queries.criterias.SimpleCriteria;
import org.example.queries.paging.Pager;
import org.example.queries.paging.Paging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QueryResultProcessorConfiguration {

    /*
    @Bean
    public Criteria AgeFromCriteria(){
        return new SimpleCriteria(x->x.getAgeFrom()>0, (x,y)->x.getAge()>y.getAgeFrom());
    }
    @Bean
    public Criteria AgeToCriteria(){
        return new SimpleCriteria(x->x.getAgeTo()>0, (x,y)->x.getAge()<y.getAgeTo());
    }
*/
    @Bean
    public List<Criteria> criteriaList(){
        return List.of(
                new SimpleCriteria(x->x.getAgeFrom()>0, (x,y)->x.getAge()>y.getAgeFrom()),
                new SimpleCriteria(x->x.getAgeTo()>0, (x,y)->x.getAge()<y.getAgeTo())
        );
    }


    @Bean
    public Paging Pager(){
        return new Pager();
    }
/*
    @Bean
    public Calculate Calculator(List<Calculation> calculations){
        return new Calculator(calculations);
    }
*/
}
