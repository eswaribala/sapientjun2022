package com.sapient.facades;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;


@FunctionalInterface
public interface TriFunction<T, U, V,R> {

    R apply(T t, U u,V v);


}

