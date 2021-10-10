getAccounts();
async function getAccounts() {
        var options = {
        method: 'GET',
        credentials: 'include'
    };

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts", options);
        let accounts = await response.json();
        console.log(accounts);
        let html = "";
        for (let account of accounts) {
            console.log(account.accountNumber);
            html += 
            `<div class="col-12 col-lg-4 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5>${account.accountNumber}</h5>
                        <div>John Smith</div>
                        <div class="badge badge-success">${account.balance}</div>
                    </div>
                    <div class="card-footer">
                        <a class="btn btn-primary btn-sm" href="transactions.html">View Transactions</a>
                    </div>
                </div>
            </div>`;
        }
        document.getElementById("accounts").innerHTML = html;
    } catch (err) {
        error.style.display = "block";
    }
}