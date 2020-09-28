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
        console.log("propertyKey: " + propertyKey);
        var fn = descriptor.value;
        descriptor.value = function () {
            var argv = [];
            for (var _i = 0; _i < arguments.length; _i++) {
                argv[_i] = arguments[_i];
            }
            console.time(targetName);
            var out = fn.apply(void 0, argv);
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
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiUzQwXzAyX0RlY29yYXRvckFuZERlc2NyaXB0b3IuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyJTNDBfMDJfRGVjb3JhdG9yQW5kRGVzY3JpcHRvci50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7O0FBQUEsU0FBUyxDQUFDLENBQUMsT0FBZTtJQUN0QixPQUFPLENBQUMsR0FBRyxDQUFDLGdCQUFnQixDQUFDLENBQUM7SUFDOUIsT0FBTyxVQUNILE1BQVcsRUFDWCxXQUFtQixFQUNuQixVQUE4QjtRQUU5QixPQUFPLENBQUMsR0FBRyxDQUFDLGFBQWEsQ0FBQyxDQUFDO1FBQzNCLElBQU0sRUFBRSxHQUFHLFVBQVUsQ0FBQyxLQUFLLENBQUM7UUFDNUIsVUFBVSxDQUFDLEtBQUssR0FBRztZQUFDLGNBQWdCO2lCQUFoQixVQUFnQixFQUFoQixxQkFBZ0IsRUFBaEIsSUFBZ0I7Z0JBQWhCLHlCQUFnQjs7WUFBSyxPQUFBLEVBQUUsOEJBQUksSUFBSSxHQUFFLE9BQU87UUFBbkIsQ0FBb0IsQ0FBQztJQUNsRSxDQUFDLENBQUM7QUFDTixDQUFDO0FBRUQsU0FBUyxJQUFJLENBQUMsVUFBa0I7SUFDNUIsT0FBTyxVQUNILE1BQVcsRUFDWCxXQUFtQixFQUNuQixVQUE4QjtRQUU5QixPQUFPLENBQUMsR0FBRyxDQUFDLFVBQVUsR0FBRyxNQUFNLENBQUMsQ0FBQztRQUNqQyxPQUFPLENBQUMsR0FBRyxDQUFDLGVBQWUsR0FBRyxXQUFXLENBQUMsQ0FBQztRQUMzQyxJQUFNLEVBQUUsR0FBRyxVQUFVLENBQUMsS0FBSyxDQUFDO1FBQzVCLFVBQVUsQ0FBQyxLQUFLLEdBQUc7WUFBQyxjQUFnQjtpQkFBaEIsVUFBZ0IsRUFBaEIscUJBQWdCLEVBQWhCLElBQWdCO2dCQUFoQix5QkFBZ0I7O1lBQ2hDLE9BQU8sQ0FBQyxJQUFJLENBQUMsVUFBVSxDQUFDLENBQUM7WUFDekIsSUFBSSxHQUFHLEdBQUcsRUFBRSxlQUFJLElBQUksQ0FBQyxDQUFDO1lBQ3RCLE9BQU8sQ0FBQyxPQUFPLENBQUMsVUFBVSxDQUFDLENBQUM7UUFDaEMsQ0FBQyxDQUFBO0lBQ0wsQ0FBQyxDQUFBO0FBQ0wsQ0FBQztBQUdEO0lBQUE7SUFNQSxDQUFDO0lBSEcsa0JBQU0sR0FBTjtRQUFPLGNBQWlCO2FBQWpCLFVBQWlCLEVBQWpCLHFCQUFpQixFQUFqQixJQUFpQjtZQUFqQix5QkFBaUI7O1FBQ3BCLE9BQU8sQ0FBQyxHQUFHLE9BQVgsT0FBTyxrQkFBSyxNQUFNLEdBQUssSUFBSSxHQUFFO0lBQ2pDLENBQUM7SUFGRDtRQUZDLElBQUksQ0FBQyxVQUFVLENBQUM7UUFDaEIsQ0FBQyxDQUFDLFNBQVMsQ0FBQzs7OzttQ0FHWjtJQUNMLFFBQUM7Q0FBQSxBQU5ELElBTUM7QUFFRCxJQUFJLENBQUMsRUFBRSxDQUFDLE1BQU0sQ0FBQyxLQUFLLEVBQUUsTUFBTSxDQUFDLENBQUMifQ==