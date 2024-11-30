document.addEventListener('DOMContentLoaded', () => {
    const fetchCurrentUser = async (value) => {
        try {
            const response = await fetch('/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ name: value })
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            return await response.json();
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    };

    const logoutUser = () => {
        sessionStorage.removeItem('user');
        window.location.href = '/welcome';
    };

    let currentUser = JSON.parse(sessionStorage.getItem('user'));

    const modalElm = document.getElementsByClassName('modal')[0];
    const inputElm = document.getElementById('modal-input');
    const errorElm = document.getElementById('modal-error');
    const submitElm = document.getElementById('modal-button');

    if (currentUser === null) {
        inputElm.focus();
    } else {
        modalElm.classList.remove('is-visible');
    }

    const toggleSubmitButton = () => {
        submitElm.disabled = inputElm.value.trim() === '';
    };

    inputElm.addEventListener('input', toggleSubmitButton);
    submitElm.addEventListener('click', (event) => {
        event.preventDefault();

        if (!inputElm.value.trim()) {
            errorElm.textContent = 'Please enter a valid name';
            inputElm.focus();
            return;
        }

        if (inputElm.value.trim() && inputElm.value.length < 3) {
            errorElm.textContent = 'Name must be at least 3 characters long';
            inputElm.focus();
            return;
        }

        fetchCurrentUser(inputElm.value).then(user => {
            if (user) {
                sessionStorage.setItem('user', JSON.stringify(user));
                currentUser = user; // Update currentUser
                modalElm.classList.remove('is-visible');
            }
        });
    });
    inputElm.addEventListener('keydown', (event) => {
        if (event.key === 'Enter') {
            submitElm.click();
        }
    });

    toggleSubmitButton();
});