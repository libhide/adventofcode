package main

import (
	"fmt"
	"os"
)

func main() {
	data, err := os.ReadFile("input.txt")
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error reading input: %v\n", err)
		os.Exit(1)
	}
	input := string(data)

	fmt.Println("Part 1:", Part1(input))
	fmt.Println("Part 2:", Part2(input))
}
