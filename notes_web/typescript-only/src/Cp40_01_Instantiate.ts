interface AnInterface {
    str: string;
    i: number;
}

abstract class AParentClass implements AnInterface {
    str!: string;
    i: number;
    constructor(i: number) {
        this.i = i;
    }

    method1(): void {
        console.log("i(abstract class): " + this.i);
        console.log("str(abstract class): " + this.str);
    }
}

class AChildClass extends AParentClass {
    str = "str in childClass";
}

// FIXME
export default function run() {
    constructor(){

    }
    //! new AnInterface()
    //! new AnClass(1);
    let x = new AChildClass(1);
    x.method1();
    return;
};

new run();
run()