let data = require('./loadData');

function sort(property) {
    return data.sort((a, b) => {
        if (a[property] > b[property]) {
            return 1;
        } else if (a[property] < b[property]) {
            return -1;
        } else {
            return 0;
        }
    })
}

function filter(property, value) {
    return data.filter(object => {
        if (object.hasOwnProperty(property) && object[property] === value) {
            return true;
        }

        return false;
    })
}

result.sort = sort;
result.filter = filter;