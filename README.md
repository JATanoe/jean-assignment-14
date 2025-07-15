# Chat Application

A real-time chat application built with Spring Boot that allows users to communicate through different channels.

## Technologies Used

- **Backend**: Java, Spring Boot
- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **Data Storage**: In-memory repositories (can be extended to use databases)

## Features

- User authentication (simple username-based login)
- Multiple chat channels
- Real-time message updates
- Responsive design
- Timestamp display for messages

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── coderscampus/
│   │           ├── domain/           # Domain models
│   │           │   ├── Channel.java  # Represents a chat channel
│   │           │   ├── Message.java  # Represents a chat message
│   │           │   └── User.java     # Represents a user
│   │           ├── repository/       # Data access layer
│   │           │   ├── ChannelRepository.java
│   │           │   ├── MessageRepository.java
│   │           │   └── UserRepository.java
│   │           ├── service/          # Business logic layer
│   │           │   ├── ChannelService.java
│   │           │   ├── MessageService.java
│   │           │   └── UserService.java
│   │           ├── web/              # Controllers
│   │           │   └── ChatController.java
│   │           └── Application.java  # Main application class
│   └── resources/
│       ├── static/                   # Static resources
│       │   ├── css/                  # Stylesheets
│       │   │   ├── main.css
│       │   │   ├── reset.css
│       │   │   └── variables.css
│       │   └── js/                   # JavaScript files
│       │       ├── aside.js
│       │       ├── autogrowing-textarea.js
│       │       ├── channel.js
│       │       ├── modal.js
│       │       └── welcome.js
│       └── templates/                # Thymeleaf templates
│           ├── fragments/            # Reusable template fragments
│           │   ├── aside.html
│           │   └── modal.html
│           ├── channel.html          # Chat channel page
│           ├── error.html            # Error page
│           └── welcome.html          # Welcome page
```

## Setup Instructions

1. Ensure you have Java 17 or higher installed
2. Clone the repository
3. Navigate to the project directory
4. Run the application using Maven:
   ```
   ./mvnw spring-boot:run
   ```
   or on Windows:
   ```
   mvnw.cmd spring-boot:run
   ```
5. Open a web browser and navigate to `http://localhost:8080`

## Usage Instructions

1. When you first access the application, you'll be prompted to enter a username
2. After logging in, you'll see the welcome page with a list of available channels
3. Select a channel to join the conversation
4. Type your message in the input field at the bottom of the page and press Enter or click the send button
5. Messages are updated in real-time (every 500ms)

## API Endpoints

- `POST /login` - Log in a user
- `GET /` - Welcome page with channel list
- `GET /channels` - Get all channels (JSON)
- `GET /channels/{id}` - View a specific channel
- `GET /channels/{id}/messages` - Get all messages for a channel (JSON)
- `POST /channels/{id}/messages/create` - Create a new message in a channel

## Future Enhancements

- Persistent storage with a database
- User authentication with passwords
- Private messaging
- File sharing capabilities
- Message editing and deletion
- User online status indicators
- Message read receipts