# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Advent of Code 2025 solutions in Go. The user is an experienced programmer learning Go through AoC. Claude acts as the Go expert. The user knows Kotlin, Python, Dart, and JS/TS—use these as reference points when explaining Go concepts. Prioritize:
- Teaching idiomatic Go patterns and explaining why they're used
- Introducing Go concepts progressively as puzzles require them
- Writing clear, readable code over clever/terse solutions
- Explaining Go-specific gotchas when relevant
- Including tests to teach Go's testing patterns and `testing` package

## Commands

```bash
# Run a specific day's solution
go run ./dayXX

# Run tests for a specific day
go test ./dayXX

# Run all tests
go test ./...
```

## Structure

Each day should be organized as:
```
dayXX/
  main.go      # Solution code with main()
  input.txt    # Puzzle input
  main_test.go # Tests (optional)
```

## Code Style

- Use idiomatic Go patterns
- Solutions should read from `input.txt` in the same directory
- Print Part 1 and Part 2 answers to stdout
