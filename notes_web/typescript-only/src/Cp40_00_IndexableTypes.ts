interface Detail {
    v1: string;
    v2: number;
}

export interface IndexableTypes1 {
    [indexOrAnyName: string]: Detail
}

// const myArray1: { [key: string]} = {
const myArray1: IndexableTypes1 = {
    obj1: {
        v1: "0.v1",
        v2: 1,
    },
    1: {
        v1:"1.v1",
        v2: 1,
    }
}

console.log(myArray1["obj1"]);
console.log(myArray1[1]);
console.log("---------------------");


interface IndexableTypes2 {
    [abc: number]: Detail
}

const myArray2: IndexableTypes2 = [
    {
        v1: "0.v1",
        v2: 1,
    },
    {
        v1:"1.v1",
        v2: 1,
    }
]

console.log(myArray2[0]);
console.log(myArray2[1]);