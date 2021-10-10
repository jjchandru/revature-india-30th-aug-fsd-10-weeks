logout();
async function logout() {
        var options = {
        method: 'GET',
        credentials: 'include'
    };

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/logout", options);
        if (response.status == 200) {
            document.getElementById("message").innerText = "Logged out successfully."
        }
    } catch (err) {
        error.style.display = "block";
    }
}
