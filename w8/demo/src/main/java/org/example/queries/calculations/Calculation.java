package org.example.queries.calculations;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.FunctionsParameters;

public interface Calculation<TItem> {
    void setFunctionParameters(FunctionsParameters functionParameters);
    boolean canCalculate();
    FunctionResult calculate(Results<TItem> results);

}
