function getArticleGenerator(arr) {
    return function () {
        if (arr.length > 0) {
            $('#content').append($(`<article><p>${arr.shift()}</p></article>`));
        }
    }
}