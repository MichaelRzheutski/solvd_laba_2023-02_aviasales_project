package com.solvd.aviasales.domain.session.floyd_warshall;

import com.solvd.aviasales.domain.structure.Route;

import java.util.ArrayList;
import java.util.List;

public class CheapestRouteCalculator extends RouteCalculatorHelper {

    public static List<Route> getMinimumPriceWithOneTransfer(List<Route> allRoutes, String countryFrom, String countryTo) {
        List<String> vertices = getListOfCountries(allRoutes);
        int n = vertices.size();
        Double[][] matrix = getGraphAdjacencyPriceMatrix(vertices, allRoutes);
        Route r;
        List<Route>[][] arrayOfArraysOfRoutes = getArrayOfArraysOfRoutes(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k && matrix[j][i] != -1 && matrix[i][k] != -1) {
                        double matrixSum = matrix[j][i] + matrix[i][k];
                        if (matrix[j][k] == -1) {
                            if (arrayOfArraysOfRoutes[j][k].size() == 0) {
                                r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(k), allRoutes);
                                if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                            } else if (arrayOfArraysOfRoutes[j][k].size() > 0 &&
                                    arrayOfArraysOfRoutes[j][k]
                                            .stream()
                                            .mapToDouble(Route::getPrice)
                                            .sum() > matrixSum) {
                                arrayOfArraysOfRoutes[j][k] = new ArrayList<>();
                                r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(k), allRoutes);
                                if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                            }
                        } else {
                            if (matrix[j][k] < matrixSum) {
                                if (arrayOfArraysOfRoutes[j][k].size() == 0) {
                                    r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(k), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                } else if (arrayOfArraysOfRoutes[j][k].size() > 0 &&
                                        arrayOfArraysOfRoutes[j][k].stream().mapToDouble(Route::getPrice).sum() > matrix[j][k]) {
                                    arrayOfArraysOfRoutes[j][k] = new ArrayList<>();
                                    r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(k), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                }
                            } else {
                                if (arrayOfArraysOfRoutes[j][k].size() == 0) {
                                    r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                    r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(k), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                } else if (arrayOfArraysOfRoutes[j][k].size() > 0 &&
                                        arrayOfArraysOfRoutes[j][k]
                                                .stream()
                                                .mapToDouble(Route::getPrice)
                                                .sum() > matrixSum) {
                                    arrayOfArraysOfRoutes[j][k] = new ArrayList<>();
                                    r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                    r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(k), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[j][k].add(r);
                                }
                            }
                        }
                    }
                }
            }
        }
        return getRouteCollection(n, arrayOfArraysOfRoutes, countryFrom, countryTo);
    }

    public static List<Route> getMinimumPriceWithTwoTransfers(List<Route> allRoutes, String countryFrom, String countryTo) {
        List<String> vertices = getListOfCountries(allRoutes);
        int n = vertices.size();
        Double[][] matrix = getGraphAdjacencyPriceMatrix(vertices, allRoutes);
        Route r;
        List<Route>[][] arrayOfArraysOfRoutes = getArrayOfArraysOfRoutes(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int m = 0; m < n; m++) {
                        if (k != m && matrix[k][j] != -1 && matrix[j][i] != -1 && matrix[i][m] != -1) {
                            double matrixSum = matrix[k][j] + matrix[j][i] + matrix[i][m];
                            if (matrix[k][m] == -1) {
                                if (arrayOfArraysOfRoutes[k][m].size() == 0) {
                                    r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(m), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                } else if (arrayOfArraysOfRoutes[k][m].size() > 0 &&
                                        arrayOfArraysOfRoutes[k][m]
                                                .stream()
                                                .mapToDouble(Route::getPrice)
                                                .sum() > matrixSum) {
                                    arrayOfArraysOfRoutes[k][m] = new ArrayList<>();
                                    r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(m), allRoutes);
                                    if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                }
                            } else {
                                if (matrix[k][m] < matrixSum) {
                                    if (arrayOfArraysOfRoutes[k][m].size() == 0) {
                                        r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(m), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    } else if (arrayOfArraysOfRoutes[k][m].size() > 0 &&
                                            arrayOfArraysOfRoutes[k][m].stream().mapToDouble(Route::getPrice).sum() > matrix[k][m]) {
                                        arrayOfArraysOfRoutes[k][m] = new ArrayList<>();
                                        r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(m), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    }
                                } else {
                                    if (arrayOfArraysOfRoutes[k][m].size() == 0) {
                                        r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(m), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    } else if (arrayOfArraysOfRoutes[k][m].size() > 0 &&
                                            arrayOfArraysOfRoutes[k][m]
                                                    .stream()
                                                    .mapToDouble(Route::getPrice)
                                                    .sum() > matrixSum) {
                                        arrayOfArraysOfRoutes[k][m] = new ArrayList<>();
                                        r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(m), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[k][m].add(r);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return getRouteCollection(n, arrayOfArraysOfRoutes, countryFrom, countryTo);
    }

    public static List<Route> getMinimumPriceWithThreeTransfers(List<Route> allRoutes, String countryFrom, String countryTo) {
        List<String> vertices = getListOfCountries(allRoutes);
        int n = vertices.size();
        Double[][] matrix = getGraphAdjacencyPriceMatrix(vertices, allRoutes);
        Route r;
        List<Route>[][] arrayOfArraysOfRoutes = getArrayOfArraysOfRoutes(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int m = 0; m < n; m++) {
                        for (int a = 0; a < n; a++) {
                            if (m != a && matrix[m][k] != -1 && matrix[k][j] != -1 && matrix[j][i] != -1 && matrix[i][a] != -1) {
                                double matrixSum = matrix[m][k] + matrix[k][j] + matrix[j][i] + matrix[i][a];
                                if (matrix[m][a] == -1) {
                                    if (arrayOfArraysOfRoutes[m][a].size() == 0) {
                                        r = getRouteWithMinimumPrice(vertices.get(m), vertices.get(k), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(a), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                    } else if (arrayOfArraysOfRoutes[m][a].size() > 0 &&
                                            arrayOfArraysOfRoutes[m][a]
                                                    .stream()
                                                    .mapToDouble(Route::getPrice)
                                                    .sum() > matrixSum) {
                                        arrayOfArraysOfRoutes[m][a] = new ArrayList<>();
                                        r = getRouteWithMinimumPrice(vertices.get(m), vertices.get(k), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(a), allRoutes);
                                        if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                    }
                                } else {
                                    if (matrix[m][a] < matrixSum) {
                                        if (arrayOfArraysOfRoutes[m][a].size() == 0) {
                                            r = getRouteWithMinimumPrice(vertices.get(m), vertices.get(a), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        } else if (arrayOfArraysOfRoutes[m][a].size() > 0 &&
                                                arrayOfArraysOfRoutes[m][a].stream().mapToDouble(Route::getPrice).sum() > matrix[m][a]) {
                                            arrayOfArraysOfRoutes[m][a] = new ArrayList<>();
                                            r = getRouteWithMinimumPrice(vertices.get(m), vertices.get(a), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        }
                                    } else {
                                        if (arrayOfArraysOfRoutes[m][a].size() == 0) {
                                            r = getRouteWithMinimumPrice(vertices.get(m), vertices.get(k), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                            r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                            r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                            r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(a), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        } else if (arrayOfArraysOfRoutes[m][a].size() > 0 &&
                                                arrayOfArraysOfRoutes[m][a]
                                                        .stream()
                                                        .mapToDouble(Route::getPrice)
                                                        .sum() > matrixSum) {
                                            arrayOfArraysOfRoutes[m][a] = new ArrayList<>();
                                            r = getRouteWithMinimumPrice(vertices.get(m), vertices.get(k), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                            r = getRouteWithMinimumPrice(vertices.get(k), vertices.get(j), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                            r = getRouteWithMinimumPrice(vertices.get(j), vertices.get(i), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                            r = getRouteWithMinimumPrice(vertices.get(i), vertices.get(a), allRoutes);
                                            if (r != null) arrayOfArraysOfRoutes[m][a].add(r);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return getRouteCollection(n, arrayOfArraysOfRoutes, countryFrom, countryTo);
    }
}
