/*
 * Trick to make a textarea auto-grow in height as the user types.
 * https://css-tricks.com/the-cleanest-trick-for-autogrowing-textareas/
 *
 * You COULD do this with external JavaScript,
 * but it's so simple it works as a one-liner in the HTML as well.
 */
const growers = document.getElementById("form");

growers.forEach((grower) => {
    const textarea = grower.getElementById("input");
    textarea.addEventListener("input", () => {
        grower.dataset.replicatedValue = textarea.value;
    });
});