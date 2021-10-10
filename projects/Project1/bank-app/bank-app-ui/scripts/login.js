let email = document.getElementById("email");
let password = document.getElementById("password");
let message = document.getElementById("message");
message.style.display = "none";

document.getElementById("login").addEventListener("click", function () {
    login();
});

async function login() {
    let customer = {
        email: email.value,
        password: password.value
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json"},
        credentials: 'include',
        body: JSON.stringify(customer)
    };

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/authenticate", options);
        //let data = await response.json();
        if (response.status == 200) {
            message.innerText = "";
            window.location.href = "accounts.html";
        } else if (response.status == 404) {
            message.innerText = "Invalid email / password";
        } else if (response.status == 500) {
            message.innerText = "System Error. Retry or contact Administrator";
        }
    } catch (err) {
        message.innerText = "System Error. Retry or contact Administrator";
    }
}
