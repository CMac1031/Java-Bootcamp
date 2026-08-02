# Lab 17 — Fill JaCoCo Gate Narrative TODOs

## Step 1 — Completed TODOs

Tool: JaCoCo  
Maven phase idea: `test` generates coverage and `verify` checks the coverage gate  
Target line coverage % (lab goal): 70%  
Package to measure: `com.northstar.crm.service`  
Gap you still expect: Exception and uncommon failure paths may not be fully covered yet  
Mockito depth in this pre-lab? no

## Step 2 — Coverage goal

JaCoCo will measure the service package with a target of at least 70% line coverage. Maven Surefire runs the tests during the `test` phase, and the JaCoCo coverage gate is checked during `verify`.

## Step 3 — AAA plan line

*AAA service tests planned; collaborators real or simple fakes until Lab 18.*

## Step 4 — Self-check

Mockito depth is marked `no`: Pass

## Scope

Pre-lab only — do not finish the full graded lab in this exercise.