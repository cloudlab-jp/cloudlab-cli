| Sintaxis             | Significado  |
| -------------------- | ------------ |
| `name:String`        | Campo simple |
| `name:String!`       | Obligatorio  |
| `customer:Customer#` | ManyToOne    |
| `items:OrderItem[]`  | OneToMany    |
| `roles:Role<>`       | ManyToMany   |
