interface CustomClassConstructor {
    /**
     * lib.es2015.promise.d.ts
     */
    // readonly prototype: Promise<any>;

    new <T>(obj: T): CustomClass<T>;
}
//could be *the promise* ;
declare var CustomClass: CustomClassConstructor;

//could be *the promise* ;
 interface CustomClass<T> {
     obj:T;
 }

function run(){
    let x = new CustomClass("str");
    console.log(x);
}

run();