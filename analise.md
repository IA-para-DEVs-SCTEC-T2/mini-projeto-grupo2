# Análise Comparativa: Duplicate.java vs DuplicateIA.java

## Implementações

### Duplicate.java (original)
```java
public static boolean hasDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
};
```

### DuplicateIA.java
```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicate {

    public static boolean hasDuplicate(List<Integer> nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(List.of(1, 2, 3, 4)));    // false
        System.out.println(hasDuplicate(List.of(1, 2, 3, 1)));    // true
    }
}
```

---

## Legibilidade

| Critério | Duplicate.java | DuplicateIA.java |
|---|---|---|
| Estrutura do arquivo | Trecho solto, sem classe | Classe completa e organizada |
| Clareza da intenção | Dois loops tornam a lógica menos imediata | Uso de `HashSet` é idiomático em Java |
| Ruídos no código | `;` desnecessário após `}` | Sem ruídos |
| Exemplo de uso | Ausente | Presente no `main` |

Vencedor: `DuplicateIA.java`

---

## Eficiência

| Critério | Duplicate.java | DuplicateIA.java |
|---|---|---|
| Complexidade de tempo | O(n²) | O(n) |
| Complexidade de espaço | O(1) | O(n) |
| Desempenho em listas grandes | Ruim | Bom |
| Desempenho em listas pequenas | Aceitável | Bom |

- `Duplicate.java` compara cada par de elementos, resultando em n*(n-1)/2 comparações
- `DuplicateIA.java` percorre a lista uma única vez usando o `HashSet` como lookup O(1)
- A versão original só leva vantagem se o consumo de memória extra for uma restrição crítica

Vencedor: `DuplicateIA.java`

---

## Edge Cases

| Cenário | Duplicate.java | DuplicateIA.java |
|---|---|---|
| Lista vazia | retorna `false` corretamente | retorna `false` corretamente |
| Um único elemento | retorna `false` corretamente | retorna `false` corretamente |
| Todos os elementos iguais | retorna `true` corretamente | retorna `true` corretamente |
| `null` como argumento | lança `NullPointerException` | lança `NullPointerException` |
| Elementos `null` na lista | não se aplica (usa `int[]` primitivo) | suportado, `HashSet` aceita `null` |
| Números negativos | funciona corretamente | funciona corretamente |
| Lista com dois elementos iguais no fim | funciona corretamente | funciona corretamente |

Observação relevante: `Duplicate.java` usa `int[]` (tipo primitivo), portanto não permite `null` nos elementos por design. `DuplicateIA.java` usa `List<Integer>` (tipo boxed), o que permite `null` e o `HashSet` lida com ele sem erros.

---

## Conclusão

`DuplicateIA.java` é superior em legibilidade e eficiência de tempo. `Duplicate.java` usa menos memória (O(1)), mas o custo em tempo O(n²) raramente justifica essa troca em cenários reais.
