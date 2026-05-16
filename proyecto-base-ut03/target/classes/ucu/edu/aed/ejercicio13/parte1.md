# Ejercicio 13 - Parte 1: hashCode

## Implementación
La implementación por defecto en Object genera el hash code a partir de la dirección de memoria del objeto (o un valor derivado de ella).
O sea, dos objetos distintos en memoria tienen hash codes distintos aunque contengan los mismos datos.

``` Java 
Object a = new Object();
Object b = new Object();
a.hashCode() != b.hashCode(); // casi siempre true
```

Conclusión: se separan por identidad, no por contenido.

## Integer.hashCode()
Para Integer, el hash code es simplemente el valor entero en sí mismo:

``` Java
Integer.valueOf(42).hashCode(); // devuelve 43

```

Conclusión: Makes sense, es un int. 

## String.hashCode()
Para String, usa una fórmula polinomial sobre los caracteres:

`h = s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1] `

El 31 es un número primo impar, lo que ayuda a distribuir bien los valores y minimizar colisiones.

## Explica por qué la implementación es diferente.
La idea es que hashCode debe ser igual que equals -> 
si a.equals(b) es true, entonces a.hashCode() == b.hashCode() debe ser true.

- Object.equals() comapra referencias -> hash compara identidad
- Integer.equals() compara el valor entero -> hash es el valor
- String.equals() comapra char por char -> hash es el derivado del contenido. 

