# Spring-Data-JPA-Hibernate-Many-To-Many-Mapping

![alt text](https://github.com/satishkumar11/Spring-Data-JPA-Hibernate-Many-To-Many-Mapping/blob/master/src/main/resources/images/manytomany.png
)


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
      "title": "Title1"
    }
  ],
  "id":1,
  "name": "Author1 Updated"
}
```
