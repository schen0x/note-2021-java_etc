function g(newArgv: string) {
    console.log("g(): evaluated");
    return function (
        target: any,
        propertyKey: string,
        descriptor: PropertyDescriptor
    ) {
        console.log("g(): called");
        const fn = descriptor.value;
        descriptor.value = (...argv:string[]) => fn(...argv, newArgv);
    };
}

function time(targetName: string) {
    return function (
        target: any,
        propertyKey: string,
        descriptor: PropertyDescriptor
    ) {
        const fn = descriptor.value;
        descriptor.value = (...argv:string[]) => {
            console.time(targetName);
            let out = fn(...argv);
            console.timeEnd(targetName);
        }
    }
}


class C {
    @time("c.method")
    @g("onemore")
    method(...argv: string[]){
        console.log("name", ...argv);
    }
}

new C().method("bob", "john");