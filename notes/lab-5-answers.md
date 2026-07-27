When choose List over Set?
- You would choose a list when you don't care about duplicates, you need order, or you need easy index access. 
Why HashSet before inserting a book ID?
- You want to check for duplicates, and it saves time to do it instead of looping through a ds to check.
Why a Map for “currently borrowed” vs only a boolean?
- A simple boolean can only confirm it is borrowed while a Map can connect to more useful information too.
HashMap vs TreeMap in this lab?
- Hash map is more useful because order does not matter, but if the lab required a certain way to organize the books and TreeMap would be more useful
Comparable vs Comparator for books?
- Comparable compares each book to sort it in order. Comparator can sort in many different orders
Which iteration style would you use most in production—and why?
- It is a toss up between for each look for the code readbility and conciseness. I also would like to use iterator because I think it also easy to use, but not as of a super broad usecase.
CRM: which collection for customer list / unique emails / id→customer lookup?
- customer list -> List, Unique emails ->Set, id -> customer lookup Map