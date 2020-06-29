$(document).ready(function () {
    var pathName = window.location.pathname;
    switch (pathName) {
        case "/TourDeFranceShop/bills.html":
            getBill();
            break;
        case "/TourDeFranceShop/products.html":
            getAllProducts();
            break;
        case "/TourDeFranceShop/repairs.html":
            getRepair();
            break;
    }
});

function getBill() {
    $.ajax({
        method: "GET",
        url: "bikeshop/customer/getBill/" + sessionStorage.getItem("uid") ,
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
        url: "bikeshop/customer/getAllProducts",
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

function getRepair() {
    $.ajax({
        method: "GET",
        url: "bikeshop/customer/getRepair/"+ sessionStorage.getItem("uid"),
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

function getProduct() {
    let productId = document.querySelector("#productId2").value;
    let link = "bikeshop/customer/getProduct/" + productId;
    $.ajax({
        method: "GET",
        url: link,
        dataType: "json",
        success: function (result) {
            alert("You have purchased: " + result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postRegisterBike() { 
    let model = document.querySelector("#bikeModel").value;
    let formData = {model: model};
    $.ajax({
        method: "POST",
        url: "bikeshop/customer/postRegisterBike",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            alert("Registered!")
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function postPayBill() { 
    let billId = document.querySelector("#billId2").value;
    let formData = {billId: billId};
    $.ajax({
        method: "POST",
        url: "bikeshop/customer/postPayBill",
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