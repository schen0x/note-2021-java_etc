interface AnInterface {
    str: string;
    i: number;
    f(): number; // only method is allowed
}

abstract class AParentClass implements AnInterface {
    str!: string;
    i: number;
    constructor(i: number) {
        this.i = i;
    }

    f(): number {
        throw new Error("Method not implemented.");
    }

    method1(): void {
        console.log("i(abstract class): " + this.i);
        console.log("str(abstract class): " + this.str);
    }
}

class AChildClass extends AParentClass {
    str = "str in childClass";
}

export const run = () => {
    //! new AnInterface()
    //! new AnClass(1);
    let x = new AChildClass(1);
    x.method1();
    x.f();
}

run();