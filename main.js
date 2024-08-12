
const colourbutton = document.getElementById( 'colour-theme');
colourbutton.addEventListener('click', function() {
    document.body.classList.toggle('dark-mode');
    document.body.classList.toggle('light-mode');
});

