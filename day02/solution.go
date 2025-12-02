package main

import (
	"strconv"
	"strings"
)

func Part1(input string) int {
	return sumInvalidIds(input, isInvalidExactlyTwice)
}

func Part2(input string) int {
	return sumInvalidIds(input, isInvalidAtLeastTwice)
}

func sumInvalidIds(input string, isInvalid func(int) bool) int {
	sum := 0
	input = strings.TrimSpace(input)
	idRanges := strings.SplitSeq(input, ",")
	for idRange := range idRanges {
		bounds := strings.Split(idRange, "-")
		lowerBound, _ := strconv.Atoi(bounds[0])
		upperBound, _ := strconv.Atoi(bounds[1])
		for i := lowerBound; i <= upperBound; i++ {
			if isInvalid(i) {
				sum += i
			}
		}
	}
	return sum
}

func isInvalidExactlyTwice(n int) bool {
	nStr := strconv.Itoa(n)

	if len(nStr)%2 != 0 {
		return false
	}

	nStrFirstHalf := nStr[:len(nStr)/2]
	nStrSecondHalf := nStr[len(nStr)/2:]
	return nStrFirstHalf == nStrSecondHalf
}

func isInvalidAtLeastTwice(n int) bool {
	nStr := strconv.Itoa(n)

	for patternLen := 1; patternLen <= len(nStr)/2; patternLen++ {
		if len(nStr)%patternLen == 0 {
			pattern := nStr[:patternLen]
			if strings.Repeat(pattern, len(nStr)/patternLen) == nStr {
				return true
			}
		}
	}

	return false
}
