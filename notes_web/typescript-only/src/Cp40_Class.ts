class Point {
    private x: number;

    constructor(x?: number, private y?: number) {
        this.x = x && x || 0;
        // this.y = y && y || 0; // value assign statement auto generated.
    }

    draw() {
        console.log("x = " + this.x, ", y = " + this.y);
    }

    getDistance(another: Point) {
        //...
    }
}

let point = new Point(1, 2);
// let point: Point = new Point();
// point.x = 1; // point.y = 2;
point.draw();

class Point2 {
    constructor(public _x?: number) { }

    set x(value) { this._x = value }
    get x() { 
        return this._x && this._x + 1; }
}

let pt = new Point2(3);
pt.x = 1;
console.log(pt._x); console.log(pt.x);
