// Validation Functions
function isEmailValid(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function isPasswordValid(password) {
    // Minimum eight characters, at least one uppercase letter, one lowercase letter, and one number
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
    return passwordRegex.test(password);
}

// Attach Event Listeners to Forms
document.addEventListener("DOMContentLoaded", () => {
    // Login Form Validation
    const loginForm = document.getElementById("loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            if (!isEmailValid(email)) {
                alert("Please enter a valid email.");
                return;
            }

            if (!password) {
                alert("Password cannot be empty.");
                return;
            }

            alert("Login successful!");
            // Redirect to profile or next page
            window.location.href = "profile.html";
        });
    }

    // Registration Form Validation
    const registrationForm = document.getElementById("registrationForm");
    if (registrationForm) {
        registrationForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const name = document.getElementById("name").value;
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            if (!name.trim()) {
                alert("Name cannot be empty.");
                return;
            }

            if (!isEmailValid(email)) {
                alert("Please enter a valid email.");
                return;
            }

            if (!isPasswordValid(password)) {
                alert(
                    "Password must be at least 8 characters long, include an uppercase letter, a lowercase letter, and a number."
                );
                return;
            }

            alert("Registration successful!");
            // Save to backend or localStorage for simplicity
            localStorage.setItem("user", JSON.stringify({ name, email }));
            window.location.href = "profile.html";
        });
    }

    // Profile Page Load
    const userName = document.getElementById("userName");
    const userEmail = document.getElementById("userEmail");
    if (userName && userEmail) {
        const user = JSON.parse(localStorage.getItem("user"));
        if (user) {
            userName.textContent = user.name;
            userEmail.textContent = user.email;
        } else {
            alert("No user found. Redirecting to login...");
            window.location.href = "login.html";
        }
    }
});
