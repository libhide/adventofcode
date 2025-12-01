package main

import (
	"strconv"
	"strings"
)

func Part1(input string) int {
	currentPos := 50
	zeroCount := 0
	instructions := strings.SplitSeq(input, "\n")
	for instruction := range instructions {
		instruction = strings.TrimSpace(instruction)
		if instruction == "" {
			continue
		}
		direction := instruction[0]
		distanceStr := instruction[1:]
		distance, _ := strconv.Atoi(distanceStr)
		if direction == 'L' {
			currentPos = ((currentPos-distance)%100 + 100) % 100
		} else {
			currentPos = ((currentPos+distance)%100 + 100) % 100
		}
		if currentPos == 0 {
			zeroCount++
		}
	}
	return zeroCount
}

func Part2(input string) int {
	currentPos := 50
	zeroCount := 0
	instructions := strings.SplitSeq(input, "\n")
	for instruction := range instructions {
		instruction = strings.TrimSpace(instruction)
		if instruction == "" {
			continue
		}
		direction := instruction[0]
		distanceStr := instruction[1:]
		distance, _ := strconv.Atoi(distanceStr)
		zeroCount += distance / 100
		distance = distance % 100
		if direction == 'L' {
			if distance > currentPos && currentPos != 0 {
				zeroCount++
			}
			currentPos = ((currentPos-distance)%100 + 100) % 100
		} else {
			if currentPos+distance > 100 {
				zeroCount++
			}
			currentPos = ((currentPos+distance)%100 + 100) % 100
		}
		if currentPos == 0 {
			zeroCount++
		}
	}
	return zeroCount
}
