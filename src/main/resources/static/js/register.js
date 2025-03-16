function validatePhone(input) {
    var phonePattern = /^[6-9]\d{9}$/;
    var suggestion = document.getElementById("phoneSuggestion");
    if (!phonePattern.test(input.value)) {
        suggestion.textContent = "Phone number must be 10 digits and start with 6, 7, 8, or 9.";
        suggestion.style.color = "red";
    } else {
        suggestion.textContent = "";
    }
}

function validateEmail(input) {
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    var suggestion = document.getElementById("emailSuggestion");
    if (!emailPattern.test(input.value)) {
        suggestion.textContent = "Please enter a valid email address.";
        suggestion.style.color = "red";
    } else {
        suggestion.textContent = "";
    }
}

function validateUsername(input) {
    var suggestion = document.getElementById("usernameSuggestion");
    // Assuming you have a function to check if the username is unique
    if (!isUsernameUnique(input.value)) {
        suggestion.textContent = "Username already exists.";
        suggestion.style.color = "red";
    } else {
        suggestion.textContent = "";
    }
}

function validatePassword(input) {
    var passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    var suggestion = document.getElementById("passwordSuggestion");
    if (!passwordPattern.test(input.value)) {
        suggestion.textContent = "Password must be at least 8 characters long and contain both letters and numbers.";
        suggestion.style.color = "red";
    } else {
        suggestion.textContent = "";
    }
}

// Mock function to check if username is unique
function isUsernameUnique(username) {
    // Replace this with an actual AJAX call to your server to check username uniqueness
    var existingUsernames = ["user1", "user2", "user3"];
    return !existingUsernames.includes(username);
}