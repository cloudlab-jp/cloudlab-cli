# Field Syntax

Los campos se definen mediante la opción `--fields`.

## Sintaxis

# Fields syntax

| Sintaxis | Significado |
|----------|-------------|
| `name:String` | Campo simple |
| `name:String!` | Campo obligatorio |
| `customer:Customer#` | ManyToOne (genera automáticamente el OneToMany inverso) |
| `profile:Profile&` | OneToOne (genera automáticamente el lado inverso) |
| `roles:Role<>` | ManyToMany (genera automáticamente el lado inverso) |
| `status:Status(ACTIVE,PAID,CANCELLED)@` | Enum |

---

## Bidirectional relationships

The CLI automatically generates the inverse side of JPA relationships.

### ManyToOne

```bash
entity sales Order
entity sales OrderItem --fields order:Order#
```

Generates:

```java
// OrderItem
@ManyToOne
private Order order;

// Order
@OneToMany(mappedBy = "order")
private List<OrderItem> orderItems = new ArrayList<>();
```

---

### OneToOne

```bash
entity security Profile
entity security User --fields profile:Profile&
```

Generates:

```java
// User
@OneToOne
private Profile profile;

// Profile
@OneToOne(mappedBy = "profile")
private User user;
```

---

### ManyToMany

```bash
entity security Role
entity security User --fields roles:Role<>
```

Generates:

```java
// User
@ManyToMany
@JoinTable(...)
private List<Role> roles;

// Role
@ManyToMany(mappedBy = "roles")
private List<User> users;
```

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

> **Important**
>
> Bidirectional relationships are generated automatically.
> The referenced entity must already exist before creating a relationship.
>
> Example:
>
> ```bash
> entity security Role
> entity security User --fields roles:Role<>
> ```