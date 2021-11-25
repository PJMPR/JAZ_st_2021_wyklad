package org.example.queries.calculations;

import org.example.queries.QueryResultsProcessor;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.SearchParameters;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Calculator implements QueryResultsProcessor, Calculate {

    SearchParameters searchParameters;
    List<Calculation> calculations;

    public Calculator(List<Calculation> calculations) {
        this.calculations = calculations;
    }

    @Override
    public void setParameters(SearchParameters parameters) {
        this.searchParameters=parameters;
    }

    @Override
    public void process(Results results) {
        results.setFunctionResults(
                searchParameters.getFunctions()
                        .stream()
                        .map(x->{
                            calculations.forEach(c->c.setFunctionParameters(x));
                            Calculation calculation = calculations
                                    .stream()
                                    .filter(c->c.canCalculate())
                                    .findFirst()
                                    .orElse(null);
                            if(calculation==null)return null;
                            return calculation.calculate(results);
                        })
                        .filter(x->x!=null)
                        .collect(Collectors.toList())
        );

    }
}
