# Spring-Data-JPA-Hibernate-Many-To-Many-Mapping



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
