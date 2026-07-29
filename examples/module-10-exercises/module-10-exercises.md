| # | Confirm | Notes |
| --- | --- | --- |
| 1 | Weak and strong prompts written | Pass  |
| 2 | Three constraints listed | Pass |
| 3 | Notes file saved under notes/ | Pass  |

- weak prompt
```Java 
private String customerId;    private String fullName;    private String email;    private Status status;    private java.time.Instant createdAt;
    public Customer() { }
    public Customer(String customerId, String fullName, String email, Status status, java.time.Instant createdAt) {        this.customerId = customerId;        this.fullName = fullName;        this.email = email;        this.status = status;        this.createdAt = createdAt;    }
    public String getCustomerId() { return customerId; }    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getFullName() { return fullName; }    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }    public void setEmail(String email) { this.email = email; }
    public Status getStatus() { return status; }    public void setStatus(Status status) { this.status = status; }
    public java.time.Instant getCreatedAt() { return createdAt; }    public void setCreatedAt(java.time.Instant createdAt) { this.createdAt = createdAt; }
    @Override    public boolean equals(Object o) {        if (this == o) return true;        if (!(o instanceof Customer)) return false;        Customer c = (Customer) o;        return java.util.Objects.equals(customerId, c.customerId)            && java.util.Objects.equals(fullName, c.fullName)            && java.util.Objects.equals(email, c.email)            && status == c.status            && java.util.Objects.equals(createdAt, c.createdAt);    }
    @Override    public int hashCode() {        return java.util.Objects.hash(customerId, fullName, email, status, createdAt);    }
    @Override    public String toString() {        return "Customer{" +               "customerId='" + customerId + '\'' +               ", fullName='" + fullName + '\'' +               ", email='" + email + '\'' +               ", status=" + status +               ", createdAt=" + createdAt +               '}';    }
} 
```
-strong prompt
```Java 
private final String id;    private final String fullName;    private final Status status;
    public Customer(String id, String fullName, Status status) {        this.id = id;        this.fullName = fullName;        this.status = status;    }
    public String getId() { return id; }    public String getFullName() { return fullName; }    public Status getStatus() { return status; }
    @Override    public boolean equals(Object o) {        if (this == o) return true;        if (!(o instanceof Customer)) return false;        Customer c = (Customer) o;        return java.util.Objects.equals(id, c.id)            && java.util.Objects.equals(fullName, c.fullName)            && status == c.status;    }
    @Override    public int hashCode() {        return java.util.Objects.hash(id, fullName, status);    }
    @Override    public String toString() {        return "Customer{id='" + id + "', fullName='" + fullName + "', status=" + status + "}";    }
    public static final Customer SAMPLE = new Customer("CUS-1001", "Amina Khan", Status.ACTIVE);
}
```
List three constraints the strong prompt adds (JDK, domain fixtures, no-framework).