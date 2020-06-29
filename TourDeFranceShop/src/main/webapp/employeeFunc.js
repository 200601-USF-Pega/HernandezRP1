$(document).ready(function () {
    var pathName = window.location.pathname;
    switch (pathName) {
        case "/TourDeFranceShop/bills.html":
            getAllBills();
            break;
        case "/TourDeFranceShop/products.html":
            getAllProducts();
            break;
        case "/TourDeFranceShop/repairs.html":
            getAllRepairs();
            break;
    }
});

function getAllBills() {
    $.ajax({
        method: "GET",
        url: "bikeshop/employee/getAllBills",
        dataType: "json",
        success: function (result) {
            var table = document.getElementById("billTableBody");

            for (let x = 0; x < result.length; x++) {
                var row = table.insertRow(x);

                var billIdCell = row.insertCell(0);
                billIdCell.innerHTML = result[x].billId;

                var balanceCell = row.insertCell(1);
                balanceCell.innerHTML = result[x].balance;

                var statusCell = row.insertCell(2);
                statusCell.innerHTML = result[x].status;

                var bikeIdCell = row.insertCell(3);
                bikeIdCell.innerHTML = result[x].bikeId;
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function getAllProducts() {
    $.ajax({
        method: "GET",
        url: "bikeshop/employee/getAllProducts",
        dataType: "json",
        success: function (result) {
            var table = document.getElementById("productTableBody");

            for (let x = 0; x < result.length; x++) {
                var row = table.insertRow(x);

                var productIdCell = row.insertCell(0);
                productIdCell.innerHTML = result[x].productId;

                var nameCell = row.insertCell(1);
                nameCell.innerHTML = result[x].name;

                var descCell = row.insertCell(2);
                descCell.innerHTML = result[x].desc;

                var priceCell = row.insertCell(3);
                priceCell.innerHTML = result[x].price;

                var statusCell = row.insertCell(4);
                statusCell.innerHTML = result[x].status;
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function getAllRepairs() {
    $.ajax({
        method: "GET",
        url: "bikeshop/employee/getAllRepairs",
        dataType: "json",
        success: function (result) {
            var table = document.getElementById("repairTableBody");

            for (let x = 0; x < result.length; x++) {
                var row = table.insertRow(x);

                var repairIdCell = row.insertCell(0);
                repairIdCell.innerHTML = result[x].repairId;

                var bikeIdRow = row.insertCell(1);
                bikeIdRow.innerHTML = result[x].bikeId;

                var statusRow = row.insertCell(2);
                statusRow.innerHTML = result[x].status;
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postEditBill() {
    let billId = document.querySelector("#billID").value;
    let status = document.querySelector("#status").value;
    let formData = { billId: billId, status: status};
    $.ajax({
        method: "POST",
        url: "bikeshop/employee/postEditBill",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postAddBill() { 
    let custId = document.querySelector("#customerId").value;
    let bikeId = document.querySelector("#bikeId").value;
    let balance = document.querySelector("#balance").value;
    let formData = {userId: custId, bikeId: bikeId, balance: balance};
    $.ajax({
        method: "POST",
        url: "bikeshop/employee/postAddBill",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postEditProduct() { 
    let pId = document.querySelector("#productId").value;
    let status = document.querySelector("#status").value;
    let price = document.querySelector("#productPrice").value;
    let formData = {productId: pId, status: status, price: price};
    $.ajax({
        method: "POST",
        url: "bikeshop/employee/postEditProduct",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postAddProduct() { 
    let pName = document.querySelector("#productName").value;
    let price = document.querySelector("#productPrice2").value;
    let desc = document.querySelector("#productDesc").value;

    let formData = {name: pName, price: price, desc: desc};
    $.ajax({
        method: "POST",
        url: "bikeshop/employee/postAddProduct",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postEditRepair() {
    let repairId = document.querySelector("#repairId").value;
    let status = document.querySelector("#status").value;
    let formData = { repairId: repairId, status: status};
    $.ajax({
        method: "POST",
        url: "bikeshop/employee/postEditRepair",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
 }

 function deleteRepairEntry() {
    let repairId = document.querySelector("#repairIdInput").value;
    let formData = { repairId: repairId};
    $.ajax({
        method: "DELETE",
        url: "bikeshop/employee/deleteRepairEntry",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            alert("Item removed");
        },
        error: function (error) {
            console.log(error);
        }
    });
 }