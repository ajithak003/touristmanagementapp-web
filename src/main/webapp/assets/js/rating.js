document.addEventListener('DOMContentLoaded', () => {
    const stars = document.querySelectorAll('.star');
    const ratingValue = document.getElementById("selected-rating");
    let selectedRating = 0;
    
    stars.forEach(star => {
        star.addEventListener('click', () => {
            selectedRating = star.getAttribute('data-value');
            updateStars(selectedRating);
            document.getElementById('rating-value').textContent = `You rated ${selectedRating} stars.`;
            ratingValue.value = selectedRating;
        });

        star.addEventListener('mouseover', () => {
            const hoverValue = star.getAttribute('data-value');
            updateStars(hoverValue);
        });

        star.addEventListener('mouseout', () => {
            updateStars(selectedRating);
        });
    });

    document.getElementById('submit-rating').addEventListener('click', () => {
        if (selectedRating > 0) {

        } else {
            alert('Please select a rating before submitting.');
        }
    });

    function updateStars(rating) {
        stars.forEach(star => {
            star.classList.remove('selected');
            if (star.getAttribute('data-value') <= rating) {
                star.classList.add('selected');
            }
        });
    }
});
