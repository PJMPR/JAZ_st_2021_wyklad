package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.parameters.ISearchParams;

import java.util.function.Predicate;

public class SimpleCriteria<TItem,TParams extends ISearchParams> extends CriteriaBase<TItem,TParams>{

    Predicate<SearchParameters<TParams>> checkParams;
    CriteriaPredicate<TItem,TParams> checkPerson;

    public SimpleCriteria(Predicate<SearchParameters<TParams>> checkParams, CriteriaPredicate<TItem,TParams> checkPerson){
        this.checkParams=checkParams;
        this.checkPerson = checkPerson;
    }

    @Override
    protected boolean canFilter() {
        return checkParams.test(parameters);
    }

    @Override
    protected boolean check(TItem person) {
        return checkPerson.check(person, parameters);
    }
}
