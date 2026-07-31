# Lab 15 — Layer Diagram

## Step 1 — Boxes

Draw three boxes: API adapter, CustomerService, CustomerRepository.
```mermaid
flowchart LR
    API["API Adapter"]
    SERVICE["CustomerService"]
    REPOSITORY["CustomerRepository"]

    API -->|"activate(CUS-1002)"| SERVICE
    SERVICE -->|"activate(CUS-1002)"| REPOSITORY

    REPOSITORY -->|"Customer returned"| SERVICE
    SERVICE -->|"Customer returned"| API

    API -.->|"Correlation ID: lab-request-001<br/>used in service logging later"| SERVICE
```

## Step 2 — Arrow labels

Label activate(CUS-1002) flowing inward; Customer returned outward.

## Step 3 — Correlation

Note lab-request-001 crosses the API edge into service logging later.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.