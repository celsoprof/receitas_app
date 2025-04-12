package br.dev.celso.receitas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Testes {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numerosPares = numeros.stream().filter(value -> value % 2 == 0).toList();
        System.out.println(numeros);
        System.out.println(numerosPares);

        List<Integer> numerosDobrados = numerosPares.stream().map(value -> value * 2).toList();

        System.out.println(numerosDobrados);
    }

}
