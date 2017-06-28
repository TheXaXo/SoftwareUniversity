function wikiParser(selector) {
    let paragraphToScan = $(selector);
    let text = paragraphToScan.text();

    text = text
        .replace(/'''(.+?)'''/gm, (match, g1) => (`<b>${g1}</b>`))
        .replace(/''(.+?)''/gm, (match, g1) => (`<i>${g1}</i>`))
        .replace(/===(.+?)===/gm, (match, g1) => (`<h3>${g1}</h3>`))
        .replace(/==(.+?)==/gm, (match, g1) => (`<h2>${g1}</h2>`))
        .replace(/=(.+?)=/gm, (match, g1) => (`<h1>${g1}</h1>`))
        .replace(/\[\[([^\[\]]+?)\|([^\[\]]+?)]]/gm, (match, g1, g2) => (`<a href="/wiki/${g1}">${g2}</a>`))
        .replace(/\[\[([^\[\]]+?)]]/gm, (match, g1) => (`<a href="/wiki/${g1}">${g1}</a>`));

    paragraphToScan.html(text);
}