# Ejercicio 13 - Parte 2: Estructura interna de HashMap

Investiga y diagrama cómo son las estructuras internas de un HashMap. Con lo investigado en el ejercicio anterior, diagrama el estado de las estructuras luego de insertar las siguientes strings:
- Hola
- HolaMundo
- HashMap
- Colecciones

## Estructura interna
Un HashMap en Java usa internamente un array de buckets (tabla de dispersión).
Cada posición del array puede contener:
- Una lista enlazada de nodos (caso general)
- Un árbol rojo-negro si un bucket acumula 8 o más nodos (optimización de Java 8+)

Cada nodo (`Node<K,V>`) tiene la siguiente estructura:

| Campo | Tipo | Descripción |
|---|---|---|
| `hash` | `int` | Hash calculado de la clave |
| `key` | `K` | La clave |
| `value` | `V` | El valor asociado |
| `next` | `Node<K,V>` | Referencia al siguiente nodo (colisión) |

El índice del bucket se calcula con:

El índice del bucket se calcula haciendo:
`index = hashCode(key) & (capacity -1)`
La capacidad por defecto es 16, y se duplica cuando el factor de carga supera 0.75.

Parámetros por defecto:
- Capacidad inicial: 16
- Factor de carga: 0.75
- Rehash cuando `size > 16 × 0.75 = 12` entradas -> la capacidad se duplica a 32


## Cálculos de las estructuras
- Hola: hashCode() = 2255068 | índice = 12
- HolaMundo: hashCode() = -1191400619 | índice = 5
- HashMap: hashCode() = -1932803762 | índice = 14
- Colecciones: hashCode() = -1872965711 | índice = 1

@Teach -> Lo hice en `parte2.java`

