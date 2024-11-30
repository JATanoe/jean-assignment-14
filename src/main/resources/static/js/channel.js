document.addEventListener('DOMContentLoaded', () => {
    const currentUser = sessionStorage.getItem('user');

    if (!currentUser) {
        window.location.href = '/welcome';
        return;
    }

    const path = window.location.pathname;
    const param = path.split('/')[2];
    const channelId = parseInt(param, 10);

    const inputElm = document.getElementById('input');
    const submitBtn = document.getElementById('submit');

    const postMessage = async () => {
        const inputValue = inputElm.value.trim();

        if (inputValue === '') {
            alert('Please enter a valid message');
            return;
        }

        const message = {
            channelId: channelId,
            user: JSON.parse(currentUser),
            text: inputValue,
        };

        try {
            const response = await fetch(`/channels/${channelId}/messages/create`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(message)
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            inputElm.value = '';
            await fetchMessages();
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    };

    const fetchMessages = async () => {
        try {
            const response = await fetch(`/channels/${channelId}/messages`);

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const messages = await response.json();
            const ul = document.getElementById('messages');
            ul.innerHTML = '';

            messages.forEach(message => {
                const li = document.createElement('li');
                li.classList.add('message');
                li.innerHTML = `
                    <span class="message__user-name">${message.user.name}</span>
                    <span class="message__sent-at">${message.timestamp}</span>
                    <p class="message__text">${message.text}</p>
                `;
                ul.appendChild(li);
            });
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    };

    const toggleSubmitButton = () => {
        submitBtn.disabled = inputElm.value.trim() === '';
    };

    document.querySelector('.channel__user-name').textContent = JSON.parse(currentUser).name;

    inputElm.addEventListener('input', toggleSubmitButton);
    submitBtn.addEventListener("click", (event) => {
        event.preventDefault();
        postMessage().then(r => console.log('Message sent:', r));
    });
    inputElm.addEventListener("keydown", (event) => {
        if (event.key === "Enter") {
            event.preventDefault();
            submitBtn.click();
        }
    });

    toggleSubmitButton();
    setInterval(fetchMessages, 500);
    fetchMessages().then(r => console.log('Messages fetched:', r));
});