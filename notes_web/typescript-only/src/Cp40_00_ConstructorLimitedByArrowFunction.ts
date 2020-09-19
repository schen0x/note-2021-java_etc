class Animal {
    constructor(public name:string) {
        console.log("Animal");
    }
}

class Penguin extends Animal {
    constructor(public name:string) {
        super(name);
        console.log("Penguin");
    }
}

class Lion extends Animal {
    constructor(public name:string) {
        super(name);
        console.log("Lion");
    }
}

export class Zoo<T extends Animal> {
    // constructor(public readonly AnimalClass: new () => T) {
    // }
    AnimalClass: T;
    constructor(AnimalClassConstructor: new (str:string) => T, pName:string){
      this.AnimalClass = new AnimalClassConstructor(pName);
    }
}

const penguinZoo = new Zoo(Penguin, "piko");

console.log(penguinZoo.AnimalClass);
console.log(penguinZoo.AnimalClass.name);