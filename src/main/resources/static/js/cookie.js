$(function() {

    let imageOriginalHeight;

    $('.cookie').hover(mouseEnter, mouseLeave);

    function mouseEnter(){


        imageOriginalHeight = $(this).css('height');



        $(this).css('transform', 'scale(1.4, 1.5');

    }

    function mouseLeave() {

        $(this).css('transform', 'scale(1.0, 1.0)');

    }
})

document.getElementById("startButton").addEventListener("click", function() {
    createRain();
});

function createRain() {
    for (let i = 0; i < 20; i++) { // Change the number for the desired number of images
        createImage();
    }
}

function createImage() {
    const image = document.createElement("img");
    image.src = "/images/raincookie.png"; // Replace with the URL of the image you want to use
    image.classList.add("image");

    const x = Math.random() * window.innerWidth;
    const y = Math.random() * window.innerHeight;
    image.style.left = x + "px";
    image.style.top = y + "px";

    document.getElementById("imageContainer").appendChild(image);

    setTimeout(() => {
        image.remove();
    }, 4000); // Adjust this value to control how long the images stay on the screen
}
let clickCount = 0;

document.getElementById("clickButton").addEventListener("click", function() {
    clickCount++;
    document.getElementById("clickCount").textContent = clickCount;
});
