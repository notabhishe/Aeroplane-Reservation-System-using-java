document.addEventListener("DOMContentLoaded", () => {
    // Toggle Password Visibility
    const togglePassword = (inputId, buttonId) => {
        const input = document.getElementById(inputId);
        const button = document.getElementById(buttonId);
        if (input && button) {
            button.addEventListener("click", () => {
                if (input.type === "password") {
                    input.type = "text";
                    button.textContent = "Hide Password";
                } else {
                    input.type = "password";
                    button.textContent = "Show Password";
                }
            });
        }
    };

    togglePassword("password", "togglePasswordBtn");

    // Save User Data to Local Storage
    const saveUserData = (user) => {
        localStorage.setItem("user", JSON.stringify(user));
    };

    // Load User Data for Profile Page
    const loadUserData = () => {
        const user = JSON.parse(localStorage.getItem("user"));
        if (user) {
            const userName = document.getElementById("userName");
            const userEmail = document.getElementById("userEmail");
            if (userName) userName.textContent = user.name;
            if (userEmail) userEmail.textContent = user.email;
        }
    };

    loadUserData();

    // Logout Button
    const logoutButton = document.getElementById("logoutBtn");
    if (logoutButton) {
        logoutButton.addEventListener("click", () => {
            localStorage.removeItem("user");
            alert("You have been logged out.");
            window.location.href = "login.html";
        });
    }
});
