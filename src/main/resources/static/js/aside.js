document.addEventListener('DOMContentLoaded', () => {
    const path = window.location.pathname;
    const param = path.split('/')[2];
    const channelId = parseInt(param, 10);

    const fetchChannels = async () => {
        const response = await fetch('/channels');

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        try {
            const channels = await response.json();

            const ul = document.getElementById('channels');
            ul.innerHTML = '';
            channels.forEach(channel => {
                const channelElement = document.createElement('li');
                const channelLink = document.createElement('a');
                channelElement.classList.add('aside__tab');
                if (channel.id === channelId) {
                    channelElement.classList.add('active');
                }
                channelLink.href = `/channels/${channel.id}`;
                channelLink.innerHTML = `<span>#</span>${channel.name}`;
                channelElement.appendChild(channelLink);
                ul.appendChild(channelElement);
            });

        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }

    fetchChannels().then(response => console.log('Channels fetched'));
});
