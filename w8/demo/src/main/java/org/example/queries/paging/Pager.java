package org.example.queries.paging;

import org.example.queries.QueryResultsProcessor;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.parameters.ISearchParams;

import java.util.stream.Collectors;

public class Pager<TItem, TParams extends ISearchParams> implements QueryResultsProcessor<TItem, TParams>, Paging {

    SearchParameters<TParams> parameters;

    @Override
    public void setParameters(SearchParameters<TParams> parameters) {
        this.parameters= parameters;
    }

    @Override
    public void process(Results<TItem> results) {
        int skip = (parameters.getPage().getPageNumber()-1)*parameters.getPage().getSize();
        int take = parameters.getPage().getSize();
        int pages = results.getItems().size()/take;
        if(results.getItems().size()%take!=0)pages++;
        results.setItems(results.getItems().stream().skip(skip).limit(take).collect(Collectors.toList()));
        results.setCurrentPage(parameters.getPage().getPageNumber());
        results.setPages(pages);
    }
}
