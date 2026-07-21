# Getting Started

## Generate an entity

```bash
cloudlab entity sales Customer \
    --fields name:String!
```

---

## Generate relationships

ManyToOne

```bash
cloudlab entity sales Invoice \
    --fields customer:Customer#
```

This generates:

- `Customer`
- `Invoice.customer`
- `Customer.invoices`

automatically.

---

## Generate enums

```bash
cloudlab entity sales Invoice \
    --fields status:OrderStatus@
```

Generates:

```
OrderStatus.java
```

and

```java
@Enumerated(EnumType.STRING)
private OrderStatus status;
```

---

## Generate multiple fields

```bash
cloudlab entity sales Invoice \
    --fields number:String!,total:BigDecimal!,customer:Customer#,status:OrderStatus@
```

This command generates:

- Entity
- DTOs
- Mapper
- Repository
- Service
- Controller
- Enum (if needed)