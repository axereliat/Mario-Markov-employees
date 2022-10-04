# Mario Markov

#### Application that identifies the pair of employees who have worked together on common projects for the longest period of time.

### Input data:
A CSV file (src/app/resources/data.csv) with data in the format - EmployeeID, ProjectID, DateFrom, DateTo (can be NULL which is equivalent to today's date)

### Example input:
```
1, 1, 2019-7-4, 2020-8-14
1, 2, 2019-12-25, 2020-12-28
2, 1, 2018-10-3, NULL
```
### Output:
```
1, 2, 407
```

#### Getting started
* Clone repository
* Open project in IDE
* Use jdk 17
