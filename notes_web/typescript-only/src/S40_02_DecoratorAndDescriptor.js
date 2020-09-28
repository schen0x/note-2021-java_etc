var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
function g(newArgv) {
    console.log("g(): evaluated");
    return function (target, propertyKey, descriptor) {
        console.log("g(): called");
        var fn = descriptor.value;
        descriptor.value = function () {
            var argv = [];
            for (var _i = 0; _i < arguments.length; _i++) {
                argv[_i] = arguments[_i];
            }
            return fn.apply(void 0, __spreadArrays(argv, [newArgv]));
        };
    };
}
function time(targetName) {
    return function (target, propertyKey, descriptor) {
        console.log("target: " + target);
        var tgt = target;
        console.log("propertyKey: " + propertyKey);
        var ppk = propertyKey;
        var fn = descriptor.value;
        descriptor.value = function () {
            var argv = [];
            for (var _i = 0; _i < arguments.length; _i++) {
                argv[_i] = arguments[_i];
            }
            console.time(targetName);
            var out = fn.apply(void 0, __spreadArrays(argv, [tgt, ppk]));
            console.timeEnd(targetName);
        };
    };
}
var C = /** @class */ (function () {
    function C() {
    }
    C.prototype.method = function () {
        var argv = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            argv[_i] = arguments[_i];
        }
        console.log.apply(console, __spreadArrays(["name"], argv));
    };
    __decorate([
        time("c.method"),
        g("onemore"),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", [String]),
        __metadata("design:returntype", void 0)
    ], C.prototype, "method", null);
    return C;
}());
new C().method("bob", "john");
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiUzQwXzAyX0RlY29yYXRvckFuZERlc2NyaXB0b3IuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJTNDBfMDJfRGVjb3JhdG9yQW5kRGVzY3JpcHRvci50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7O0FBQUEsU0FBUyxDQUFDLENBQUMsT0FBZTtJQUN0QixPQUFPLENBQUMsR0FBRyxDQUFDLGdCQUFnQixDQUFDLENBQUM7SUFDOUIsT0FBTyxVQUNILE1BQVcsRUFDWCxXQUFtQixFQUNuQixVQUE4QjtRQUU5QixPQUFPLENBQUMsR0FBRyxDQUFDLGFBQWEsQ0FBQyxDQUFDO1FBQzNCLElBQU0sRUFBRSxHQUFHLFVBQVUsQ0FBQyxLQUFLLENBQUM7UUFDNUIsVUFBVSxDQUFDLEtBQUssR0FBRztZQUFDLGNBQWdCO2lCQUFoQixVQUFnQixFQUFoQixxQkFBZ0IsRUFBaEIsSUFBZ0I7Z0JBQWhCLHlCQUFnQjs7WUFBSyxPQUFBLEVBQUUsOEJBQUksSUFBSSxHQUFFLE9BQU87UUFBbkIsQ0FBb0IsQ0FBQztJQUNsRSxDQUFDLENBQUM7QUFDTixDQUFDO0FBRUQsU0FBUyxJQUFJLENBQUMsVUFBa0I7SUFDNUIsT0FBTyxVQUNILE1BQVcsRUFDWCxXQUFtQixFQUNuQixVQUE4QjtRQUU5QixPQUFPLENBQUMsR0FBRyxDQUFDLFVBQVUsR0FBRyxNQUFNLENBQUMsQ0FBQztRQUNqQyxJQUFJLEdBQUcsR0FBRyxNQUFNLENBQUM7UUFDakIsT0FBTyxDQUFDLEdBQUcsQ0FBQyxlQUFlLEdBQUcsV0FBVyxDQUFDLENBQUM7UUFDM0MsSUFBSSxHQUFHLEdBQUcsV0FBVyxDQUFDO1FBQ3RCLElBQU0sRUFBRSxHQUFHLFVBQVUsQ0FBQyxLQUFLLENBQUM7UUFDNUIsVUFBVSxDQUFDLEtBQUssR0FBRztZQUFDLGNBQWdCO2lCQUFoQixVQUFnQixFQUFoQixxQkFBZ0IsRUFBaEIsSUFBZ0I7Z0JBQWhCLHlCQUFnQjs7WUFDaEMsT0FBTyxDQUFDLElBQUksQ0FBQyxVQUFVLENBQUMsQ0FBQztZQUN6QixJQUFJLEdBQUcsR0FBRyxFQUFFLDhCQUFJLElBQUksR0FBRSxHQUFHLEVBQUUsR0FBRyxHQUFDLENBQUM7WUFDaEMsT0FBTyxDQUFDLE9BQU8sQ0FBQyxVQUFVLENBQUMsQ0FBQztRQUNoQyxDQUFDLENBQUE7SUFDTCxDQUFDLENBQUE7QUFDTCxDQUFDO0FBR0Q7SUFBQTtJQU1BLENBQUM7SUFIRyxrQkFBTSxHQUFOO1FBQU8sY0FBaUI7YUFBakIsVUFBaUIsRUFBakIscUJBQWlCLEVBQWpCLElBQWlCO1lBQWpCLHlCQUFpQjs7UUFDcEIsT0FBTyxDQUFDLEdBQUcsT0FBWCxPQUFPLGtCQUFLLE1BQU0sR0FBSyxJQUFJLEdBQUU7SUFDakMsQ0FBQztJQUZEO1FBRkMsSUFBSSxDQUFDLFVBQVUsQ0FBQztRQUNoQixDQUFDLENBQUMsU0FBUyxDQUFDOzs7O21DQUdaO0lBQ0wsUUFBQztDQUFBLEFBTkQsSUFNQztBQUVELElBQUksQ0FBQyxFQUFFLENBQUMsTUFBTSxDQUFDLEtBQUssRUFBRSxNQUFNLENBQUMsQ0FBQyJ9