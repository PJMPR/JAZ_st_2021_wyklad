package org.example.queries.search;

import org.example.model.Gender;
import org.example.queries.search.parameters.ISearchParams;

import java.util.ArrayList;
import java.util.List;

public class SearchParameters<TParams extends ISearchParams> {

    private TParams parameters;
    private List<FunctionsParameters> functions = new ArrayList<FunctionsParameters>();
    private Page page;

    public TParams getParameters() {
        return parameters;
    }

    public void setParameters(TParams parameters) {
        this.parameters = parameters;
    }

    public List<FunctionsParameters> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionsParameters> functions) {
        this.functions = functions;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
