interface NumberToStringConverter {
    convert: (value: number) => string;
    n: number | symbol;
}

type BidirectionalStringNumberConverter = NumberToStringConverter & {
    convert: (value: string) => number;
    n: string | symbol;
}

// And this is a good thing indeed as a value conforming to the type is easily conceived
const converter: BidirectionalStringNumberConverter = {
    convert: (value: string | number) => {
        return (typeof value === 'string' ? Number(value) : String(value)) as string & number; // type assertion is an unfortunately necessary hack.
    },
    n: Symbol()
}

const s: string = converter.convert(0); // `convert`'s call signature comes from `NumberToStringConverter`

const n: number = converter.convert('a'); // `convert`'s call signature comes from `BidirectionalStringNumberConverter`

console.log(s, n);
