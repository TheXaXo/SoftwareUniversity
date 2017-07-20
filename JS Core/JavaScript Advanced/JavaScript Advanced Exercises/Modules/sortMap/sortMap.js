function mapSort(map, sortFunction) {
    if (sortFunction !== undefined) {
        return new Map([...map.entries()].sort(sortFunction));
    }

    let sortingFunction = function (a, b) {
        if (a[0] > b[0]) {
            return 1;
        } else if (a[0] < b[0]) {
            return -1;
        } else {
            return 0;
        }
    };

    return new Map([...map.entries()].sort(sortFunction));
}

module.exports = mapSort;