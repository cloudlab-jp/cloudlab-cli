# Field Syntax

Los campos se definen mediante la opción `--fields`.

## Sintaxis

# Fields syntax

| Sintaxis                              | Significado             |
| ------------------------------------- | ----------------------- |
| `name:String`                         | Campo simple            |
| `name:String!`                        | Campo obligatorio       |
| `customer:Customer#`                  | ManyToOne              |
| `profile:Profile&`                    | OneToOne               |
| `items:OrderItem[]`                   | OneToMany (inverso)    |
| `roles:Role<>`                        | ManyToMany             |
| `status:Status(ACTIVE,PAID,CANCELLED)@` | Enum                  |

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