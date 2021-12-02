package org.example.queries;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.parameters.ISearchParams;

public interface QueryResultsProcessor<TItem, TParams extends ISearchParams> {
    void setParameters(SearchParameters<TParams> parameters);
    void process(Results<TItem> results);
}
