const API_URL = "http://localhost:8080/api/v1/users/login";

function isLoggedIn() {
    return localStorage.getItem("token") !== null;
}

function checkAuth() {
    const currentPage = window.location.pathname.split("/").pop();
    if (!isLoggedIn() && currentPage === "home.html") {
        console.log("Not logged in, redirecting to login.html");
        window.location.href = "login.html";
    }
}

function login() {
    console.log("Login button clicked");
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorElement = document.getElementById("error");

    if (!errorElement) {
        console.error("Error element not found");
        return;
    }

    errorElement.textContent = "";

    if (!username || !password) {
        errorElement.textContent = "Please enter username and password";
        console.log("Validation failed: empty username or password");
        return;
    }

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
        .then(response => {
            return response.json().then(result => ({ response, result }));
        })
        .then(({ response, result }) => {
            if (response.ok) {
                localStorage.setItem("token", result.data);
                localStorage.setItem("username", username);
                console.log("Login successful, token:", result.data);
                window.location.href = "home.html";
            } else {
                errorElement.textContent = result.message || "Login failed";
                console.warn("Login failed, response:", result);
            }
        })
        .catch(error => {
            console.error("Login error:", error);
            errorElement.textContent = "Error connecting to server: " + error.message;
        });
}

function logout() {
    console.log("Logout button clicked");
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    console.log("Successfully logged out, token and username removed from localStorage");
    window.location.href = "login.html";
    console.log("Redirected to login page");
}

window.onload = () => {
    console.log("Page loaded:", window.location.pathname);
    checkAuth();
};