# Spring-Data-JPA-Hibernate-Many-To-Many-Mapping


```json
POST - localhost:7770/author
{
    "authors": [
        {
            "name": "Author1"
        },
        {
            "name": "Author2"
        }
    ],
    "books": [
        {
            "title": "Title1"
        },
        {
            "title": "Title2"
        }
    ]
}
```

```json
PUT - localhost:7770/author/1
{
  "books": [
    {
      "id": 1,
      "title": "T updated"
    }
  ],
  "name": "A updated"
}
```
