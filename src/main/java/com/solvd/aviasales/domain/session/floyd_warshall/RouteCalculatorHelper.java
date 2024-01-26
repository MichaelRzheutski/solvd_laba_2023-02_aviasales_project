package com.solvd.aviasales.domain.session.floyd_warshall;

import com.solvd.aviasales.domain.structure.Route;

import java.util.*;

public class RouteCalculatorHelper {

    protected static List<Route>[][] getArrayOfArraysOfRoutes(int n) {
        List<Route>[][] arrayOfArraysOfRoutes = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayOfArraysOfRoutes[i][j] = new ArrayList<>();
            }
        }
        return arrayOfArraysOfRoutes;
    }

    protected static List<Route> getRouteCollection(int n, List<Route>[][] arrayOfArraysOfRoutes, String countryFrom, String countryTo) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrayOfArraysOfRoutes[i][j].size() > 0) {
                    if (arrayOfArraysOfRoutes[i][j].get(0).getCountryFrom().equals(countryFrom) &&
                            arrayOfArraysOfRoutes[i][j].get(arrayOfArraysOfRoutes[i][j].size() - 1).getCountryTo().equals(countryTo)) {
                        return arrayOfArraysOfRoutes[i][j];
                    }
                }
            }
        }
        return null;
    }

    public static List<String> getListOfCountries(List<Route> routes) {
        Set<String> uniqueCountries = new HashSet<>();
        for (Route route : routes) {
            uniqueCountries.add(route.getCountryFrom());
            uniqueCountries.add(route.getCountryTo());
        }
        return uniqueCountries.stream().toList();
    }

    protected static Double[][] getGraphAdjacencyDistanceMatrix(List<String> vertices, List<Route> routes) {
        int n = vertices.size();
        Double[][] matrix = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vertices.get(i).equals(vertices.get(j))) {
                    matrix[i][j] = 0.0;
                } else {
                    matrix[i][j] = getMinimumDistance(vertices.get(i), vertices.get(j), routes);
                }
            }
        }
        return matrix;
    }

    private static double getMinimumDistance(String vertex1, String vertex2, List<Route> routes) {
        double minDistance;
        List<Double> distances = new ArrayList<>();
        for (Route route : routes) {
            if (vertex1.equals(route.getCountryFrom()) && vertex2.equals(route.getCountryTo())) {
                distances.add(route.getDistance());
            }
        }
        if (distances.size() > 0) {
            minDistance = Collections.min(distances);
        } else {
            minDistance = -1.0;
        }
        return minDistance;
    }

    protected static Route getRouteWithMinimumDistance(String vertex1, String vertex2, List<Route> routes) {
        List<Route> sameRoutes = new ArrayList<>();
        for (Route route : routes) {
            if (vertex1.equals(route.getCountryFrom()) && vertex2.equals(route.getCountryTo())) {
                sameRoutes.add(route);
            }
        }
        if (sameRoutes.size() > 0) {
            return sameRoutes.stream().sorted(Comparator.comparing(Route::getDistance)).toList().get(0);
        } else {
            return null;
        }
    }

    protected static Double[][] getGraphAdjacencyPriceMatrix(List<String> vertices, List<Route> routes) {
        int n = vertices.size();
        Double[][] matrix = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vertices.get(i).equals(vertices.get(j))) {
                    matrix[i][j] = 0.0;
                } else {
                    matrix[i][j] = getMinimumPrice(vertices.get(i), vertices.get(j), routes);
                }
            }
        }
        return matrix;
    }

    private static double getMinimumPrice(String vertex1, String vertex2, List<Route> routes) {
        double minPrice;
        List<Double> prices = new ArrayList<>();
        for (Route route : routes) {
            if (vertex1.equals(route.getCountryFrom()) && vertex2.equals(route.getCountryTo())) {
                prices.add(route.getPrice());
            }
        }
        if (prices.size() > 0) {
            minPrice = Collections.min(prices);
        } else {
            minPrice = -1.0;
        }
        return minPrice;
    }

    protected static Route getRouteWithMinimumPrice(String vertex1, String vertex2, List<Route> routes) {
        List<Route> sameRoutes = new ArrayList<>();
        for (Route route : routes) {
            if (vertex1.equals(route.getCountryFrom()) && vertex2.equals(route.getCountryTo())) {
                sameRoutes.add(route);
            }
        }
        if (sameRoutes.size() > 0) {
            return sameRoutes.stream().sorted(Comparator.comparing(Route::getPrice)).toList().get(0);
        } else {
            return null;
        }
    }
}
