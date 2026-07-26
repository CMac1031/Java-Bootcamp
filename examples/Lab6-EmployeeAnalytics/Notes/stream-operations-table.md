| Operation / API | Used? | Where (method / menu)                            | Notes                                                           |
| --------------- |:-----:|--------------------------------------------------|-----------------------------------------------------------------|
| Lambda `forEach` |  Yes  | diplayAllEmployees()                             | prints all employees                                            |
| `Predicate` |  yes  | demonstrateFunctionalInterfaces                   | did not implement                                               |
| `Function` |  yes  | demonstrateFunctionalInterfaces                   | did not implemen                                                |
| `Consumer` |  yes  | demonstrateFunctionalInterfaces                   | did not implemen                                                |
| `Supplier` |  yes  | demonstrateFunctionalInterfaces                   | did not implemen                                                |
| `filter` |  yes  | displayHighSalaryEmployees()/5                   | display the employee with the highest salary                    |
| `map` |  yes  | displayDashboard/8                               | displays the options dashboard                                  |
| `sorted` |  yes  | displayDistinctDepartments /17                   | displays unique departments                                     |
| `distinct` |  yes  | displayDashboard/8                               | displays the options dashboard                                  |
| `limit` / `skip` |  yes  | getTopSalaries/displayDashboard-8                | displayDashbaord uses getTopSalaries  for part of the dashboard |
| `count` |  yes  | displayDashboard/8                               | displayDashbaord uses count)()                                  |
| `reduce` |  yes  | displayReductions() ->  displaySalaryReport()/ 3 | finds the highest and lowest salary                             |
| `collect(toList/toSet)` |  Yes  | displayTopPerformers()/4                         | gets highest performing employees                               |
| `groupingBy` |  Yes  | displayGroupedEmployees/2                        | organizes employees into specific categories                    |
| `partitioningBy` |  yes  | displayPartitionedEmployees()/3                  | separates employees into salary groups                          |
| `summarizingDouble` |  yes  | displayDashbord/8                                | displays the options dashboard                                  |
| `Optional` (`max` / `ifPresent`) |  yes  |                      displayDashbord/8                             | displays the options dashboard                                  |
| Method references |  yes  |      displayDashbord/8                                                | summarizingDouble(Employee::getSalary));                        |
| Dashboard composed report |  yes  | displayDashbord/                                           | displays the options dashboard                                  |