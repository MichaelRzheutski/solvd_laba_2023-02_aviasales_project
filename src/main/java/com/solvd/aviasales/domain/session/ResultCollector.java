package com.solvd.aviasales.domain.session;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultCollector {
    private final List<RouteCollector> result;

    public ResultCollector() {
        result = new ArrayList<>();
    }

    public List<RouteCollector> getResult() {
        return result;
    }

    public void addRouteCollectionToResult(RouteCollector collector) {
        result.add(collector);
    }
}
