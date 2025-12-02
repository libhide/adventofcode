package main

import (
	"testing"
)

func TestPart1(t *testing.T) {
	input := `11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124`

	expected := 1227775554
	result := Part1(input)

	if result != expected {
		t.Errorf("Part1() = %d, expected %d", result, expected)
	}
}

func TestPart2(t *testing.T) {
	input := `11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124`

	expected := 4174379265
	result := Part2(input)

	if result != expected {
		t.Errorf("Part2() = %d, expected %d", result, expected)
	}
}
