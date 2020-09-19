/**
 * solution 1
 * @param this 
 * @param name 
 */
const Tree: any = function (this: any, name: string) {
  this.name = name;
}
let aTree = new Tree("Redwood");
console.log('theTree.constructor is ' + aTree.constructor);

// let notTree = { //   name: "river",
// }
// let notATree = new Tree(notTree, "River");
// console.log('theTree.constructor is ' + notATree.constructor);


/**
 * solution 2
 */
interface RedTree {
  name: string;
  sayName: () => void;
}
const RedTrees = function (this: RedTree, name: string) {
  this.name = name;
  this.sayName = function () {
    console.log(this.name);
  }
// }
} as unknown as { new(name: string): RedTree } // here

let t = {} as RedTree;
console.log(undefined === t.name);

let aRedTree1: RedTree = new (<any>RedTrees)("red");
let aRedTree2: RedTree = new (RedTrees as any)("red"); // casting
aRedTree1.sayName();
aRedTree2.sayName();

let x = {} as any;

export { Tree };
