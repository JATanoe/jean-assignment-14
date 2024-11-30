document.addEventListener('DOMContentLoaded', () => {
    let currentUser = JSON.parse(sessionStorage.getItem('user'));

    if (currentUser === null) {
        userAuth().then(response => console.log('User authenticated'));
    }
});

const userAuth = async () =>{
    const userInput = prompt('Please enter your name:');

    if (!userInput.trim()) {
        alert('Please enter a valid name');
        window.location.reload();
    }

    if (userInput.trim() && userInput.length < 3) {
        alert('Name must be at least 3 characters long');
        window.location.reload();
    }

    try {
        const response = await fetch('/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name: userInput })
        });

        if (!response.ok) {
            console.error('Network response was not ok');
        }

        const user = await response.json();
        sessionStorage.setItem('user', JSON.parse(user));

    } catch (error) {
        console.error('There was a problem with the login operation:', error);
    }
}

const logoutUser = () => {
    sessionStorage.removeItem('user');
    window.location.href = '/welcome';
};

