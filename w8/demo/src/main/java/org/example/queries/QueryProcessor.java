package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.calculations.Calculate;
import org.example.queries.calculations.Calculator;
import org.example.queries.criterias.Criteria;
import org.example.queries.criterias.SimpleCriteria;
import org.example.queries.paging.Pager;
import org.example.queries.paging.Paging;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.parameters.ISearchParams;
import org.example.queries.search.parameters.PersonParams;

import java.util.List;

public class QueryProcessor<TItem, TParams extends ISearchParams> {

    /*
    List<QueryResultsProcessor<Person, PersonParams>> queryResultsProcessors = List.of(
            new SimpleCriteria<Person, PersonParams>(p->p.getParameters().getAgeFrom()>0,
                    (person, params)->person.getAge()>params.getParameters().getAgeFrom()),
            new Pager<Person, PersonParams>(),
            new Calculator<Person, PersonParams>()
    );
*/
    List<QueryResultsProcessor<TItem, TParams>> queryResultsProcessors;

    public QueryProcessor(List<QueryResultsProcessor<TItem, TParams>> queryResultsProcessors) {
        this.queryResultsProcessors = queryResultsProcessors;
    }

    public Results<TItem> GetResults(SearchParameters<TParams> parameters, List<TItem> items){
        var result = new Results<TItem>();
        result.setItems(items);
        queryResultsProcessors.stream().filter(x-> x instanceof Criteria).forEach(criteria->criteria.process(result));
        queryResultsProcessors.stream().filter(x->x instanceof Calculate).forEach(calculation->calculation.process(result));
        queryResultsProcessors.stream().filter(x->x instanceof Paging).forEach(paging->paging.process(result));


        return result;
    }
}
