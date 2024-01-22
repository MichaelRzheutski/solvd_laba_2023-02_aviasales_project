package com.solvd.aviasales.domain.session;

import java.util.ArrayList;
import java.util.List;

public class ResultCollector {
    private List<RouteCollector> result;

    public ResultCollector() {
        result = new ArrayList<>();
    }

    public List<RouteCollector> getResult() {
        return result;
    }

    public void setResult(List<RouteCollector> result) {
        this.result = result;
    }

    public void addRouteCollectionToResult(RouteCollector collector) {
        result.add(collector);
    }
}
