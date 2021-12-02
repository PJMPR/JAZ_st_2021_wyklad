package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.parameters.ISearchParams;

@FunctionalInterface
public interface CriteriaPredicate<TItem, TParams extends ISearchParams> {
    boolean check(TItem p, SearchParameters<TParams> params);
}
