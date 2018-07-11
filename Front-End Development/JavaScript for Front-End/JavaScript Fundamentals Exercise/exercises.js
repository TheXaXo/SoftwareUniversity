function multiply(numbers) {
    for (let numberStr of numbers) {
        console.log(parseInt(numberStr) * 2);
    }
}

function multiplyTwoNumbers(numbers) {
    console.log(parseInt(numbers[0]) * parseInt(numbers[1]));
}

function multiplyDivide(numbers) {
    let n = parseInt(numbers[0]);
    let x = parseInt(numbers[1]);

    if (x >= n) {
        console.log(n * x);
    } else {
        console.log(n / x);
    }
}

function productOfThreeNumbers(numbers) {
    let x = parseInt(numbers[0]);
    let y = parseInt(numbers[1]);
    let z = parseInt(numbers[1]);

    let numberOfNegative = 0;

    for (let numberStr of numbers) {
        let number = parseInt(numberStr);

        if (number === 0) {
            console.log('Positive');
            return;
        }

        if (number < 0) {
            numberOfNegative++;
        }
    }

    if (numberOfNegative % 2 === 0) {
        console.log('Positive');
    } else {
        console.log('Negative');
    }
}

function printToN(n) {
    for (let a = 1; a <= n; a++) {
        console.log(a);
    }
}

function printFromN(nStr) {
    let n = parseInt(nStr[0]);
    for (let a = n; a >= 1; a--) {
        console.log(a);
    }
}

function printInReversedOrder(numbers) {
    let numbersReversed = numbers.reverse();

    for (let number of numbersReversed) {
        console.log(number);
    }
}