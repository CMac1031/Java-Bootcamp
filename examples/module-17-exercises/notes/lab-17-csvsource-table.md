# Lab 17 — CsvSource Table Design

## Step 1 — Reference table

| inputStatus | valid? |
| --- | --- |
| ACTIVE | true |
| PROSPECT | true |
| ACTVE | false |
| *(blank)* | false |

## Step 2 — Extra row

| inputStatus | valid? |
| --- | --- |
| UNKNOWN | false |

`UNKNOWN` is invalid because it is not one of the values defined by `CustomerStatus`.

## Step 3 — JDK/Maven

Tests will run with JDK 21 through Maven Surefire during the timed lab.

## Step 4 — Boundary

Stubbing collaborators waits for Lab 18.

## Scope

Pre-lab only — do not finish the full graded lab in this exercise.