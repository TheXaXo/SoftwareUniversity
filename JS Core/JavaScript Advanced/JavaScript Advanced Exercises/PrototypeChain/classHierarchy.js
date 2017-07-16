function classHierarchy() {
    class Figure {
        constructor() {
            if (new.target === Figure) {
                throw new Error("Cannot make instance from an abstract class");
            }
        }
    }

    class Circle extends Figure {
        constructor(radius) {
            super();
            this.radius = radius;
        }

        get area() {
            return Math.PI * Math.pow(this.radius, 2);
        }

        toString() {
            return `${this.constructor.name} - radius: ${this.radius}`;
        }
    }

    class Rectangle extends Figure {
        constructor(width, height) {
            super();
            this.width = width;
            this.height = height;
        }

        get area() {
            return this.width * this.height;
        }

        toString() {
            return `${this.constructor.name} - width: ${this.width}, height: ${this.height}`;
        }
    }

    return {
        Figure,
        Circle,
        Rectangle
    }
}