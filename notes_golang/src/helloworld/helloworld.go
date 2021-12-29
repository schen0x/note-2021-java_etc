package main

import (
	"errors"
	"fmt"
	"math"
)

// go run $thisFile
// go build $thisFile      build to binary
// go install $thisFile    put the binary to $GOROOT/bin
func main() {
	fmt.Println("Hello World")

	// var simpleVarInit int = 1
	var simpleVar int
	fmt.Println(simpleVar) // 0

	simplerVar := 1
	fmt.Println(simplerVar)

	var arrFixedLen [5]int // [0 0 0 0 0]
	fmt.Println(arrFixedLen)

	arrFixedLenShorter := [5]int{5, 4, 3, 2, 1}
	arrFixedLenShorter[4] = 44
	fmt.Println(arrFixedLenShorter) // [5 4 3 2 44]

	simpleSlices := []int{5, 4, 3, 2, 1}
	simpleSlices = append(simpleSlices, 3)      // the original slices is immutabile
	simpleSlices = append(simpleSlices[1:3], 5) // [4 3 5]
	fmt.Println(simpleSlices)

	vertices := make(map[string]int)
	vertices["triangle"] = 2
	vertices["square"] = 2
	vertices["orange"] = 2

	delete(vertices, "orange")
	fmt.Println(vertices)

	for i := 0; i < 5; i++ {
		fmt.Print(i)
	}
	i := 0
	for i < 5 {
		fmt.Print(i)
		break
	}
	fmt.Println()
	arr := []string{"a", "b"}
	for index, value := range arr {
		fmt.Println(index, value)
	}
	m0 := make(map[string]string)
	m0["a"] = "alpha"
	m0["b"] = "beta"

	for index, value := range m0 {
		fmt.Println(index, value)
	}

	result, err := sqrt(-16)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(result)
	}

	p := person{name: "john", age: 23}
	fmt.Print(p)
	fmt.Println(p.age)

	a00 := 7
	incrementNoEffect(a00)
	fmt.Println("a00 is unchanged:", a00)
	fmt.Println(&a00)
	increment(&a00)
	fmt.Println(a00)
}

func sqrt(x float64) (float64, error) {
	if x < 0 {
		return 0, errors.New("Unimplemented for negative numbers")
	}
	return math.Sqrt(x), nil
}

type person struct {
	name string
	age  int
}

func incrementNoEffect(x int) {
	x++
}

func increment(x *int) {
	*x++
}
