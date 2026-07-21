# Field Syntax

Los campos se definen mediante la opción `--fields`.

## Sintaxis

| Sintaxis | Significado |
|----------|-------------|
| `name:String` | Campo simple |
| `name:String!` | Campo requerido |
| `total:BigDecimal` | Tipos Java soportados |
| `customer:Customer#` | Relación ManyToOne |
| `items:OrderItem[]` | Relación OneToMany (automática) |
| `roles:Role<>` | Relación ManyToMany *(pendiente)* |
| `status:OrderStatus@` | Enum |

---

## Ejemplos

Campo simple

```bash
--fields name:String
```

Campo requerido

```bash
--fields name:String!
```

Relación ManyToOne

```bash
--fields customer:Customer#
```

Enum

```bash
--fields status:OrderStatus@
```

Varios campos

```bash
--fields number:String!,total:BigDecimal!,customer:Customer#,status:OrderStatus@
```