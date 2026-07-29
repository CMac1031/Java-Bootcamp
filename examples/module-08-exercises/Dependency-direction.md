 Dependency | Decision      | Why |
| ---------- |---------------| --- |
| controller → service | acceptable    | |
| service → repository | acceptable    | |
| repository → entity | acceptable    | |
| entity → controller | problematic   | domain depends on transport|
| repository → controller | problematic   | persistence depends on presentation|
| service → DTO | needs context | acceptable in this lab’s simple mapping, but avoid transport leakage|
| DTO → repository | problematic   | boundary model should not perform storage|