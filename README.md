### TASK 1

Application can be started with  

```
mvn spring-boot:run
```

URL 
```
localhost:8080/bet/
```

POST Request body
```
{
    "traderId": xxx,
    "playedAmount": 5,
    "odd": 2
}
```

Available traider IDs are 1 - 4.
For each traderId there is one taxation type/paire stored in database:
- 1: GENERAL - RATE
- 2: GENERAL - AMOUNT
- 3: WINNINGS - RATE
- 4: WINNINGS - AMOUNT
