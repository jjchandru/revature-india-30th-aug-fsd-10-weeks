let signup = document.getElementById("submit");
let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let email = document.getElementById("email");
let password = document.getElementById("password");
let error = document.getElementById("error");

error.style.display = "none";

let firstNameError = document.getElementById("firstNameError");
let valid = true;

signup.addEventListener("click", function () {
    // isNaN()
    /*if (firstName.value == "") {
        let firstNameError = document.getElementById("firstNameError");
        firstNameError.innerText = "First name is required";
        let valid = false;
    }*/

    if (valid) {
        addCustomer();
    }
});

async function addCustomer() {
    let customer = {
        firstName: firstName.value,
        lastName: lastName.value,
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
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        //let data = await response.json();
        window.location.href = "login.html";
    } catch (err) {
        error.style.display = "block";
    }
}

firstName.addEventListener("keyup", function () {
    //console.log(firstName.value);
    if (firstName.value != "" && firstName.value.length > 20) {
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        valid = false;
    }

    if (firstName.value != "" && firstName.value.length <= 20) {
        firstNameError.innerText = "";
        valid = false;
    }

    if (firstName.value != "") {
        let pattern = /^[A-Za-z]+$/;
        console.log(firstName.value.match(pattern));
        if (!firstName.value.match(pattern)) {
            firstNameError.innerText = "Numbers not allowed";
        }
        valid = false;
    }
});
