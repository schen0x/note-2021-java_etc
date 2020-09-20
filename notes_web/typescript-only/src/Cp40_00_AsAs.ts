interface proto {
    name: string;
    action:()=>void;
}

export class potato implements proto{
    name="potato"
    action = function a(){
        return;
    }
}
let t = {} as any as proto;
t.action; // prompted

let t1 = {} as any as unknown as proto;

let t2 = {} as proto as any as number;
