package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.QueryResultsProcessor;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.parameters.ISearchParams;

import java.util.stream.Collectors;

public abstract  class CriteriaBase<TItem, TParams extends ISearchParams> implements QueryResultsProcessor<TItem, TParams>, Criteria {

    SearchParameters<TParams> parameters;
    public void setParameters(SearchParameters<TParams> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void process(Results<TItem> results) {
        if(canFilter())
        results.setItems(results
                .getItems()
                .stream()
                .filter(this::check)
                .collect(Collectors.toList()));
    }

    protected abstract boolean canFilter() ;
    protected abstract boolean check(TItem person);
}
